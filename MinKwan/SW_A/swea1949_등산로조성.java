package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1949_등산로조성 {
	static int N;
	static int K;
	static int ans;
	static int maxHeight;
	static boolean[][] visit;
	static int[][] map;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = 0;
			maxHeight = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (maxHeight < map[i][j])
						maxHeight = map[i][j];
				}
			}

			Queue<Point> q = new LinkedList<Point>();

			// Add highest Mountain in the queue
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxHeight)
						q.add(new Point(i, j));
				}
			}

			// -------------------Input End-------------------
			while (!q.isEmpty()) {
				Point p = q.poll();
				// System.out.println(p.x + " " + p.y );
				visit = new boolean[N][N];
				visit[p.x][p.y] = true;
				DFS(p.x, p.y, false, 1);
			}
			System.out.println("#" + t + " " + ans);
		} // 테스트케이스 for문

	}

	// x,y : coordinate
	// K is skill for digging a mountain

	static void DFS(int x, int y, boolean k, int sum) {

		if (ans < sum)
			ans = sum;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]) {

				// next mountain is shorter than this
				if (map[nx][ny] < map[x][y]) {
					visit[nx][ny] = true;
					DFS(nx, ny, k, sum + 1);
					visit[nx][ny] = false;
				} else { // can i dig mountain?
					if (k == false) {

						for (int j = 1; j <= K; j++) {
							// digged mountain < now mountain
							if (map[nx][ny] - j < map[x][y]) {
								visit[nx][ny] = true;
								map[nx][ny] = map[nx][ny] - j;
								DFS(nx, ny, true, sum + 1);
								visit[nx][ny] = false;
								map[nx][ny] = map[nx][ny] + j;
							}
						}

					}
				}
			}
		}
	}
}