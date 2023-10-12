package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea5656_벽돌깨기 {
	static int T; // 테케수
	static int N; // 구슬의 수
	static int W; // 열
	static int H; // 행
	static int[][] map; // map
	static int[][] copy; // 맵을 초기화할때 사용할 copy 배열

	static int numbers[];
	static int min;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			copy = new int[H][W];
			numbers = new int[N];
			min = Integer.MAX_VALUE;

			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					map[h][w] = copy[h][w] = Integer.parseInt(st.nextToken());
				}
			}

			perm(0);
			System.out.println("#" + t + " " + min);
		}
	}

	static void perm(int cnt) {
		if (cnt == N) {

			start(numbers);
			min = Math.min(min, countMap());
			mapcopy(); //맵 초기화
			return;
		}

		for (int i = 0; i < W; i++) {
			numbers[cnt] = i;
			perm(cnt + 1);
		}
	}

	static void start(int[] arr) {
		int x = 0;
		int y = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < H; j++) {
				if (map[j][arr[i]] != 0) {

					x = j;
					y = arr[i];
					break;
				}
			}

			bfs(x, y);
			blockdown();

		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y, map[x][y] });
		map[x][y] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int power = cur[2];

			for (int i = 1; i < power; i++) {
				for (int j = 0; j < 4; j++) {
					int nx = cur[0] + dx[j] * i;
					int ny = cur[1] + dy[j] * i;

					if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 0)
						continue;

					if (map[nx][ny] != 0) { // 0이 아니라면 블록이니까
						q.add(new int[] { nx, ny, map[nx][ny] });
						map[nx][ny] = 0; // 폭팔 처리로 0으로 바꿈
					}
				}
			}
		}
	}

	static void blockdown() {
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if (map[j][i] != 0)
					s.add(map[j][i]);
			}

			for (int j = H - 1; j >= 0; j--) {
				if (s.isEmpty())
					map[j][i] = 0;
				else
					map[j][i] = s.pop();
			}
		}
	}

	static void mapcopy() {
		for (int h = 0; h < H; h++) {

			for (int w = 0; w < W; w++) {
				map[h][w] = copy[h][w];
			}
		}

	}

	static int countMap() {
		int count = 0;
		for (int h = 0; h < H; h++) {

			for (int w = 0; w < W; w++) {
				if (map[h][w] != 0)
					count++;
			}
		}

		return count;
	}
}
