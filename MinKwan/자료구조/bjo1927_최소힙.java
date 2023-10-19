package algo_Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bjo1927_�ּ��� {

	// �ּ� �� ����
	static class PQ {

		int size;
		List<Long> list = new ArrayList<Long>();

		// �ε����� 1���� �������� ���ؼ�
		public PQ() {
			list.add(0L);
			size++;
		}

		// pq�� ��� ����
		public void insert(long data) {

			// �ּ����̾ -1�� ���ؼ� �־��ش�.
			list.add(data * -1);

			// ���� ����Ʈ�� �ε���
			int index = list.size() - 1;

			while (index > 1) {

				if (list.get(index) > list.get(index / 2)) {
					long temp = list.get(index);
					list.set(index, list.get(index / 2));
					list.set(index / 2, temp);
					index = index / 2;
				} else
					break;
			}

		}

		// ��Ʈ ��� ������ ��ȯ �� ����, ������ ��带 ��Ʈ ���� ������ �� ������ ����
		public void delete() {

			if (list.size() == 1) {
				System.out.println(0);
				return;
			} else
				System.out.println(list.get(1) * -1);

			list.set(1, list.get(list.size() - 1));
			list.remove(list.size() - 1);

			// ��Ʈ ��� ���� �� �ֽ�ȭ �Ϸ�

			// �������� ���� ����
			int index = 1;

			while (true) {

				// ������ ������ �� �ִ� ũ������
				if (list.size() > index * 2) {
					// ���� ���� ����
					long min = list.get(index * 2);
					int minPos = index * 2;

					//System.out.println(min);

					if (list.size() > (index * 2) + 1 && list.get((index * 2) + 1) > min) {
						min = list.get((index * 2) + 1);
						minPos = (index * 2) + 1;
					}

					if (min > list.get(index)) {
						long temp = list.get(index);
						list.set(index, list.get(minPos));
						list.set(minPos, temp);
						index = minPos;
					} else
						break;
				} else
					break;
			}
		}

		public void Print() {
			for (long a : list) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		PQ pq = new PQ();

		for (int i = 0; i < n; i++) {
			int val = sc.nextInt();
			if (val == 0) {
				pq.delete();

			} else
				pq.insert(val);

			//pq.Print();
		}

	}

}
