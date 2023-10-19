package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1210_ladder1 {

	static int[][] map;

	static int[] dx = { 0, 0, -1 };
	static int[] dy = { -1, 1, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			br.readLine();
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sx = 0, sy = 0;

			for (int i = 0; i < 100; i++) {
				if (map[99][i] == 2) {
					sx = 99;
					sy = i;
				}
			}

			while (true) {
				// System.out.println(sx + " " + sy);
				if (sx == 0)
					break;

				for (int i = 0; i < 3; i++) {
					int nx = sx + dx[i];
					int ny = sy + dy[i];

					if (nx < 0 || ny < 0 || ny > 99 || map[nx][ny] == 0)
						continue;

					map[sx][sy] = 0;
					sx = nx;
					sy = ny;

					break;

				}
			}

			sb.append("#").append(t).append(" ").append(sy).append("\n");

		}

		System.out.println(sb);

	}

}
