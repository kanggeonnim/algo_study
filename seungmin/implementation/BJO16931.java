package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJO16931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		int front = 0;
		int side = 0;
		int under = n * m * 2;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			int line = arr[i][0] + arr[i][m-1];
			for (int j = 0; j < m-1; j++) {
				line += Math.abs(arr[i][j] - arr[i][j+1]);
			}
			side += line;
		}
		
		for(int i = 0; i < m; i++) {
			int line = arr[0][i] +arr[n-1][i];
			for (int j = 0; j < n-1; j++) {
				line += Math.abs(arr[j][i] - arr[j+1][i]);
			}
			front += line;
		}
		
		System.out.print(front + side + under);
	}
}
