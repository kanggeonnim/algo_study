package bjo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bjo11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken()); // map의 크기
		int m = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 M

		int[][] map = new int[n + 1][n + 1];
		int[][] map2 = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map2[i][j] = map[i][j];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				// System.out.println("구간합 값: " + map2[i][j] + " 기본 맵의 값: " + map[i][j-1]);

				if (j == 1)
					map2[i][j] += map2[i - 1][n];
				else
					map2[i][j] += map2[i][j - 1];

			}
		}

		// 입력 끝.

		//for (int[] ma : map2)
		//	System.out.println(Arrays.toString(ma));

		/*
		 * x1부터 x2까지 y1부터 y2까지
		 */

		/*
		 * 기본 배열 1 2 3 4 2 3 4 5 3 4 5 6 4 5 6 7
		 * 
		 * 누적합 1 3 6 10 12 15 19 24 27 31 36 42 46 51 57 64
		 * 
		 * 경우의 수
		 * 
		 * 1 1 3 2 ans 15
		 * 
		 * 
		 * 24 - 15 = 9 10 - 3 = 7 31 - 16 = 15
		 * 
		 * 2 2 3 4 42 - 27 + 24 - 12 = 27 15 - 12 + 42 - 27 + 64 - 46 =
		 * 
		 * 2 2 3 3 ans = 16 36 - 27 + 19 - 12 = 16
		 */
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int sum = 0;
			int ny = y1 - 1;

			// System.out.println("초기 sum 값 지정: " + sum);

			for (int x = x1; x <= x2; x++) {

				if (ny == 0) {
					sum += map2[x][y2] - map2[x - 1][n];
				} else
					sum += map2[x][y2] - map2[x][ny];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
