package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea2805_농작물수확하기 {
	static int N;
	static int half;
	static boolean[][] visit;
	static int[][] map;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			half = N / 2;
			visit = new boolean[N][N];
			map = new int[N][N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) { // 수확 시작
					harvest();
				}

			}

		}
	}

	static void harvest(int x, int y) {

		for (int i = half; i > 0; i--) {

			for (int j = i; j > 0; j--) {

			}
		}
	}

}
