package algorithm;

import java.util.Scanner;

public class bjo2023_신기한소수 {
	static int N;
	static int ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if (N == 1) {
			for (int i = 1; i <= 9; i++) {
				if (i == 2 || i == 3 || i == 5 || i == 7) {
					System.out.println(i);
				}
			}
			return;
		} else {
			for (int i = 1; i <= 9; i++) {
				if (i == 2 || i == 3 || i == 5 || i == 7) {
					func(Integer.toString(i), 2);
				}
			}
			System.out.println(sb);
		}

	}

	public static void func(String str, int cnt) {

		for (int i = 1; i <= 9; i++) {
			int val = Integer.parseInt(str + i);
		//	System.out.println("시도 중..." + val);
			boolean check = true;
			for (int j = 2; j <= val / 2; j++) {
				if (val % j == 0) {
					check = false;
					break;
				}
			}

			if (check) {
				if (cnt == N) {
					//System.out.println("성공 "  + val);
					sb.append(val).append("\n");
					continue;
				}
				func(Integer.toString(val), cnt + 1);
			}
		}
	}
}
