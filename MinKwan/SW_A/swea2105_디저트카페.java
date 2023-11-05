package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2105_디저트카페 {

	static int N;
	static boolean[] cake;
	static boolean[][] visit;
	static int[][] map;
	static int ans;
	static int sx;
	static int sy;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = -1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cake = new boolean[101]; // cake 종류
					visit = new boolean[N][N]; // map 방문 체크 배열
					cnt = 0;
					sx = i;
					sy = j;
					// System.out.println("i,j " + i + " " + j);
					DFS(i, j, 1, false, false, false, false, 0);

				}
			}

			System.out.println("#" + t + " " + ans);

		} // 테스트케이스 for문

	}

	// DFS
	static void DFS(int x, int y, int sum, boolean UL, boolean UR, boolean DL, boolean DR, int dir) {
		cnt++;

		// 방문 처리
		visit[x][y] = true;
		cake[map[x][y]] = true;

		// System.out.println(x + " " + y + " sum " + sum);

		if (!UL) {
			int nx = x - 1;
			int ny = y - 1;

			if (nx == sx && ny == sy) {

				if (dir == 1) {
					if (UR && DL && DR)
						ans = Math.max(sum, ans);
				}

				if (dir == 2) {
					if (UL && DL && DR)
						ans = Math.max(sum, ans);
				}
				if (dir == 3) {
					if (UL && UR && DR)
						ans = Math.max(sum, ans);
				}
				if (dir == 4) {
					if (UL && UR && DL)
						ans = Math.max(sum, ans);
				}

				return;
			}
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && !cake[map[nx][ny]]) {
				if (dir == 0 || dir == 1)
					DFS(nx, ny, sum + 1, UL, UR, DL, DR, 1);
				else if (dir == 2)
					DFS(nx, ny, sum + 1, UL, true, DL, DR, 1);
				else if (dir == 3)
					DFS(nx, ny, sum + 1, UL, UR, true, DR, 1);
				else if (dir == 4)
					DFS(nx, ny, sum + 1, UL, UR, DL, true, 1);

				visit[nx][ny] = false;
				cake[map[ny][ny]] = false;
			}
		}

		if (!UR) {
			int nx = x - 1;
			int ny = y + 1;
			if (nx == sx && ny == sy) {

				if (dir == 1) {
					if (UR && DL && DR)
						ans = Math.max(sum, ans);
				}

				if (dir == 2) {
					if (UL && DL && DR)
						ans = Math.max(sum, ans);
				}
				if (dir == 3) {
					if (UL && UR && DR)
						ans = Math.max(sum, ans);
				}
				if (dir == 4) {
					if (UL && UR && DL)
						ans = Math.max(sum, ans);
				}

				return;
			}
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && !cake[map[nx][ny]]) {
				if (dir == 0 || dir == 2)
					DFS(nx, ny, sum + 1, UL, UR, DL, DR, 2);
				else if (dir == 1)
					DFS(nx, ny, sum + 1, true, UR, DL, DR, 2);
				else if (dir == 3)
					DFS(nx, ny, sum + 1, UL, UR, true, DR, 2);
				else if (dir == 4)
					DFS(nx, ny, sum + 1, UL, UR, DL, true, 2);

				visit[nx][ny] = false;
				cake[map[ny][ny]] = false;
			}
		}

		if (!DL) {
			int nx = x + 1;
			int ny = y - 1;
			if (nx == sx && ny == sy) {

				if (dir == 1) {
					if (UR && DL && DR)
						ans = Math.max(sum, ans);
				}

				if (dir == 2) {
					if (UL && DL && DR)
						ans = Math.max(sum, ans);
				}
				if (dir == 3) {
					if (UL && UR && DR)
						ans = Math.max(sum, ans);
				}
				if (dir == 4) {
					if (UL && UR && DL)
						ans = Math.max(sum, ans);
				}

				return;
			}
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && !cake[map[nx][ny]]) {
				if (dir == 0 || dir == 3)
					DFS(nx, ny, sum + 1, UL, UR, DL, DR, 3);
				else if (dir == 1)
					DFS(nx, ny, sum + 1, true, UR, DL, DR, 3);
				else if (dir == 2)
					DFS(nx, ny, sum + 1, UL, true, DL, DR, 3);
				else if (dir == 4)
					DFS(nx, ny, sum + 1, UL, UR, DL, true, 3);

				visit[nx][ny] = false;
				cake[map[ny][ny]] = false;
			}
		}

		if (!DR) {
			int nx = x + 1;
			int ny = y + 1;
			if (nx == sx && ny == sy) {

				if (dir == 1) {
					if (UR && DL && DR)
						ans = Math.max(sum, ans);
				}

				if (dir == 2) {
					if (UL && DL && DR)
						ans = Math.max(sum, ans);
				}
				if (dir == 3) {
					if (UL && UR && DR)
						ans = Math.max(sum, ans);
				}
				if (dir == 4) {
					if (UL && UR && DL)
						ans = Math.max(sum, ans);
				}

				return;
			}
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && !cake[map[nx][ny]]) {
				if (dir == 0 || dir == 4)
					DFS(nx, ny, sum + 1, UL, UR, DL, DR, 4);
				else if (dir == 1)
					DFS(nx, ny, sum + 1, true, UR, DL, DR, 4);
				else if (dir == 2)
					DFS(nx, ny, sum + 1, UL, true, DL, DR, 4);
				else if (dir == 3)
					DFS(nx, ny, sum + 1, UL, UR, true, DR, 4);

				visit[nx][ny] = false;
				cake[map[ny][ny]] = false;
			}
		}

	}
}
