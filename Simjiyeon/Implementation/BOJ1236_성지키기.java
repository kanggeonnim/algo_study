package day0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1236_성지키기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());

		char[][] arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j);
				// System.out.println(arr[i][j]);
			}
		}
		
		int[] row=new int[n];
		int[] col = new int[m];
		
		// (n,n) 지점만 검색해서 검사 *가로기준으로만 서치 돌리기
		for (int i = 0; i < n; i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]=='X') {
					row[i]=1;
					col[j]=1;
				}
			}
		}

		int r_count = 0;
		int c_count=0;
		//x가 포함되어있지 않은 행의 수와 열의 수를 각각 구해서 비교 후 큰 것을 결과로 출력
		for (int i = 0; i < n; i++) {
			if(row[i]==0) {
				r_count++;
			}
			//System.out.println();
		}
		
		for (int j = 0; j < m; j++) {
			if(col[j]==0) {
				c_count++;
			}
		}
		
		int result =0;
		
		if(r_count<=c_count) {
			result = c_count;
		}else result = r_count;

		System.out.println(result);

	}
}
