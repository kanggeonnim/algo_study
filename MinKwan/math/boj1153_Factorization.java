package com.ssafy.z_homework;

import java.util.Scanner;

public class boj1153_Factorization {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean check = false;
		if (n == 1) {
			return;
		} else {
			while (true) {

				check = false;

				for (int i = 2; i <= n / 2; i++) {

					if (n % i == 0) {
						System.out.println(i);
						n /= i;
						check = true;
						break;
					}
				}

				if (!check) {
					System.out.println(n);
					n /= n;
				}
			
				if (n <= 1)
					break;

			}

		}
	}

}
