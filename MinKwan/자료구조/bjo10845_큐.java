package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bjo10845_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<Integer> q = new ArrayDeque<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int val = 0;
			if (st.hasMoreTokens())
				val = Integer.parseInt(st.nextToken());

			if (str.equals("push")) {
				q.add(val);
			} else if (str.equals("front")) {
				if (q.isEmpty())
					System.out.println("-1");
				else
					System.out.println(q.peek());
			} else if (str.equals("back")) {
				if (q.isEmpty())
					System.out.println("-1");
				else
					System.out.println(q.peekLast());
			} else if (str.equals("pop")) {
				if (q.isEmpty())
					System.out.println("-1");
				else
					System.out.println(q.poll());
			} else if (str.equals("size")) {
				System.out.println(q.size());
			} else if (str.equals("empty")) {
				if (q.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
			}
		}

	}
}
