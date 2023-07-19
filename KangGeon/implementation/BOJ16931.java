package day0719;

import java.util.Scanner;

public class BOJ16931 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] array = new int[102][102];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int n = sc.nextInt();
		int m = sc.nextInt();

		// input
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				array[i][j] = sc.nextInt();
			}
		}

		// 겉넓이 계산
		// 넓이 계산시 블럭 높이의 차이만큼을 빼서 옆면들의 겉넓이를 구하기 위해
		// 배열의 테두리를 0으로 초기화 하고 사용함.
		int sufArea = n * m * 2; // 윗면과 아랫면의 겉넓이 더하기.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int d = 0; d < 4; d++) {
					int ni = i + dy[d];
					int nj = j + dx[d];

					// 겉넓이의 옆면 구하기
					int heightDiff = array[i][j] - array[ni][nj];
					if (heightDiff > 0) {
						sufArea += heightDiff;
					}
				}

			}
		}
		
		System.out.println(sufArea);

	}
}
