package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17281 {
	static boolean[] visited;
	static boolean[] base;
	static int[] result;
	static int[][] array;
	static int N, ans, outCount, innings;
	static final int MEMBER_NUM = 9;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		array = new int[N + 1][10];
		visited = new boolean[MEMBER_NUM + 1];
		result = new int[MEMBER_NUM + 1];
		ans = 0;
		innings = 1;
		// 1번 타자는 항상 4번위치에서 침.
		visited[1] = true;
		result[4] = 1;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= MEMBER_NUM; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= MEMBER_NUM; j++) {
//				System.out.print(array[i][j] + " ");
//			}
//			System.out.println();
//		}

		perm(1);
		System.out.println(ans);
	}

	private static void perm(int cnt) {
		if (cnt == MEMBER_NUM + 1) {
			findScore();
			return;
		}

		for (int i = 2; i <= MEMBER_NUM; i++) {
			if (!visited[i]) {
				if (cnt == 4) {
					cnt++;
				}
				visited[i] = true;
				result[cnt] = i;
				perm(cnt + 1);
				visited[i] = false;
			}

		}
	}

	private static void findScore() {
		int sum = 0;
		base = new boolean[5];
		for (int i = 1;; i++) {
			if (innings == N + 1) {
				innings = 1;
				break;
			}
			if (i == 10)
				i = 1;

			int member = result[i];
			int hits = array[innings][member];

			// 아웃
			if (hits == 0) {
				outCount++;
				if (outCount == 3) { // 삼진아웃이면
					base = new boolean[5];
					outCount = 0;
					innings++;

				}
			} else {
				// 1,2,3루를 검사해서 안타 하나당 선수를 전진시키며 점수를 얻음.
				for (int j = 3; j >= 1; j--) {
					if (base[j]) {
						if (j + hits >= 4) { // 주자가 안타로인해서 홈으로 갈수있으면
							sum += 1;
							base[j] = false;
						} else {
							base[j + hits] = base[j];
							base[j] = false;
						}
					}
				}
				base[hits] = true;
				if (hits == 4) {
					sum += 1;
				}

			}
		}
//		if (ans < sum)
//
//		{
//			System.out.println(Arrays.toString(result));
//		}
		ans = Math.max(ans, sum);
	}

}
