package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17142_연구소3 {
	static int N, M;
	static int[] arr;
	static boolean[] selected;
	static int[][] input, map;
	static boolean[][] visited;
	static ArrayList<Virus> first_v;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int Min = Integer.MAX_VALUE;

	static class Virus {
		int x;
		int y;
		int time;

		public Virus(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N][N];

		// 활성 바이러스 조합 만들 때 쓰이는 배열
		arr = new int[M];
		first_v = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				input[i][j] = a;
				if (input[i][j] == 2) {
					// 처음 바이러스 위치 기억
					first_v.add(new Virus(i, j, 0));
				}
			}
		} // input end

		selected = new boolean[first_v.size()];
		// 처음 바이러스 위치 결정 함수
		// 처음 바이러스 위치 결정 후 그 위치에서 bfs돌리기
		recur(0, 0);
		// 최소시간 구해서 가져오기

		// 전체 바이러스가 활성화 되었는지 체크 후 정답 출력
		if (Min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(Min);
		}
	}// main

	static void recur(int cnt, int start) { // m개를 뽑아서 arr에 넣고 그 뽑은 m개를 기준으로 q돌리기
		if (cnt == M) {
			Queue<Virus> queue = new ArrayDeque<>();
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (input[i][j] == 1) {// 벽 체크 후 벽이면 2대입
						map[i][j] = 2;
						visited[i][j] = true;
					}
				}
			}
			for (int i = 0; i < M; i++) {
				System.out.println("좌표: " + first_v.get(arr[i]).x + ", " + first_v.get(arr[i]).y);
				queue.add(first_v.get(arr[i]));
			}
			bfs(queue);
			return;
			// 바이러스 퍼트리기

		}

		for (int i = start; i < first_v.size(); i++) {
			if (!selected[i]) {
				arr[cnt] = i;
				selected[i] = true;
				recur(cnt + 1, i + 1);
				selected[i] = false;
			}
		}

	}// recur

	static void bfs(Queue<Virus> q) {
		int times = 0;
		while (!q.isEmpty()) {
			Virus v = q.poll();
			// 활성화된 바이러스는 1로
			map[v.x][v.y] = 1;
			visited[v.x][v.y] = true;

			for (int dir = 0; dir < 4; dir++) {// 4방 탐색
				int nx = v.x + dx[dir];
				int ny = v.y + dy[dir];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 2 && map[nx][ny] != 1
						&& !visited[nx][ny]) {
					visited[nx][ny] = true;
					map[nx][ny] = 1;
					q.add(new Virus(nx, ny, v.time + 1));
				}
			}
			times = v.time;
		}
		System.out.println(times);
		if (check(map)) {
			Min = Math.min(Min, times);
		}
	}// bfs

	static boolean check(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;

	}

}
