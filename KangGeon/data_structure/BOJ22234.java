package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Process implements Comparable<Process> {
	int p_id;
	int task;
	int enter_t;
	int wait_n;

	Process(int p_id, int task, int enter_t, int wait_n) {
		this.p_id = p_id;
		this.task = task;
		this.enter_t = enter_t;
		this.wait_n = wait_n;
	}

	@Override
	public int compareTo(Process o) {
		int r = Integer.compare(this.enter_t, o.enter_t);
		if (r == 0) {
			return this.wait_n - o.wait_n;
		} else {
			return r;
		}

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
	static PriorityQueue<Process> que = new PriorityQueue<Process>();
	static int wait_n = 0;

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
			que.add(new Process(p_id, task, 0, wait_n++));
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		// 은행 오픈 후 들어오는 손님
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p_id = Integer.parseInt(st.nextToken());
			int task = Integer.parseInt(st.nextToken());
			int enter_t = Integer.parseInt(st.nextToken());
			que.add(new Process(p_id, task, enter_t, wait_n++));
		}

//		for (Process p : que) {
//			System.out.println("pid: " + p.p_id + " en_t: " + p.enter_t);
//		}
		// 은행 업무 시작!~
		int t = T; // 처리량
		Process cur = que.poll(); // 작업할 프로세스의 주소
		Process old;
		for (int i = 0; i < W; i++) {
			// 프로세스 교체하기
			// 최대 업무량 도달 or 고객의 업무가 끝
			if (t == 0 || cur.task == 0) {
				old = cur;
				if (old.task != 0) { // 기존 업무가 남아있다면 다시 줄세우기
					old.enter_t = i;
					old.wait_n = wait_n++;
					if (!que.isEmpty()) {
						cur = que.poll();
						if (old.enter_t >= cur.enter_t) {
							que.add(old);
						} else {
							que.add(cur);
							cur = old;
						}
					}
				}else {
					cur = que.poll();
				}
				// 리스트 내에서 가장 우선순위가 높은 작업 꺼내쓰기
				
				// 업무수행량 회복
				t = T;
			}

			bw.append(cur.p_id + "\n");
			bw.flush();

			cur.task = cur.task - 1;
			t = t - 1;
		}
	}
}