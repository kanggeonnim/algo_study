package Homework;

import java.util.Scanner;

public class bjo15650_N과M2 {
	static int n;
	static int r;

	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		visit = new boolean[n];
		
		permutation(0, 0);
	}

	static void permutation(int index, int cnt) {
		if (cnt == r) {
			for (int i = 0; i < n; i++) {
				if(visit[i])
					System.out.print((i+1) + " ");
			}
			System.out.println();
			return;
		}
		if (index == n)
			return;

		visit[index] = true;
		permutation(index + 1, cnt + 1);
		visit[index] = false;
		permutation(index + 1, cnt);

	}
}
