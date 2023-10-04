import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bjo1941_소문난칠공주 {

	static char[][] map;
	static boolean[] visit;
	static boolean[][] checkMap;
	static long count;
	static int ans;

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

		map = new char[5][5];
		visit = new boolean[25];

		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// combination(0, 0);
		combination(0, 0);
		System.out.println(ans);

	}

	// nCr = n! / r!(n-r)!
	// nPr = n! / (n-r)!

	// 조합 코드
	static void combination(int index, int cnt) {

		if (cnt == 7) {
			Point startPoint = new Point(0, 0);
			checkMap = new boolean[5][5];
			for (int i = 0; i < 25; i++) {
				if (visit[i]) {
					int x = i / 5;
					int y = i % 5;

					startPoint = new Point(x, y);
					checkMap[x][y] = true;
				}

			}

			// 유효성 검사
			if (Check(startPoint))
				ans++;

			return;
		}

		if (index == 25)
			return;

		visit[index] = true;
		combination(index + 1, cnt + 1);
		visit[index] = false;
		combination(index + 1, cnt);

	}

	static boolean Check(Point start) {
		// S 이다솜파 Y 임도연파

		int S = 0;
		int Y = 0;

		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visit = new boolean[5][5];
		q.add(start);
		int x = start.x;
		int y = start.y;
		visit[x][y] = true;

		int findCount = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();
			x = p.x;
			y = p.y;

			if (map[x][y] == 'S') {
				S++;
			} else
				Y++;

			findCount++;

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 && !visit[nextX][nextY]
						&& checkMap[nextX][nextY]) {
					visit[nextX][nextY] = true;
					q.add(new Point(nextX, nextY));

				}
			}
		}

		if (findCount == 7 && S >= 4) {
			return true;
		}

		return false;

	}

}
