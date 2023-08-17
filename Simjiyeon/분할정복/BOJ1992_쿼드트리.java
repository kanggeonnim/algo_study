package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992_쿼드트리 {
	static int N;
	static int[][] input;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		input = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			char[] arr = s.toCharArray();
			for (int j = 0; j < N; j++) {
				input[i][j] = arr[j] - '0';
			}
		} // input

		div(0, 0, N / 2);
		System.out.println(sb);

	}// main

	static void div(int x, int y, int length) {
		System.out.printf("x: %d, y: %d\n", x, y);
		if (length == 1) {
			sb.append(input[x][y]);
			return;
		}
		// 4분면 검사
		sb.append("(");
		// 제1
		for (int i = x; i < x + length; i++) {
			for (int j = y; i < y + length; j++) {
				if (input[i][j] != input[x][y]) {
					div(i, j, length / 2);
				} else {
					sb.append(input[x][y]);
				}
			}
		}

		// 제2
		for (int i = x; i < x + length; i++) {
			for (int j = y + length; i < y + length * 2; j++) {
				if (input[i][j] != input[x][y]) {
					div(x, y + length, length / 2);
				} else {
					sb.append(input[x][y]);
				}
			}
		}
		// 제3
		for (int i = x + length; i < x + length * 2; i++) {
			for (int j = y; i < y + length; j++) {
				if (input[i][j] != input[x][y]) {
					div(x + length, y, length / 2);
				} else {
					sb.append(input[x][y]);
				}
			}
		}

		// 제4
		for (int i = x + length; i <= x + length * 2; i++) {
			for (int j = y + length; i <= y + length * 2; j++) {
				if (input[i][j] != input[x][y]) {
					div(x + length, y + length, length / 2);
				} else {
					sb.append(input[x][y]);
				}
			}
		}

	}// div
}
