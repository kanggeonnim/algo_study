package BOJ16931;

import java.util.Scanner;

public class BOJ16931_겉넓이구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		///////////////// 입력

		// 가로 확인 차이 값을 더해주고 처음과 마지막엔 각 수를 더해준다.
		int pre = arr[0][0];
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			result+=arr[i][0]; // 처음 수 더하기
			//System.out.println("가로"+i+"번쨀 줄 처음 수 저장: "+result);
			//중간 차이값 더하기
			for (int j = 0; j < m-1; j++) {
				int d = arr[i][j] - arr[i][j+1];
				if(d<0) d=-d;
				result+=d;
				//System.out.println("세로 j: "+j+", j+1:"+(j+1)+"부분 차이값 저장: "+result);

			}
			//마지막값 더하기
			//System.out.println("가로"+i+"번쨀 줄 마지막 수 저장: "+result);
			result+=arr[i][m-1];
		}
		//세로 겉넓이 시작
		pre = arr[0][0];
		for (int j = 0; j < m; j++) {
			result+=arr[0][j]; // 처음 수 더하기
			//System.out.println("세로"+j+"번쨀 줄 처음 수 저장: "+result);
			//중간 차이값 더하기
			for (int i = 0; i < n-1; i++) { 
				int d = arr[i][j] - arr[i+1][j];
				if(d<0) d=-d;
				result+=d;
				//System.out.println("세로 i: "+i+", i+1: "+(i+1)+"부분 차이값 저장: "+result);

			}
			//마지막값 더하기
			result+=arr[n-1][j];
			//System.out.println("세로"+j+"번쨀 줄 마지막 수 저장: "+result);
		}
		//바닥 + 천장 넓이
		result+=n*m*2;
		
		System.out.println(result);
		
		
		
		

	}
}
