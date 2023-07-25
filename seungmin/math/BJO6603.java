package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJO6603 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int[] answer = new int[6];
	static int n;
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/math/6603.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			
			arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void combination(int start, int cnt) {
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < n - (5 - cnt); i++) {
			answer[cnt] = arr[i];
			combination(i + 1, cnt + 1);
		}
	}
}
