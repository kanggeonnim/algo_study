package algo_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



/*
 * 가희가 은행 업무를 시작하면 대기줄에는 손님이 N명 있다.
 * 대기줄의 x번 손님에 대한 정보는 id 값과 업무에 필요한 시간으로 나눠진다.
 * 은행이 영업을 시작하고 난 후에 들어오는 M명의 손님이 있음(미리 와서 대기하는 N명과 다르다) 
 * 이 M명의 사람들은 대기줄 뒤에 순서대로 배치된다. M명의 손님은 영업 시작 x초 뒤에 들어왔다는 정보가 있음
 * 
 * 대기 큐의 맨 앞에 있는 고객의 tx가 T보다 크면 tx-T를 시킴. 그리고 맨 뒤로 이동시킨다. 
 * tx가 T보다 작다면 T-tx 한 뒤에 그 손님을 내보낸다.
 * N: 초기 대기줄 인원 T: 가희가 한번에 쓸 수 있는 시간 W: 영업 종료 시간
 * px: 고객 id tx:고객의 필요 시간 cx:영업 시작 시간으로부터 cx초가 지났을 떄 은행에 들어옴
 * 
 * 큐를 만들어서 고객 대기줄 형성
 * while 반복문을 통해 w가 될 때까지 고객 응대
 */

public class bjo22234_가희와은행 {

	// 손님 클래스
	static class Customer {
		public int px;
		public int tx;
		public int cx;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken()); // 대기열의 손님 수
		int t = Integer.parseInt(st.nextToken()); // 손님 한 명에 사용 가능 시간
		int w = Integer.parseInt(st.nextToken()); // 영업 종료 시간
		int m = 0;
		Queue<Customer> queue = new LinkedList<>();
		PriorityQueue<Customer> pQueue = new PriorityQueue<>(new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				if (o1.cx < o2.cx) {
					return -1;
				} else if (o1.cx == o2.cx) {
					return 0;
				} else
					return 1;
			}
		});

		// 대기열 손님 등록
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Customer customer = new Customer();

			customer.px = Integer.parseInt(st.nextToken());
			customer.tx = Integer.parseInt(st.nextToken());
			customer.cx = 0;

			queue.add(customer);
		}

		// 추가 고객 대기열 등록
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		Customer[] customerAry = new Customer[m];

		// 추가 고객 대기열 등록
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			Customer customer = new Customer();

			customer.px = Integer.parseInt(st.nextToken());
			customer.tx = Integer.parseInt(st.nextToken());
			customer.cx = Integer.parseInt(st.nextToken());

			pQueue.add(customer);

		}

		// 입력 종료

		// 마감시간 for문
		for (int i = 0; i < w;) {

			Customer customer = queue.peek();
//			System.out.println("큐 사이즈: " +queue.size());
//			System.out.println("i " + i);

			// 큐의 손님들 처리
			for (int j = 0; j < t; i++, j++) {

				if (customer.tx == 0 || i == w) {

					customer = null;
					queue.remove();

					break;
				}

				customer.tx--;

				System.out.println(customer.px);

			}

			// 새로운 손님 받기
			if (!pQueue.isEmpty()) {
				for (int k = 0; k < pQueue.size(); k++) {
					Customer newCustomer = pQueue.peek();
					// System.out.println("새로운 손님 받기 " + newCustomer.cx + " " + i);

					if (newCustomer.cx <= i) {
						// System.out.println("새로운 고객 삽입");
						queue.add(newCustomer);
						// System.out.println(queue.size());
						pQueue.remove();
					} else
						break;
				}
			}

			// 손님의 작업이 남으면 큐 맨 뒤로 이동
			if (customer != null && customer.tx > 0) {
				queue.add(customer);
				queue.remove();
			}

		}
	}

}
