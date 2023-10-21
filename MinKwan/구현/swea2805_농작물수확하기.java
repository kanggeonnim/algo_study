package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea2805_농작물수확하기 {
	static int N;
	static int half;
	static boolean[][] visit;
	static int[][] map;
	static int ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			half = N / 2;
			visit = new boolean[N][N];
			map = new int[N][N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';

				}

			}

			harvest(half, half);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void harvest(int x, int y) {

		int sum = 0;

		// 남쪽부터 시작
		for (int i = half; i >= 0; i--) {

			for (int j = 0; j <= i; j++) {
				int nx = x + i - j;
				int ny_left = y - j;
				int ny_right = y + j;

				if (nx < N && ny_left >= 0 && !visit[nx][ny_left]) {
					sum += map[nx][ny_left];
					visit[nx][ny_left] = true;
				}

				if (nx < N && ny_right < N && !visit[nx][ny_right]) {
					sum += map[nx][ny_right];
					visit[nx][ny_right] = true;
				}
			}
		}

		// 북쪽 탐색 시작
		for (int i = half; i >= 0; i--) {

			for (int j = 0; j <= i; j++) {
				int nx = x - i + j;
				int ny_left = y - j;
				int ny_right = y + j;

				if (nx >= 0 && ny_left >= 0 && !visit[nx][ny_left]) {
					sum += map[nx][ny_left];
					visit[nx][ny_left] = true;
				}

				if (nx >= 0 && ny_right < N && !visit[nx][ny_right]) {
					sum += map[nx][ny_right];
					visit[nx][ny_right] = true;
				}
			}
		}

		ans = Math.max(ans, sum);

	}

}
