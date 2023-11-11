package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea7465_창용마을 {
	static int N;
	static int M;
	static int[] parents;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = N;
			makeParents();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (Union(a, b))
					ans--;

			}

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void makeParents() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int Find(int a) {
		if (a == parents[a])
			return parents[a];

		return parents[a] = Find(parents[a]);
	}

	static boolean Union(int a, int b) {
		int left = Find(a);
		int right = Find(b);

		if (left == right)
			return false;

		parents[right] = a;
		return true;
	}
}
