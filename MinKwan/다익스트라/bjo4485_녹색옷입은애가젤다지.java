package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bjo4485_녹색옷입은애가젤다지 {

	static int[][] map;
	static int[][] dist;
	static boolean[][] visit; // 방문 체크
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int toX;
		int toY;
		int value;

		public Node(int toX, int toY, int value) {
			this.toX = toX;
			this.toY = toY;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (true) {

			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			dist = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			dist[0][0] = map[0][0];
			visit[0][0] = true;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, map[0][0]));

			while (!pq.isEmpty()) {
				Node node = pq.poll();
				int x = node.toX;
				int y = node.toY;
			//	System.out.println("x y " + x + " , " + y);

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]) {
						pq.add(new Node(nx, ny, dist[x][y] + map[nx][ny]));
						dist[nx][ny] = Math.min(dist[nx][ny], dist[x][y] + map[nx][ny]);
						visit[nx][ny] = true;
					}

				}
			}

			System.out.println("Problem" + " " + t++ + ": " + dist[N - 1][N - 1]);
		}

	}
}
