package algo_Study;

import java.util.Scanner;

public class bjo1976_여행가자 {

	static int N;
	static int M;
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		parents = new int[N + 1];
		MakeSet();

		// 모든 도시들의 연결관계를 유니온 파인드로 구성한다.
		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= N; j++) {
				int val = sc.nextInt();

				if (val == 1) {
					Union(i, j);
					// System.out.println();
				}
			}

//			for (int k = 1; k <= N; k++) {
//				System.out.print(parents[k] + " ");
//			}
		}

		int[] trips = new int[M];

		for (int i = 0; i < M; i++)
			trips[i] = sc.nextInt();

		int val = Find(trips[0]);
		for (int i = 0; i < trips.length; i++) {
			if (val != Find(trips[i])) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");

	}

	static void MakeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int Find(int x) {
		if (x == parents[x])
			return x;

		return Find(parents[x]);
	}

	static void Union(int a, int b) {
		int aRoot = Find(a);
		int bRoot = Find(b);

		if (aRoot == bRoot)
			return;

		parents[bRoot] = aRoot;
	}

}
