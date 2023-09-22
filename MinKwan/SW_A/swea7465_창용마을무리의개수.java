import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea7465_창용마을무리의개수 {

	static int[] parents;
	static int n;
	static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 사람 수
			m = Integer.parseInt(st.nextToken()); // 관계 수
			int ans = n;
			makeParents();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (Union(a, b) == true)
					ans--;

				
			}
			
			System.out.println("#" + t + " " + ans);

		}

	}

	static void makeParents() {
		parents = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	// 대표자 찾기
	static int Find(int x) {
		if (x == parents[x])
			return parents[x];

		return Find(parents[x]);
	}

	static boolean Union(int a, int b) {
		int leftParent = Find(a);
		int rightParent = Find(b);

		//같은 대표자이므로 false 반환
		if (leftParent == rightParent)
			return false;

		// 대표자끼리 Union
		parents[rightParent] = leftParent;
		return true;
	}

}
