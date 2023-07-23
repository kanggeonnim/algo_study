package implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJO1028 {
	static int r;
	static int c;
	static char[][] arr;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(arr[i][j] == '1') {
					diamond(i, j);
				}
			}
		}
		
		System.out.print(max);
		
	}
	
	public static void diamond(int x, int y) {
		int[] dx = {1, 1, -1, -1};
		int[] dy = {-1, 1, 1, -1};
		int cx = x;
		int cy = y;
		
		outer: for(int i = max + 1;; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 1; k < i; k++) {
					x += dx[j];
					y += dy[j];
					if(!(0 <= x && x < r && 0 <= y && y < c && arr[x][y] == '1')) {
						if(j == 0) {
							break outer;
						} else {
							x = cx;
							y = cy;
							continue;
						}
					}
					
				}
			}
			max = Math.max(max, i);
		}
	}
}
