import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 배열 크기, 놓을 수 있는 바이러스의 개수
	static ArrayList<pos> positions;
	static boolean[] visit;
	static int[][] input;
	static pos[] put;
	static int[] arr;
	static int Min = Integer.MAX_VALUE;
//	static int time = Integer.MAX_VALUE;

	static class pos {
		int x;
		int y;
		int time;

		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + ", time=" + time + "]";
		}

		public pos(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}// pos

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N][N];
		positions = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				if (input[i][j] == 2) {
					positions.add(new pos(i, j, 0));
//					input[i][j] = 0;
				}
			}
		} // input-end

		// 바이러스를 처음에 둘 장소들을 결정하는 조합
		visit = new boolean[positions.size()];
		put = new pos[M];
		arr = new int[M];
		comb(0, 0);

		if (Min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(Min);
		}

	}// main

	private static void comb(int cnt, int start) {
		if (cnt == M) {
//			System.out.println(Arrays.toString(put));
//			System.out.println(Arrays.toString(arr));
			// 만들어진 조합에서 bfs를 돌려서 시간 측정
			int[][] map = arraycopy(input);
//			print(map);
			int time = bfs(put, map);
			if (time != -1) {
//				System.out.println("-1 아니었다@!~~: " + time);
				Min = Math.min(Min, time);
			}
			bfs(put, map);
			return;
		}

		for (int i = start; i < positions.size(); i++) {
			if (!visit[i]) {
				pos p = positions.get(i);
				put[cnt] = p;
				arr[cnt] = i;
				visit[i] = true;
				comb(cnt + 1, i + 1);
				visit[i] = false;
			}
		}

	}// comb

	private static int[][] arraycopy(int[][] input) {
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = input[i][j];
			}
		}
		return map;
	}

	static boolean[][] v;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	private static int bfs(pos[] put2, int[][] map) {
		Queue<pos> q = new ArrayDeque<>();
		v = new boolean[N][N];
		int EmptySpace = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					EmptySpace++;
				}
			}
		}

		for (int i = 0; i < put2.length; i++) {
			pos p = put2[i];
			q.add(p);
			v[p.x][p.y] = true;
		}
		int time = 0;

		while (!q.isEmpty()) {
			pos p = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = p.x + dx[dir];
				int ny = p.y + dy[dir];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 1 && !v[nx][ny]) {
					if (map[nx][ny] == 0) {
						EmptySpace--;
						time = Math.max(time, p.time + 1);
					}

					v[nx][ny] = true;
					q.add(new pos(nx, ny, p.time + 1));
				}
			} // dir
		} // while
		if (EmptySpace == 0) {
			return time;
		} else {
			return -1;
		}
	}// bfs

	static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}// print

	private static boolean mapcheck(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

}
