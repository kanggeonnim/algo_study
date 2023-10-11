
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bjo17144_미세먼지안녕 {

	static int R;
	static int C;
	static int T;
	static Dust[][] map;

	static int upx;
	static int upy;

	static int downx;
	static int downy;

	static int ans;

	static class Dust {
		int x;
		int y;
		int cnt;
		int amount;

		public Dust(int x, int y, int amount) {
			this.x = x;
			this.y = y;
			this.cnt = 0;
			this.amount = amount;
		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int[] dx_up = { -1, 0, 1, 0 };
	static int[] dy_up = { 0, 1, 0, -1 };

	static int[] dx_down = { 1, 0, -1, 0 };
	static int[] dy_down = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new Dust[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				int amount = Integer.parseInt(st.nextToken());
				map[r][c] = new Dust(r, c, amount);

				if (map[r][c].amount == -1) {
					if (upx == 0) {
						upx = r;
						upy = c;
					} else {
						downx = r;
						downy = c;
					}
				}
			}
		}

		// 입력 끝

		for (int t = 1; t <= T; t++) { // t 초 반복

			int[][] temp = new int[R][C];

			//System.out.println("----------초기 맵 상태------------");
			//print();

			// 확장
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {

					if (map[r][c].amount / 5 == 0 || map[r][c].amount == 0)
						continue;

					int x = map[r][c].x;
					int y = map[r][c].y;

					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];

						if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny].amount != -1) {
							map[x][y].cnt++;
							temp[nx][ny] += map[x][y].amount / 5;
						}
					}

				}
			}

			// 확산한거 최종 합치기
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {

					if (map[r][c].amount != -1) {
						if (map[r][c].amount > 0) {
							map[r][c].amount = map[r][c].amount - map[r][c].amount / 5 * map[r][c].cnt + temp[r][c];
						} else {
							map[r][c].amount = temp[r][c];
						}
					}

					map[r][c].cnt = 0;

				}
			} // 확산된거 최종 합치기

		//	System.out.println("확산 수행");
		//	print();

			// up 순환 수행
			map[upx - 1][upy].amount = 0;
			int nowX = upx - 1;
			int nowY = upy;
			int nextX = upx - 2;
			int nextY = upy;

			int nowDir = 0;
			int nextDir = 0;

			while (true) {

				// 종료지점에 도달
				if (nextX == upx && nextY == upy) {
					// System.out.println(nowX + " " + nowY);
					map[nowX][nowY].amount = 0;
					break;
				}

				map[nowX][nowY].amount = map[nextX][nextY].amount;
				//map[nowX][nowY].x = map[nextX][nextY].x;
				//map[nowX][nowY].y = map[nextX][nextY].y;

				int checkNowX = nowX + dx_up[nowDir];
				int checkNowY = nowY + dy_up[nowDir];
				if (checkNowX >= 0 && checkNowX <= upx && checkNowY >= 0 && checkNowY < C) {
					nowX = checkNowX;
					nowY = checkNowY;
				} else {
					nowDir++;
					nowX += dx_up[nowDir];
					nowY += dy_up[nowDir];
				}

				int checkNextX = nextX + dx_up[nextDir];
				int checkNextY = nextY + dy_up[nextDir];

				if (checkNextX >= 0 && checkNextX <= upx && checkNextY >= 0 && checkNextY < C) {
					nextX = checkNextX;
					nextY = checkNextY;
				} else {
					nextDir++;
					nextX += dx_up[nextDir];
					nextY += dy_up[nextDir];
				}
			} // up 순환 끝

			// down 순환 수행
			map[downx + 1][downy].amount = 0;
			nowX = downx + 1;
			nowY = downy;
			nextX = downx + 2;
			nextY = downy;

			nowDir = 0;
			nextDir = 0;

			while (true) {

				// 종료지점에 도달
				if (nextX == downx && nextY == downy) {
					// System.out.println(nowX + " " + nowY);
					map[nowX][nowY].amount = 0;
					break;
				}

				map[nowX][nowY].amount = map[nextX][nextY].amount;
				//map[nowX][nowY].x = map[nextX][nextY].x;
				//map[nowX][nowY].y = map[nextX][nextY].y;

				int checkNowX = nowX + dx_down[nowDir];
				int checkNowY = nowY + dy_down[nowDir];
				if (checkNowX >= downx && checkNowX < R && checkNowY >= 0 && checkNowY < C) {
					nowX = checkNowX;
					nowY = checkNowY;
				} else {
					nowDir++;
					nowX += dx_down[nowDir];
					nowY += dy_down[nowDir];
				}

				int checkNextX = nextX + dx_down[nextDir];
				int checkNextY = nextY + dy_down[nextDir];

				if (checkNextX >= downx && checkNextX < R && checkNextY >= 0 && checkNextY < C) {
					nextX = checkNextX;
					nextY = checkNextY;
				} else {
					nextDir++;
					nextX += dx_down[nextDir];
					nextY += dy_down[nextDir];
				}
			} // up 순환 끝

			//System.out.println("순환 수행");
			//print();
		}

		getAnswer();
		System.out.println(ans);

	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j].amount + " ");
			}
			System.out.println();
		}
	}

	private static void getAnswer() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c].amount > 0) {
					ans += map[r][c].amount;
				}

			}
		}
	}

}
