package homework;

import java.util.Scanner;

public class bjo2961_도영이가만든맛있는음식 {

	static class Node {
		int a;
		int b;

		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static boolean[] visit;
	static int N;
	static Node[] arr;
	static long ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new Node[N];
		visit = new boolean[N];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i] = new Node(a, b);
		}

		subset(0);
		System.out.println(ans);

	}

	
	public static void subset(int cnt) {

		if (cnt == N) {
			
			long sum = 1;
			long sum2 = 0;
			int count = 0;

			for (int i = 0; i < N; i++) {
				if (visit[i] == true) {
					sum *= arr[i].a;
					sum2 += arr[i].b;
					count++;
				}
			}
			
//			System.out.println("신맛 " + sum);
//			System.out.println("쓴맛 " + sum2);
//			System.out.println("Count: " + count);

			if (count == 0 )
				return;

			ans = Math.min(ans, Math.abs(sum - sum2));

			return;
		}

		visit[cnt] = true;
		subset(cnt + 1);
		visit[cnt] = false;
		subset(cnt + 1);
	}
}
