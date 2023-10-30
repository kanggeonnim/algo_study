package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea1225_암호생성기 {
	public static void main(String[] args) {
		int T = 10;
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			sc.nextInt();
			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < 8; i++)
				q.add(sc.nextInt());

			int cnt = 1;
			while (true) {

				if (cnt == 6 ) {
					cnt = 1;
				}
				int val = q.poll() - cnt;
				if (val <= 0) {
					q.add(0);
					break;
				}
				q.add(val);
				cnt++;
			}

			System.out.print("#" + t + " ");

			while (!q.isEmpty())
				System.out.print(q.poll() + " ");
			System.out.println();
		}
	}
}
