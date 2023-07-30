package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ3986 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int count = 0;
		for (int i = 0; i < n; i++) {

			Stack<Character> stack = new Stack<Character>();
			char[] input = br.readLine().toCharArray();

			// 길이가 홀수인경우 좋은단어가 될수없음.
			if (input.length % 2 == 1) {
				continue;
			}
			// 좋은 단어 검사
			for (int j = 0; j < input.length; j++) {
//				 길이의 반절을 검사했을 때 스택에 단어가 남아있다면 좋은 단어가 될 수 없음.
//				if (j == (input.length / 2) && !stack.empty()) {
//					break;
//				}
// 				잘못된 생각. ABAAAABA <-반례예시  
				if (stack.empty()) {
					stack.push(input[j]);
				} else if(stack.peek() == input[j]) {
					stack.pop();
				} else {
					stack.push(input[j]);
				}

			}
			if(stack.empty()) {
				count++;
			}
		}
		
		System.out.println(count);

	}
}
