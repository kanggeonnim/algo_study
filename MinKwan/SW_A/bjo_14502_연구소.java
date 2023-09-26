package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bjo_14502_연구소 {
	static int W;
	static int H;

	static int[][] map;

	static ArrayList<Point> virus;
	static ArrayList<Point> space;
	static int max;
	static boolean[] isSelected;

	static int count = 0;

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		virus = new ArrayList<>();
		space = new ArrayList<>();
		max = 0;

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 0)
					space.add(new Point(i, j));
				else if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}

		isSelected = new boolean[space.size()];

		combination(0, 0);

		System.out.println(max);

		// --------------------입력 종료 ----------------
	}

	// 벽 세개 뽑아내기
	static void combination(int index, int cnt) {

		if (cnt == 3) {
			int[][] temp = deepCopy();
			count++;
			for (int i = 0; i < space.size(); i++) {
				if (isSelected[i]) {

					int x = space.get(i).x;
					int y = space.get(i).y;
					temp[x][y] = 1;
				}
			} // 새로운 벽 세우기 for문

			// 바이러스 퍼트리기
			SpreadVirus(temp);
			max = Math.max(max, check(temp));
			return;
		}

		if (index == space.size())
			return;

		isSelected[index] = true;
		combination(index + 1, cnt + 1);
		isSelected[index] = false;
		combination(index + 1, cnt);

	}

	// 깊은 복사
	static int[][] deepCopy() {
		int[][] newMap = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}

		return newMap;
	}

	// 바이러스 퍼트리기
	static void SpreadVirus(int[][] temp) {

		Queue<Point> q = new LinkedList<>();
		boolean[][] visit = new boolean[H][W];

		// 초기의 바이러스를 큐에 넣기
		for (int i = 0; i < virus.size(); i++) {
			q.add(virus.get(i));
			visit[virus.get(i).x][virus.get(i).y] = true;
		}

		while (!q.isEmpty()) {

			Point p = q.poll();

			int x = p.x;
			int y = p.y;

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W && !visit[nextX][nextY]
						&& temp[nextX][nextY] == 0) {
					visit[nextX][nextY] = true;
					temp[nextX][nextY] = 2;
					q.add(new Point(nextX, nextY));
				}
			}

		}

	}

	static int check(int[][] temp) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (temp[i][j] == 0)
					cnt++;
			}
		}

		return cnt;
	}
}
