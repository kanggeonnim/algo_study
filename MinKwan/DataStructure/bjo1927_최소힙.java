package algo_Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bjo1927_최소힙 {

	// 최소 힙 구현
	static class PQ {

		int size;
		List<Long> list = new ArrayList<Long>();

		// 인덱스를 1부터 시작히기 위해서
		public PQ() {
			list.add(0L);
			size++;
		}

		// pq에 노드 삽입
		public void insert(long data) {

			// 최소힙이어서 -1을 곱해서 넣어준다.
			list.add(data * -1);

			// 현재 리스트의 인덱스
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

		// 루트 노드 데이터 반환 후 제거, 마지막 노드를 루트 노드로 가져온 뒤 데이터 정렬
		public void delete() {

			if (list.size() == 1) {
				System.out.println(0);
				return;
			} else
				System.out.println(list.get(1) * -1);

			list.set(1, list.get(list.size() - 1));
			list.remove(list.size() - 1);

			// 루트 노드 제거 후 최신화 완료

			// 이제부터 정렬 수행
			int index = 1;

			while (true) {

				// 정렬을 수행할 수 있는 크기인지
				if (list.size() > index * 2) {
					// 정렬 수행 가능
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
