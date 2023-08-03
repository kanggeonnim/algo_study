package algo_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
		int t = Integer.parseInt(st.nextToken()); // 사용 가능 시간
		int w = Integer.parseInt(st.nextToken()); // 영업 종료 시간
		int m = 0;
		Queue<Customer> queue = new LinkedList<>();
		Queue<Customer> newCustomerQueue = new LinkedList<>();
		// 대기열 등록
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

			customerAry[i] = customer;

		}

		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				if (customerAry[i].cx > customerAry[j].cx) {
					Customer temp = customerAry[i];
					customerAry[i] = customerAry[j];
					customerAry[j] = temp;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			newCustomerQueue.add(customerAry[i]);
		}

		// -----------------가희 일 시작----------------------

		// N: 초기 대기줄 인원 T: 가희가 한번에 쓸 수 있는 시간 W: 영업 종료 시간
		// px: 고객 id tx:고객의 필요 시간 cx:영업 시작 시간으로부터 cx초가 지났을 떄 은행에 들어옴
		long time = 1;

		// 가희의 고객 응대 시작

		while (w > 0) {

			// System.out.println("W: " + w + " Time : " + time);
			// 큐가 비어있지 않고, 가희의 체력이 남아 있는 상태라면

			if (queue.isEmpty() && newCustomerQueue.isEmpty())
				break;

			Customer next = newCustomerQueue.peek();

			if (!queue.isEmpty()) {

				// 큐의 맨 앞 손님을 받아오기
				Customer customer = queue.peek();

				// 현재 시간이 고객의 은행 입장 시간보다 크거나 같다면
				if (time >= customer.cx) {

					// System.out.println(customer.px);
					// 고객이 필요한 시간이 더 많으면 시간 차감하고 큐의 맨 뒤로 보내기, 고객님 다음에 오세요~

					if (customer.tx > t) {

						if (w < t) {
							for (int i = 0; i < w; i++) {
								sb.append(customer.px + "\n");
							}
						} else {
							for (int i = 0; i < t; i++) {
								sb.append(customer.px + "\n");
							}
						}

						customer.tx -= t;
						time += t;
						w -= t;

						if (next != null && next.cx <= time) {
							{
								if (!newCustomerQueue.isEmpty()) {
									for (int i = 0; i < newCustomerQueue.size(); i++) {
										if (newCustomerQueue.peek().cx <= time) {
											queue.add(newCustomerQueue.poll());
										} else
											break;
									}
								}
							}
						}

						queue.add(customer);
						queue.remove();

					} else if (customer.tx <= t) {

						if (w < customer.tx) {
							for (int i = 0; i < w; i++) {
								sb.append(customer.px + "\n");
							}
						} else {
							for (int i = 0; i < customer.tx; i++) {
								sb.append(customer.px + "\n");
							}
						}

						w -= customer.tx;
						time += customer.tx;
						customer.tx = 0;

						queue.remove();

						if (next != null && next.cx <= time) {
							if (!newCustomerQueue.isEmpty()) {
								for (int i = 0; i < newCustomerQueue.size(); i++) {
									if (newCustomerQueue.peek().cx <= time) {
										queue.add(newCustomerQueue.poll());
									} else
										break;
								}
							}
						}

					}

				} else {
					w = (int) (w - ( customer.cx - time));
					time = customer.cx;
				}
				// 큐가 비었을때?
			} else {

				if (!newCustomerQueue.isEmpty()) {
					for (int i = 0; i < newCustomerQueue.size(); i++) {

						queue.add(newCustomerQueue.poll());

					}
				}

			}

		}

		System.out.println(sb);

	}

}
