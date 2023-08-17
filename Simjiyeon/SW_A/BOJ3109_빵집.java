package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109_빵집 {
	static char[][] map;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C + 1];

		for (int i = 0; i < R; i++) {
			// 한 줄 받기
			st = new StringTokenizer(br.readLine());
			// string에서
			String s = st.nextToken();
			// char로
			char[] arr = s.toCharArray();
			for (int j = 1; j <= C; j++) {
				map[i][j] = arr[j - 1];
			}
		} // 입력 끝
//		print(map);
//		System.out.println("~~~~~~~~시작~~~~~~~~");
		int count = 0;
		for (int i = 0; i < R; i++) {
			if (dfs(map, i, 0, 0)) {
				count++;
			}

		}
		System.out.println(count);

	}// main

	static boolean dfs(char[][] m, int x, int y, int cnt) {
		map[x][y] = 'x';
		if (y == C - 1) {
//			dfs(m, r + 1, 0, cnt + 1);
//			Max = Math.max(Max, cnt + 1);
			return true;
		}
		int dont = 0;
		boolean res = false;
		for (int dir = 0; dir < 3; dir++) {

			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'x')
				continue;
			res = dfs(m, nx, ny, cnt);
			if (res)
				break;

		} // DIR
		return res;

	}

	static void print(char[][] m) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j <= C; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}

}
