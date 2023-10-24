package homework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bjo2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		int cnt = 0;

		while (!(q.size() == 1)) {
			if (cnt % 2 == 0)
				q.poll();
			else if (cnt % 2 == 1) {
				q.add(q.poll());
			}
			cnt++;
		}

		System.out.println(q.poll());

	}
}
