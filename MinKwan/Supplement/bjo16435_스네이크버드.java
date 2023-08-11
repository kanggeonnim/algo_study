package day0811;

import java.util.Arrays;
import java.util.Scanner;

public class bjo16435_스네이크버드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int h = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		for (int i : arr) {
			if (i <= h) {
				h+=1;
			}

		}
		
		System.out.println(h);

	}

}
