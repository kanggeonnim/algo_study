package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bjo1920_수찾기 {

	static int[] A;
	static int[] B;
	static int index;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int M = Integer.parseInt(br.readLine());
		B = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			binarySearch(0, N / 2, N, B[i]);
		}
	}

	static void binarySearch(int s, int m, int e, int findValue) {

		if (A[m] == findValue) {
			System.out.println("1");
			return;
		}

		if (s == m) {
			System.out.println("0");
			return;
		}

		if (findValue > A[m])
			binarySearch(m, (m + e) / 2, e, findValue);
		else if (findValue < A[m]) {
			binarySearch(s, m / 2, m, findValue);
		}

	}
}
