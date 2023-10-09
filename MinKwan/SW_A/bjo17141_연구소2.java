import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bjo17141_연구소2 {
	static int N;
	static int M;
	static int[][] map;
	static ArrayList<Point> virusList;
	static boolean[] visit;
	static int ans;
	static int goal; // 모든 빈칸의 개수

	static class Point {
		int x;
		int y;
		int time;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.time = 0;
		}

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 0 이동 가능 1 벽 2 바이러스 위치
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		map = new int[N][N];
		virusList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new Point(i, j));
				}
				if (map[i][j] != 1)
					goal++;
			}
		}
		goal -= M;

		if (goal == 0) {
			System.out.println(0);
			return;

		}
		visit = new boolean[virusList.size()];
		Combination(0, 0);

		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	static void Combination(int index, int cnt) {
		if (cnt == M) {

			BFS();	
			return;
		}

		for(int i = index; i<virusList.size();i++) {
			visit[i] = true;
			Combination(i + 1, cnt + 1);
			visit[i] = false;
		}
	}

	static void BFS() {
		int goalCnt = goal;
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visitQ = new boolean[N][N];

		for (int i = 0; i < virusList.size(); i++) {
			if (visit[i]) {
				q.add(virusList.get(i));
				visitQ[virusList.get(i).x][virusList.get(i).y] = true;
			}
		}

		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int time = p.time;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visitQ[nx][ny] && map[nx][ny] != 1) {
					goalCnt--;
					if (goalCnt == 0) {
						ans = Math.min(time + 1, ans);
						return;
					}
					visitQ[nx][ny] = true;
					q.add(new Point(nx, ny, time + 1));
				}
			}
		}
		

	}
}
