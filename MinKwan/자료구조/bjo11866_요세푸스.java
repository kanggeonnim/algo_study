package homework;

import java.util.LinkedList;
import java.util.Scanner;

public class bjo11866_요세푸스 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // n명
		int K = sc.nextInt(); // k번째 사람
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		// 1 2 3 4 5 6 7
		int cnt = 1;
		while (!list.isEmpty()) {

			for (int i = 0; i < list.size(); i++) {

				if (cnt == K) {

					if (list.size() == 1)
						sb.append(list.get(i)).append(">");
					else
						sb.append(list.get(i)).append(", ");
					list.remove(i);
					cnt = 1;
					i -= 1;
					continue;
				}

				cnt++;
			}

		}

		System.out.println(sb);
	}
}
