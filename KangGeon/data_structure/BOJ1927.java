package algorithm;

import java.util.Scanner;

public class BOJ1927 {
	private long[] heap;
	private int MAX = 100001;
	private int idx;

	public BOJ1927() {
		heap = new long[MAX];
		idx = 0;
		;
	}

	public void insert(long num) {
		heap[++idx] = num;

		int cur = idx;
		while (true) {
			if (cur == 1) {
				break;
			}
			int parent = cur / 2;
			if (heap[parent] > heap[cur]) {
				long tmp = heap[cur];
				heap[cur] = heap[parent];
				heap[parent] = tmp;
				cur = parent;
			} else {
				break;
			}

		}
	}

	public long remove() {
		if (idx == 0) {
			return 0;
		}
		long remove = heap[1];
		heap[1] = heap[idx--];

		int parent = 1;
		while (true) {
			if (parent * 2 > idx) {
				break;
			}
			int cur = (heap[parent * 2] < heap[(parent * 2) + 1] ? parent * 2 : (parent * 2) + 1);
			if (heap[parent] > heap[cur]) {
				long tmp = heap[cur];
				heap[cur] = heap[parent];
				heap[parent] = tmp;
				parent = cur;
			} else {
				break;
			}
		}
		return remove;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BOJ1927 heap = new BOJ1927();
		for (int i = 0; i < n; i++) {
			long num = sc.nextLong();
			if (num == 0) {
				System.out.println(heap.remove());
			} else {
				heap.insert(num);
			}
		}
	}

}
