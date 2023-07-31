package day0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj3986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		int count=0;
		for (int tc = 0; tc < T; tc++) {
			Stack<Character> stack = new Stack<>();
			String arr = br.readLine();
			for(int i=0;i<arr.length();i++) {//한 줄을 읽어들이며 한 단어를 넣고 만약에 
				if(stack.empty()==false&&stack.peek()==arr.charAt(i)) {
					stack.pop();
					//System.out.println(i+"번째 값 빼기");
				}else {
					stack.push(arr.charAt(i));
					//System.out.println(i+"값 입력");
				}
			}
			if(stack.empty()==true) {
				count++;
			}
		}
		
		System.out.println(count);

	}
}
