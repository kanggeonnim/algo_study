package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJO6604_re {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/math/6603.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] visited = new boolean[n];
			Arrays.sort(arr);
			combination(arr, visited, 0, n, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void combination(int[] arr, boolean[] visited, int start, int n, int cnt) {
		if(cnt == 6) {
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					sb.append(arr[i]).append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < n - (5 - cnt); i++) {
			visited[i] = true;
			combination(arr, visited, i+1, n, cnt + 1);
			visited[i] = false;
		}
	}
}
