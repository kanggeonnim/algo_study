package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_프로세서 {

	static int N;
	static int[][] map;
	static List<Core> list;
	static int maxCore;
	static int minSum;

	static class Core {
		int x;
		int y;

		public Core(int x, int y) {
			super();
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
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<Core>();
			maxCore = 0;
			minSum = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i != 0 && i != N - 1 && j != 0 && j != N - 1)
							list.add(new Core(i, j));
					}
				}
			}
			DFS(0, 0);
			System.out.println("#" + t + " " + minSum);
		}
	}

	static void DFS(int cnt, int successCount) {

		if (successCount + list.size() - cnt < maxCore)
			return;
		
		if (successCount > maxCore) {
			maxCore = successCount;
			minSum = getSum();
		} else if (successCount == maxCore) {
			minSum = Integer.min(minSum, getSum());
		}
		if (cnt == list.size()) {

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (isAvailable(cnt, i)) {
				Connect(cnt, i, 2);
				DFS(cnt + 1, successCount + 1);
				Connect(cnt, i, 0);

			} else
				continue;

		}

		DFS(cnt + 1, successCount);

	}

	static boolean isAvailable(int cnt, int dir) {
		int nx = list.get(cnt).x;
		int ny = list.get(cnt).y;

		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			// System.out.println(nx + " " + ny);
			if (map[nx][ny] != 0)
				return false;

			if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1)
				return true;
		}
	}

	static void Connect(int cnt, int dir, int value) {
		int nx = list.get(cnt).x;
		int ny = list.get(cnt).y;

		while (true) {
			nx += dx[dir];
			ny += dy[dir];

			map[nx][ny] = value;
			if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1)
				return;
		}
	}

	static int getSum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2)
					sum++;
			}
		}

		return sum;
	}

}
