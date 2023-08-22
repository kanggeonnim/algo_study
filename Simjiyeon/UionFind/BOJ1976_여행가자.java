import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976_여행가자 {

	static int N, M;
	static int[] parents;

	private static void Make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	private static int Find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = Find(parents[a]);
	}

	private static boolean Union(int a, int b) {
		int rootA = Find(a);
		int rootB = Find(b);

		if (rootA == rootB) {
			return false;
		}

		parents[rootB] = rootA;
		return true;
	}

	private static boolean Search(int a, int b) {
		Find(a);
		Find(b);
		System.out.println(parents[a] + " =? " + parents[b]);
		if (parents[a] == parents[b]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Make();
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = i; j < N; j++) {
				int map = Integer.parseInt(st.nextToken());
				if (map == 1) {
					Union(i, j);
				}
			}
		}
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken())-1;
		}

		for (int i = 1; i < N; i++) {
			System.out.println(arr[i - 1] + ", " + arr[i] + ": 비교해보자");
			if (!Search(arr[i - 1], arr[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}// main

}
