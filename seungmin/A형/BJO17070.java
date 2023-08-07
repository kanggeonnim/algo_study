package bjo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJO17070_2 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/BJO17070.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int[][][] arr = new int[n][n][3];
		arr[0][1][0] = 1;
		int[][] arr2 = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				if(st.nextToken().equals("1")) arr2[i][j] = 1;
			}
		}
		
		for(int x = 0; x < n; x++) {
			for(int y = 1; y < n; y++) {
				if(y < n-1 && x < n-1 && arr2[x+1][y] + arr2[x][y+1] + arr2[x+1][y+1] == 0)
					arr[x+1][y+1][1] += arr[x][y][0] + arr[x][y][1] + arr[x][y][2];
				if(y < n-1 && arr2[x][y+1] == 0)
					arr[x][y+1][0] += arr[x][y][0] + arr[x][y][1];
				if(x < n-1 && arr2[x+1][y] == 0)
					arr[x+1][y][2] += arr[x][y][1] + arr[x][y][2];
			}
			
		}
		
		System.out.println(Arrays.stream(arr[n-1][n-1]).sum());
	}
}
