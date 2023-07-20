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
			int sum = 0;
			int std = 0;
			for (int j = 0; j < m; j++) {
				sum += Math.abs(std - arr[i][j]);
				std = arr[i][j];
			}
			sum += std;
			side += sum;
		}
		
		for(int i = 0; i < m; i++) {
			int sum = 0;
			int std = 0;
			for (int j = 0; j < n; j++) {
				sum += Math.abs(std - arr[j][i]);
				std = arr[j][i];
			}
			sum += std;
			front += sum;
		}
		
		System.out.print(front + side + under);
	}
}
