package bjo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		// Valid : 1, inValid: 0
		// (), [], {}, <>
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < n; i++) {
				char c = (char) (br.read());

				if (c == ')') {
					if (st.isEmpty() || st.peek() != '(') {
						sb.append("#").append(t).append(" ").append("0").append("\n");
						break;
					} else {
						if (i == n - 1) {
							st.pop();
							sb.append("#").append(t).append(" ").append("1").append("\n");
						} else
							st.pop();
						continue;
					}
				} else if (c == ']') {
					if (st.isEmpty() || st.peek() != '[') {
						sb.append("#").append(t).append(" ").append("0").append("\n");
						break;
					} else {
						if (i == n - 1) {
							st.pop();
							sb.append("#").append(t).append(" ").append("1").append("\n");
						} else
							st.pop();
						continue;
					}
				} else if (c == '}') {
					if (st.isEmpty() || st.peek() != '{') {
						sb.append("#").append(t).append(" ").append("0").append("\n");
						break;
					} else {
						if (i == n - 1) {
							st.pop();
							sb.append("#").append(t).append(" ").append("1").append("\n");
						} else
							st.pop();
						continue;
					}
				} else if (c == '>') {
					if (st.isEmpty() || st.peek() != '<') {
						sb.append("#").append(t).append(" ").append("0").append("\n");
						break;
					} else {
						if (i == n - 1) {
							st.pop();
							sb.append("#").append(t).append(" ").append("1").append("\n");
						} else
							st.pop();
						continue;
					}
				}
				st.add(c);

				// System.out.print(c);
			}
			br.readLine();
			// System.out.println();

		}
		System.out.println(sb);
	}
}
