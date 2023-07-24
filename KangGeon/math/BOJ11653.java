package Algorithm;

import java.util.Scanner;

public class BOJ11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 1) {
			System.out.println("");
		} else {
			int div = 2;
			while (true) {

				if ((n / div) == 1 && (n % div) == 0) {
					System.out.println(div);
					break;
				}
				if (n % div == 0) {
					System.out.println(div);

					n = n / div;

					div = 2;
				} else {
					div++;
				}
			}
		}
	}
}
