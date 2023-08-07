package algo_Study;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

/*
 * 파이프의 시작 위치 {{ 1,1 } { 1,2 } }
 * 우,남,남동 으로만 이동 가능
 * 파이프의 한쪽 끝을 (N,N)으로 이동시켜줘야 한다.
 * 
 * 가로: 우, 남동 
 * 세로: 남, 남동
 * 대각선: 가로, 세로, 남동
 * 
 * 
 */
public class bjo17070_파이프옮기기1 {

	// 파이프의 x,y 좌표
	static int n;
	static int result;
	static int[][] delta = { { 1, 1 }, { 0, 1 }, { 1, 0 } }; // 남동,가로,세로
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		result = 0;
		map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
				//System.out.print(map[i][j] + " ");
			}
			//System.out.println();
		}

		// x = 1;
		// y = 2; // 초기 파이프 위치

		func(1, 1, 2);
		System.out.println(result);

	}

	/*
	 * 파이프의 모드 mode 1 : 가로 mode 2 : 세로 mode 3 : 대각선 -------인덱스를 1부터 시작한다---- 대각선으로 쭉
	 * 다가가 안되면 돌아와서 다시 분기 시작
	 */
	static void func(int mode, int x, int y) {

		if (x == n && y == n) {
			result++;
		//	System.out.println("성공");
			return;
		} else {
			//System.out.println("실패  " + "X: " + x + "  Y :" + y + "  Mode: " + mode);
		}

		if (mode == 1) {

			for (int i = 0; i < 2; i++) {
				//System.out.println(x + " " + y );
				int nextX = x + delta[i][0];
				int nextY = y + delta[i][1];

				if (i == 1) {
					if (nextX < 1 || nextX > n || nextY < 1 || nextY > n || map[nextX][nextY] == 1) { // 벽 만나면
				//		System.out.println("Mode 1 가로  실패 " + " nextX: " + nextX + " nextY: " + nextY + " I: " + i); // return
						continue;
					}
				} else {
					if (nextX < 1 || nextX > n || nextY < 1 || nextY > n || map[nextX][nextY] == 1
							|| map[nextX][nextY - 1] == 1 || map[nextX - 1][nextY] == 1) {
					//	System.out.println("Mode1 대각선 실패"  + " nextX: " + nextX + " nextY: " + nextY+ " I: " + i);
						continue;
					}
				}

				//x = nextX;
				//y = nextY;

				if (i == 0)
					mode = 3;
				else
					mode = 1;

				func(mode, nextX, nextY);

			}
		} else if (mode == 2) {
			for (int i = 0; i < 2; i++) {
				int nextX = 0;
				int nextY = 0;

				if (i == 1) {
					nextX = x + delta[2][0];
					nextY = y + delta[2][1];
				} else {
					nextX = x + delta[i][0];
					nextY = y + delta[i][1];
				}

				if (i == 1) {
					if (nextX < 1 || nextX > n || nextY < 1 || nextY > n || map[nextX][nextY] == 1) { // 벽 만나면
						//System.out.println("Mode 2 세로 실패"  + " nextX: " + nextX + " nextY: " + nextY+ " I: " + i); // return
						continue;
					}
				} else {
					if (nextX < 1 || nextX > n || nextY < 1 || nextY > n || map[nextX][nextY] == 1
							|| map[nextX][nextY - 1] == 1 || map[nextX - 1][nextY] == 1) {
						//System.out.println("Mode 2 대각선 실패"  + " nextX: " + nextX + " nextY: " + nextY+ " I: " + i);
						continue;
					}
				}

//				x = nextX;
//				y = nextY;

				if (i == 0)
					mode = 3;
				else
					mode = 2;

				func(mode, nextX, nextY);
			}
		} else {

			for (int i = 0; i < 3; i++) {
				int nextX = x + delta[i][0];
				int nextY = y + delta[i][1];

				if (i == 1) {
					if (nextX < 1 || nextX > n || nextY < 1 || nextY > n || map[nextX][nextY] == 1) { // 벽 만나면
						//System.out.println("Mode3 가로"  + " nextX: " + nextX + " nextY: " + nextY+ " I: " + i);
						continue;
					}
				} else if(i==2){
					if (nextX < 1 || nextX > n || nextY < 1 || nextY > n || map[nextX][nextY] == 1) { // 벽 만나면
						//System.out.println("Mode3 세로"  + " nextX: " + nextX + " nextY: " + nextY+ " I: " + i);
						continue;
					}
				}else {
					if (nextX < 1 || nextX > n || nextY < 1 || nextY > n || map[nextX][nextY] == 1
							|| map[nextX][nextY - 1] == 1 || map[nextX - 1][nextY] == 1)  {
						//System.out.println("Mode3 대각선 실패"  + " nextX: " + nextX + " nextY: " + nextY+ " I: " + i);
						continue;
					}
				}

//				x = nextX;
//				y = nextY;

				if (i == 0)
					mode = 3;
				else if (i == 1)
					mode = 1;
				else
					mode = 2;

				func(mode, nextX, nextY);
			}
		}
	}

}