package DataStructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992_쿼드트리 {
	static int N;
	static int[][] input;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
//		File fileName = new File("C:\\SSAFY\\workspace\\work-algo\\day0818\\src\\BOJ1992.txt");
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
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
		
		if(N==1) {
			System.out.println(input[0][0]);
		}else {
			div(0, 0, N / 2);
			System.out.println(sb);
		}


	}// main

	static void div(int x, int y, int length) {
		int si = x;
		int sj = y;
		int mi = x + length;
		int mj = y + length;
		int ei = x + length * 2;
		int ej = y + length * 2;

		sb.append("(");
		int cnt = 0;
		if (check(si, sj, mi, mj)) {
			cnt++;
			sb.append(input[si][sj]);
		} else {
			div(si, sj, length / 2);
		}
		// 왼위

		if (check(si, mj, mi, ej)) {
			cnt++;
			sb.append(input[si][mj]);
		} else {
			div(si, mj, length / 2);
		}
		// 오위

		if (check(mi, sj, ei, mj)) {
			cnt++;
			sb.append(input[mi][sj]);
		} else {
			div(mi, sj, length / 2);
		}
		// 왼아

		if (check(mi, mj, ei, ej)) {
			cnt++;
			sb.append(input[mi][mj]);
		} else {
			div(mi, mj, length / 2);
		}
		sb.append(")");
		if (cnt == 4&&input[si][sj]==input[si][mj]&&input[si][mj]==input[mi][sj]
				&&input[mi][sj]==input[mi][mj]) {
			sb.delete(sb.length() - 6, sb.length());
			sb.append(input[si][sj]);
		}

		// 오아

	}// div

	static boolean check(int si, int sj, int ei, int ej) {
		int x = input[si][sj];
		for (int i = si; i < ei; i++) {
			for (int j = sj; j < ej; j++) {
				if (input[i][j] != x) {
					return false;
				}
			}
		}
		return true;

	}
}
