package com.ssafy.z_homework;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 행과 열 boolean 배열을 만들어서 성공과 실패 여부를 count 한다.
 * 행 count, 열 count 중에서 Max 값을 찾아 출력
 */
public class BOJ1236_DefendCastel  {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;

		n = sc.nextInt();
		m = sc.nextInt();
		
		char[][] ary = new char[n][m];
		boolean[] visitedRow = new boolean[n];
		boolean[] visitedCol = new boolean[m];

		int result = 0;
		/*
		 * sc.next() 메소드는 스페이스 즉 공백 전까지 입력받은 문자열 리턴 sc.nextLine() 은 엔터 직전까지 받은 문자열 리턴
		 */

		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				ary[i][j] = str.charAt(j);

			}

		}

		// for(char[] a : ary)System.out.println(Arrays.toString(a));

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(ary[i][j] == 'X') {
					visitedRow[i] = true;
					visitedCol[j] = true;
				}
			}
		}

		int rn = 0;
		for (int i = 0; i < n; i++) {
			if (visitedRow[i] == false) {
				rn++;
			}
		}

		int rc = 0;
		for (int j = 0; j < m; j++) {
			if (visitedCol[j] == false) {
				rc++;
			}
		}

		System.out.println(Math.max(rn, rc));

	}

}