package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;

public class bjo1927_최소힙 {

	static class minkwan {

		List<Long> tree;

		public minkwan() {
			tree = new ArrayList<>();
			tree.add(0L);
		}

		public void Insert(Long data) {
			data *= -1;
			tree.add(data);

			if (tree.size() == 2) {
				return;
			} else {
				int index = tree.size() - 1;

				while (true) {
					if (tree.get(index / 2) < tree.get(index)) {
						long temp = tree.get(index / 2);
						tree.set(index / 2, tree.get(index));
						tree.set(index, temp);
						index = index / 2;

						if (index == 1)
							break;
					} else {
						break;
					}
				}
			}
		}

		public void Delete() {
			// 힙의 루트 노드와 마지막 노드를 바꾼다.
			if (tree.size() == 1) {
				System.out.println(0);
				return;
			}

			System.out.println(tree.get(1) * -1);
			tree.set(1, tree.get(tree.size() - 1));
			tree.remove(tree.size() - 1);

			int index = 1;
			// 트리 재구성
			while (true) {

				if ((tree.size() > index * 2) && tree.get(index) < tree.get(index * 2)) {
					long temp = tree.get(index);
					tree.set(index, tree.get(index * 2));
					tree.set(index * 2, temp);
					index *= 2;
					continue;
				} else if ((tree.size() > index * 2 + 1) && tree.get(index) < tree.get(index * 2 + 1)) {
					long temp = tree.get(index);
					tree.set(index, tree.get(index * 2 + 1));
					tree.set(index * 2 + 1, temp);
					index *= 2 + 1;
					continue;
				}

				break;

			}
		}

		public void Print() {

			for (long a : tree) {
				System.out.print(a + " ");
			}
			System.out.println();
			System.out.println("--------------------");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
		minkwan queue = new minkwan();
		for (int i = 0; i < n; i++) {
			long val = Long.parseLong(sc.readLine());
			if (val == 0) {
				queue.Delete();
			} else {
				queue.Insert(val);
			}
		}

	}

}
