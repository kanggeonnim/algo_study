import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_수영대회결승전 {

	static int T;
	static int N; // 가로 N,세로 N
	static int[][] map;
	static boolean[][] visit;

	static class Player {
		int x;
		int y;
		int time;
		int tornadoTime;

		public Player(int x, int y, int time, int tornadoTime) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.tornadoTime = tornadoTime;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			// 입력 끝

			for (int[] a : map)
				System.out.println(Arrays.toString(a));

			// 소용돌이는 생성되고 2초동안 유지, 그리고 1초 동안 잠잠해진다.
			Queue<Player> q = new LinkedList<Player>();
			q.add(new Player(startX, startY, 0, 0));
			visit[startX][startY] = true;

			// 토네이도가 끝나기를 기다리는 선택지도 넣어야 한다.
			while (!q.isEmpty()) {
				Player player = q.poll();
				int x = player.x;
				int y = player.y;
				int time = player.time;
				int tornadoTime = player.tornadoTime;
				System.out.println("x y time " + x + " " + y + " " + time + " " + tornadoTime);
				
				if (x == endX && y == endY) {
					System.out.println(time);
					break;
				}
				
				// 토네이도 시간
				if (tornadoTime < 2) {
					// 현재 토네이도 시간이고, 플레이어가 토네이도 안에 머무르고 있다면
					if (map[x][y] == 2) {
						q.add(new Player(x, y, time + 1, tornadoTime + 1));
						continue;
					}

					for (int i = 0; i < 4; i++) {
						int nextX = x + dx[i];
						int nextY = y + dy[i];

						if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visit[nextX][nextY]
								&& map[nextX][nextY] == 0) {
							q.add(new Player(nextX, nextY, time + 1, tornadoTime + 1));
							visit[nextX][nextY] = true;
						}

						if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visit[nextX][nextY]
								&& map[nextX][nextY] == 2) {
							q.add(new Player(x, y, time + 1, tornadoTime + 1));
						}
					}
				}
				// 토네이도 쉬는 시간
				else {
					for (int i = 0; i < 4; i++) {
						int nextX = x + dx[i];
						int nextY = y + dy[i];

						if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visit[nextX][nextY]
								&& (map[nextX][nextY] == 0 || map[nextX][nextY] == 2)) {
							q.add(new Player(nextX, nextY, time, 0));
							visit[nextX][nextY] = true;
						}
					}
				}

			}

		}
	}

}
