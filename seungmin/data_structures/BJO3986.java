package data_structures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BJO3986 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/data_structures/3986.txt"));
		Scanner sc = new Scanner(System.in);

		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			stack.clear();
			char[] s = sc.next().toCharArray();

			for (char c : s) {
				if (!stack.isEmpty() && stack.peek() == c) stack.pop();
				else stack.push(c);
			}
			if(stack.isEmpty()) cnt += 1;
		}
		
		System.out.println(cnt);
	}
}
