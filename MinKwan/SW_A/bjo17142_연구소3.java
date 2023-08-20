package algo_Study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bjo17142_연구소3 {

	static int N; // 맵 크기
	static int M; // 바이러스 활성화 개수
	static int arr[][]; // 맵
	static ArrayList<Point> virus; // 바이러스를 모두 저장한 리스트
	static int virusSize; // 맵 안의 바이러스 갯수
	static Point[] virusComb;
	static boolean[][] visit;

	static int oriGoal;
	static int goal;
	static int time;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0, };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][N];
		virus = new ArrayList<Point>();
		virusComb = new Point[M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();

				if (arr[i][j] == 2) {
					virus.add(new Point(i, j, 1));
				}

				if (arr[i][j] == 0)
					goal++;
			}
		}

		oriGoal = goal;

		virusSize = virus.size();
		System.out.println(virus.size());
		System.out.println(oriGoal);

		Combination(0, 0);

	}

	// 바이러스 조합 뽑아내기
	static void Combination(int start, int cnt) {
		if (cnt == M) {

			for (Point a : virusComb) {
				System.out.print(a.x + " " + a.y + ", ");
			}
			System.out.println();

			goal = oriGoal;
			visit = new boolean[N][N];
			time = 0;
			BFS();
			return;

		}

		for (int i = start; i < virusSize; i++) {
			virusComb[cnt] = virus.get(i);
			Combination(i + 1, cnt + 1);
		}
	}

	static class Point {
		int x;
		int y;
		int dis;

		public Point(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	static void BFS() {
		Queue<Point> q;
		q = new LinkedList<Point>();

		for (int i = 0; i < virusComb.length; i++) {
			q.add(virusComb[i]);
			visit[virusComb[i].x][virusComb[i].y] = true;
		}

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int d = q.peek().dis;

			q.poll();
			time++;
			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && visit[nextX][nextY] == false
						&& arr[nextX][nextY] != 1) {

					visit[nextX][nextY] = true;

					if (arr[nextX][nextY] == 0)
						arr[nextX][nextY] = 2;
					
					goal--;
					
					q.add(new Point(nextX, nextY, d + 1));
				}
			}

			if (goal <= 0)
				System.out.println("바이러스 번식 성공! " + d);
		}

	}

}
