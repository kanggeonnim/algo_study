package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Process implements Comparable<Process> {
	int p_id;
	int task;
	int enter_t;

	Process(int p_id, int task, int enter_t) {
		this.p_id = p_id;
		this.task = task;
		this.enter_t = enter_t;
	}

	@Override
	public int compareTo(Process o) {
		if (this.enter_t > o.enter_t) {
			return 1;
		} else if (this.enter_t < o.enter_t) {
			return -1;
		} else
			return 0;
	}
}

// N == 대기줄 손님 수
// T == 한번에 처리할수있는 처리량
// W == 은행의 운영시간
// M == 영업시작후 들어오는 손님수
// Px == 손님아이디
// tx == 손님의 업무량
// cx == 들어온 시간
public class BOJ22234 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static LinkedList<Process> que = new LinkedList<Process>();

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		// 은행 오픈전 들어오는 손님
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p_id = Integer.parseInt(st.nextToken());
			int task = Integer.parseInt(st.nextToken());
			que.add(new Process(p_id, task, 0));
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		// 은행 오픈 후 들어오는 손님
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p_id = Integer.parseInt(st.nextToken());
			int task = Integer.parseInt(st.nextToken());
			int enter_t = Integer.parseInt(st.nextToken());
			que.add(new Process(p_id, task, enter_t));
		}

		Collections.sort(que);

//		for (Process p : que) {
//			System.out.println("p_id: " + p.p_id + " enter_t:" + p.enter_t + "task" + p.task);
//		}

		// 은행 업무 시작!~
		int t = T; // 처리량
		Process cur = que.removeFirst(); // 작업할 프로세스의 주소
		Process out;
		for (int i = 1; i <= W; i++) {
			// 프로세스 교체하기
			// 최대 업무량 도달 or 고객의 업무가 끝
			if (t == 0 || cur.task == 0) {
//				for (Process p : que) {
//					System.out.println("p_id: " + p.p_id + " enter_t:" + p.enter_t + "task" + p.task);
//				}

				out = cur; // 현재 고객 내보내기
				if (out.task != 0) { // 기존 업무가 남아있다면 다시 줄서라!
					// 나간시간을 입장시간 다음으로 설정해서 대기큐에 넣기
					out.enter_t = i;
					// 넣을 위치 찾기
					if (que.isEmpty()) { // 대기하던 사람이 없으면 바로 뒤에 대기.
						que.addFirst(out);
					} else { // 대기하는 사람이 있으면 들어온시간 계산해서 줄서기.
						for (int j = 0; j < que.size(); j++) {
							Process p = que.get(j);
							if (p.enter_t > i) {
								que.add(j, out);
								break;
							}
						}
					}
				}
				cur = que.removeFirst();
				// 업무수행량 회복
				t = T;
			}

			//bw.append("cur_id: " + cur.p_id + " cur_task: " + cur.task + "\n");
			bw.append(cur.p_id + "\n");
			bw.flush();

			cur.task = cur.task - 1;
			t = t - 1;
		}
	}
}
