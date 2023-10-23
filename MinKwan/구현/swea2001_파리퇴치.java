package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2001_파리퇴치 {

	static int N;
	static int M;
	static int[][] map;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					BugKill(i, j, 0);
				}
			}
			
			System.out.println("#" + t + " " + ans);

		}
	}

	static void BugKill(int x, int y, int sum) {

		// 남 , 동
		for (int i = 0; i < M; i++) {
			int nx = x + i;

			if (nx < 0 || nx >= N) {
				continue;
			}
			for (int j = 0; j < M; j++) {
				int ny = y + j;

				if (ny >= 0 && ny < N) {
					sum += map[nx][ny];
				}

			}
		}
		
		ans = Integer.max(sum, ans);
	}
}
