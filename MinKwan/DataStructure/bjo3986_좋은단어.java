package day0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bjo3986 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack();
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {

				char c = ' ';
				if (!stack.empty()) {
					c = stack.peek();
				}

				stack.push(str.charAt(j));

				// 스택에 값을 비교할 만큼 채워져 있다면 비교 실시
				if (!stack.empty()) {
					if (c == stack.peek()) {
						stack.pop();
						stack.pop();
					}
				}
			}

			if (stack.empty()) {
				result++;
			}

		}

		System.out.println(result);

	}

}
