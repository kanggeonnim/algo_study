package implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJO6603 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(sc.nextLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] visited = new boolean[n];
			Arrays.sort(arr);
			combination(arr, visited, 0, n, 0);
			System.out.println();
		}
	}
	
	static void combination(int[] arr, boolean[] visited, int start, int n, int cnt) {
		if(cnt == 6) {
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					System.out.printf("%d ", arr[i]);
				}
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < n - (5 - cnt); i++) {
			visited[i] = true;
			combination(arr, visited, i+1, n, cnt + 1);
			visited[i] = false;
		}
	}
}
