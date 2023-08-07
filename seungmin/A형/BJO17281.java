package bjo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJO17281 {
	static int[][] arr;
	static int n;
	static int[] turn = new int[9];
	static boolean[] visited = new boolean[9];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/BJO17281.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(in.readLine());
		arr = new int[n][9];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		turn(0);
		System.out.println(max);

	}

	static void turn(int cnt) {
		if (cnt == 9) {
			max = Math.max(max, play(turn));
		}
		if (cnt == 3)
			cnt += 1;
		for (int i = 1; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				turn[cnt] = i;
				turn(cnt + 1);
				visited[i] = false;
			}

		}
	}

	static int play(int[] turn) {
		int score = 0;
		int current = 0;
		byte out;
		boolean[] base;

		for (int i = 0; i < n; i++) {
			base = new boolean[4];
			out = 0;
			while (out < 3) {
				int temp = arr[i][turn[current]];
				current = (current + 1) % 9;
				if (temp == 0) {
					out += 1;
					continue;
				}

				base[0] = true;

				for (int j = 3; j >= 0; j--) {
					if (base[j] && j + temp > 3) {
						score += 1;
					} else if (j + temp < 4) {
						base[j + temp] = base[j];
					}
					base[j] = false;
				}
			}
		}

		return score;
	}
}
