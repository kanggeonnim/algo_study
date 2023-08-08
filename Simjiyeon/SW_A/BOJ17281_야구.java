package A형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17281 {
	static int[][] arr;
	static int N;
	static boolean[] isused = new boolean[9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][9];

		for (int i = 0; i < N; i++) {
			StringTokenizer tk1 = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(tk1.nextToken());
			}
		}

		int[] board = new int[9];
		// 1번 선수 고정
		board[3] = 0;
		isused[0] = true;
		print(board);
		perm(board, 0);

	}

	static void perm(int[] board, int cnt) {
		if (cnt == 9) { // 1번 선수를 빼고 조합을 완료하면?
//			print(board);
			// 1이닝의 점수를 구한다.
			int[] out = new int[9 * N]; //이닝 전체를 하나의 배열로 만들어서 차례대로 본다.
			for(int i=0;i<N;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(board[j]+", ");
					out[i+j] = arr[i][board[j]];
				}
				System.out.println();
			}//1차원 배열에 이닝 점수 다 넣어버리기
			for(int i=0;i<9*N;i++) {
				System.out.print(out[i]+", ");
			}
			System.out.println();

			return;
		}
		if (cnt == 3) {
			cnt++;
		}

		for (int i = 0; i < 9; i++) {
			if (isused[i] == false) {
				isused[i] = true;
				board[cnt] = i;
				perm(board, cnt + 1);
				isused[i] = false;
			}

		} // fori->9
	}

	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
