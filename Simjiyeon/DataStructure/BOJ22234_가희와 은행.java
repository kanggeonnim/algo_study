package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ22234_가희와은행 {

	public static class Cus {
		int id;
		int time;
		int com;

		Cus() {
		}

		Cus(int id, int time, int com) {
			this.id = id;
			this.time = time;
			this.com = com;
		}

		public void deltime() {
			this.time--;
		}

		@Override
		public String toString() {
			return "Cus [id=" + id + ", time=" + time + ", com=" + com + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Cus> q = new LinkedList();
		PriorityQueue<Cus> queue = new PriorityQueue<>((Cus a, Cus b) -> a.com > b.com ? 1 : -1);

		int N, T, W, M;

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {// 먼저 생긴 대기 손님
			StringTokenizer tk1 = new StringTokenizer(br.readLine());

			int id = Integer.parseInt(tk1.nextToken());
			int time = Integer.parseInt(tk1.nextToken());
			// 배열에 저장

			Cus c1 = new Cus(id,time,i-N);

			// 큐에 추가
			q.add(c1);
			// arraylist 추가 (고객 정보)
		}
		// 2번째 줄 입력 처리완료
		StringTokenizer tk2 = new StringTokenizer(br.readLine());
		M = Integer.parseInt(tk2.nextToken());
		for (int i = 0; i < M; i++) {
			StringTokenizer tk3 = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(tk3.nextToken());
			int time = Integer.parseInt(tk3.nextToken());
			int arrive = Integer.parseInt(tk3.nextToken());
			// 배열에 저장
			Cus c2 = new Cus(id, time, arrive);
			// 큐에 추가
			queue.add(c2);
			// arraylist 추가 (고객 정보)
		}
		// 시간 순으로 정렬

		// 창구
		// T만큼을 기준으로 while 문을 돌린다.
		// T를 원래시간으로 초기화한다.
		// 1. 큐에서 손님 빼기 2. n초에 있는 손님 출력 3. if T--; tx--; 4.if tx==0 || T==0 이 되면 if)
		// tx>0 이면 큐 뒤에 넣기 if) tx==0이면 새로운 큐에서 손님 빼내기
		// 먼저 온 손님과 나중에 온 손님의 queue를 다르게 짜서 먼저 온 손님의 queue가 끝나면 원래 있던 손님들의 queue에 넣어서 처리
		// part1 먼저 온 손님 처리
		// part2 나중에 온 손님 + 먼저 온 손님 처리
		// while문이 돌아가면 시간--;


		Cus cus;
		// 손님빼기
		int time = T;
		int w = 0;
		while (w < W) {

			cus = q.peek();
			if (cus == null) {
				break;
			}
//			System.out.println(cus);
			System.out.println(cus.id); // 현재 있는 손님 번호 출력

			cus.deltime(); // 손님 시간 줄이기
			time--;
			w++;
//			System.out.println("time: "+time+", w :"+w);
			if(queue.isEmpty()==false&&w==queue.peek().com) {
				
				Cus c = queue.peek();
//				System.out.println(c);
				q.add(c);
				queue.remove();
			}
			
			if (time <= 0 && cus.time >= 1) {
//				System.out.println("현재 준비한 시간이 소진되었습니다. 다시 뒤로 가서 기다리세요.");
//				System.out.println(cus);
				q.remove();
				q.add(cus);
				time = T;
			}else if (cus.time <= 0) {
				q.remove();
				time = T;
			}
		}

	}

}
