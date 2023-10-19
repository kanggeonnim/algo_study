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
 * ���� ���� ������ �����ϸ� ����ٿ��� �մ��� N�� �ִ�.
 * ������� x�� �մԿ� ���� ������ id ���� ������ �ʿ��� �ð����� ��������.
 * ������ ������ �����ϰ� �� �Ŀ� ������ M���� �մ��� ����(�̸� �ͼ� ����ϴ� N��� �ٸ���) 
 * �� M���� ������� ����� �ڿ� ������� ��ġ�ȴ�. M���� �մ��� ���� ���� x�� �ڿ� ���Դٴ� ������ ����
 * 
 * ��� ť�� �� �տ� �ִ� ���� tx�� T���� ũ�� tx-T�� ��Ŵ. �׸��� �� �ڷ� �̵���Ų��. 
 * tx�� T���� �۴ٸ� T-tx �� �ڿ� �� �մ��� ��������.
 * N: �ʱ� ����� �ο� T: ���� �ѹ��� �� �� �ִ� �ð� W: ���� ���� �ð�
 * px: �� id tx:���� �ʿ� �ð� cx:���� ���� �ð����κ��� cx�ʰ� ������ �� ���࿡ ����
 * 
 * ť�� ���� �� ����� ����
 * while �ݺ����� ���� w�� �� ������ �� ����
 */

public class bjo22234_��������� {

	// �մ� Ŭ����
	static class Customer {
		public int px;
		public int tx;
		public int cx;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken()); // ��⿭�� �մ� ��
		int t = Integer.parseInt(st.nextToken()); // �մ� �� �� ��� ���� �ð�
		int w = Integer.parseInt(st.nextToken()); // ���� ���� �ð�
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

		// ��⿭ �մ� ���
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Customer customer = new Customer();

			customer.px = Integer.parseInt(st.nextToken());
			customer.tx = Integer.parseInt(st.nextToken());
			customer.cx = 0;

			queue.add(customer);
		}

		// �߰� �� ��⿭ ���
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		Customer[] customerAry = new Customer[m];

		// �߰� �� ��⿭ ���
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			Customer customer = new Customer();

			customer.px = Integer.parseInt(st.nextToken());
			customer.tx = Integer.parseInt(st.nextToken());
			customer.cx = Integer.parseInt(st.nextToken());

			pQueue.add(customer);

		}

		// �Է� ����

		// �����ð� for��
		for (int i = 0; i < w;) {

			Customer customer = queue.peek();
//			System.out.println("ť ������: " +queue.size());
//			System.out.println("i " + i);

			// ť�� �մԵ� ó��
			for (int j = 0; j < t; i++, j++) {

				if (customer.tx == 0 || i == w) {

					customer = null;
					queue.remove();

					break;
				}

				customer.tx--;

				System.out.println(customer.px);

			}

			// ���ο� �մ� �ޱ�
			if (!pQueue.isEmpty()) {
				for (int k = 0; k < pQueue.size(); k++) {
					Customer newCustomer = pQueue.peek();
					// System.out.println("���ο� �մ� �ޱ� " + newCustomer.cx + " " + i);

					if (newCustomer.cx <= i) {
						// System.out.println("���ο� �� ����");
						queue.add(newCustomer);
						// System.out.println(queue.size());
						pQueue.remove();
					} else
						break;
				}
			}

			// �մ��� �۾��� ������ ť �� �ڷ� �̵�
			if (customer != null && customer.tx > 0) {
				queue.add(customer);
				queue.remove();
			}

		}
	}

}
