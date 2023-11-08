package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//터널 구조물이 호환되는 타입인지도 확인해야 함.
public class swea1953_탈주범검거 {
	static int H; // 5<=H
	static int W; // 50<=W
	static int sx; // 맨홀 시작 위치
	static int sy;
	static int[][] map;
	static boolean[][] countingMap;
	static boolean[][] visit;
	static int givenTime;
	static int ans;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			givenTime = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			visit = new boolean[H][W];
			countingMap = new boolean[H][W];
			countingMap[sx][sy] = true;
			ans = 0;
			
			for(int i = 0; i<H;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j = 0; j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			DFS(sx, sy, 1, map[sx][sy]);
			getResult();

			System.out.println("#" + t + " " + ans);
		}
	}

	static void DFS(int x, int y, int time, int pipe) {

		if (time == givenTime) {

			return;
		}
		visit[x][y] = true;
		// 상하좌우
		if (pipe == 1) {

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (i == 0) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				} else if (i == 1) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				} else if (i == 2) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				} else if (i == 3) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				}
			}

		}
		// 상,하
		else if (pipe == 2) {

			for (int i = 0; i < 2; i++) {
				int nx = x;
				int ny = y;
				if (i == 0) {
					nx = x - 1;
					ny = y;
				} else {
					nx = x + 1;
					ny = y;
				}

				if (i == 0) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				} else if (i == 1) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				}

			}
		}
		// 좌,우
		else if (pipe == 3) {
			for (int i = 0; i < 2; i++) {
				int nx = x;
				int ny = y;

				if (i == 0) {
					nx = x;
					ny = y - 1;
				} else {
					nx = x;
					ny = y + 1;
				}

				if (i == 0) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				} else if (i == 1) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				}

			}
		}
		// 상 우
		else if (pipe == 4) {
			for (int i = 0; i < 2; i++) {
				int nx = x;
				int ny = y;
				if (i == 0) {
					nx = x - 1;
					ny = y;
				} else {
					nx = x;
					ny = y + 1;
				}

				if (i == 0) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				} else if (i == 1) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				}

			}
		}
		// 하,우
		else if (pipe == 5) {
			for (int i = 0; i < 2; i++) {
				int nx = x;
				int ny = y;
				if (i == 0) {
					nx = x + 1;
					ny = y;
				} else {
					nx = x;
					ny = y + 1;
				}

				if (i == 0) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				} else if (i == 1) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				}

			}
		}
		// 하,좌
		else if (pipe == 6) {
			for (int i = 0; i < 2; i++) {
				int nx = x;
				int ny = y;
				if (i == 0) {
					nx = x + 1;
					ny = y;
				} else {
					nx = x;
					ny = y - 1;
				}
				if (i == 0) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				} else if (i == 1) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				}

			}
		}
		// 상,좌
		else if (pipe == 7) {
			for (int i = 0; i < 2; i++) {
				int nx = x;
				int ny = y;
				if (i == 0) {
					nx = x - 1;
					ny = y;
				} else {
					nx = x;
					ny = y - 1;
				}
				if (i == 0) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				} else if (i == 1) {
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny]
							&& (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5)) {

						countingMap[nx][ny] = true;
						DFS(nx, ny, time + 1, map[nx][ny]);
						visit[nx][ny] = false;
					}
				}

			}
		}

		// 자신의 파이프 종류마다 검사를 해서 DFS 돌리기!

	}

	static void getResult() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (countingMap[i][j] == true)
					ans++;

//				if (countingMap[i][j])
//					System.out.print("1 ");
//				else
//					System.out.print("0 ");
			}
			//System.out.println();
		}
	}

}
