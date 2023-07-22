package implementation;

import java.util.Scanner;

public class BJO11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 2; i <= n; i++) {
			while(n % i == 0) {
				n /= i;
				System.out.println(i);
			}
		}
	}
}
