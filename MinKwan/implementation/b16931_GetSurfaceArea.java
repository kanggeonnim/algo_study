package CodingTest;

import java.util.Scanner;


/*
 * 1. 모든 블록은 기본적으로 넓이 2를 가지고 시작 (바닥, 윗면)
 * 2. 4방 탐색을 하고 범위를 벗어나면 블록 높이만큼 넓이 더하기
 * 3. 블록을 기점으로 4방 탐색 -> 탐색 된 블록의 높이가 기점 블록보다 높다.  + 0
 * 탐색 된 블록의 높이가 기점 블록보다 낮다. -> 탐색 블록의 높이 - 기점 블록의 높이
 * 
 * 
 */
public class b16931_GetSurfaceArea {

	// 서북동남
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// n,m 입력 받기
		int n, m;

		n = sc.nextInt();
		m = sc.nextInt();

		int[][] ary = new int[n][m];

		// 배열 입력 받기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ary[i][j] = sc.nextInt();
			}
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// 4방 탐색 실시 (서, 북, 동, 남 )
				int x = i;
				int y = j;
				int sum = 2;
				
				for (int k = 0; k < 4; k++) {

					int nextX = x + dx[k];
					int nextY = y + dy[k];

					// 범위를 벗어난 경우
					if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
						sum += ary[i][j];
					}
					else {
						if(ary[nextX][nextY] < ary[i][j]) {
							sum += ary[i][j] - ary[nextX][nextY];
						}
					}
					
					
				}
				
				result+=sum;

			}
		}
		
		System.out.println(result);
	}

}
