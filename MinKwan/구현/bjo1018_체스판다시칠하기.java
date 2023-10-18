package solvedAc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bjo1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int ans = Integer.MAX_VALUE;
		int sx = 0;
		int sy = 0;

		// 좌상단 W일때
		int sum = 0;

		while (true) {

			if (sy + 8 > m) {
				sx += 1;
				sy = 0;
			}
			if (sx + 8 > n)
				break;

			// 좌상단 W일때
			for (int i = sx; i < sx + 8; i++) {
				for (int j = sy; j < sy + 8; j++) {
					{
						if (i % 2 == 0) {

							// W
							if (j % 2 == 0) {
								if (map[i][j] != 'W')
									sum++;
							}
							// B
							else {
								if (map[i][j] != 'B')
									sum++;
							}

						} else {

							if (j % 2 == 0) {
								if (map[i][j] != 'B')
									sum++;
							} else {
								if (map[i][j] != 'W')
									sum++;
							}

						}
					}
				}
			} // 좌상단 'W' 비교 시작 for문

			if (sum < ans)
				ans = sum;
			sum = 0;

			// 좌상단 B일때
			for (int i = sx; i < sx + 8; i++) {
				for (int j = sy; j < sy + 8; j++) {
					{
						if (i % 2 == 0) {

							// W
							if (j % 2 == 0) {
								if (map[i][j] != 'B')
									sum++;
							}
							// B
							else {
								if (map[i][j] != 'W')
									sum++;
							}

						} else {

							if (j % 2 == 0) {
								if (map[i][j] != 'W')
									sum++;
							} else {
								if (map[i][j] != 'B')
									sum++;
							}

						}
					}
				}
			} // 좌상단 'B' 비교 시작 for문

			if (sum < ans)
				ans = sum;
			sum = 0;

			sy++;

		} // 좌상단 W while for문

		System.out.println(ans);
	}
}
