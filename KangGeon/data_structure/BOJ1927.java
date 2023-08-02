import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	private long[] heap;
	private int MAX = 100001;
	private int idx;

	public Main() {
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Main heap = new Main();
		for (int i = 0; i < n; i++) {
			long num = Integer.parseInt(br.readLine());
			if (num == 0) {
				System.out.println(heap.remove());
			} else {
				heap.insert(num);
			}
		}
	}

}