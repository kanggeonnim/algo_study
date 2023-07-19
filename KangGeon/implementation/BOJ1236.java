package day0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1236 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] nArray = new int[50];
		int[] mArray = new int[50];

		st = new StringTokenizer(br.readLine());
		int[] nums = new int[2];
		for(int i = 0; i < 2; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		// n, m 크기만큼 1로 초기화.
		for (int i = 0; i < nums[0]; i++) {
			nArray[i] = 1;
		}

		for (int i = 0; i < nums[1]; i++) {
			mArray[i] = 1;
		}
		// 입력받은 값이 X이면 해당 열의 가로축과 세로축의 배열값(nAraay, mArray)을 0으로 초기화함.
		// 경비원 한명을 배치하면 가로축와 세로축 하나씩을 경비할 수 있으므로 Array중 1값이 더 많이남은만큼 경비원 필요.
		for (int i = 0; i < nums[0]; i++) {
			String input = br.readLine();
			for (int j = 0; j < nums[1]; j++) {
				if('X' == input.charAt(j)) {
					nArray[i] = 0;
					mArray[j] = 0;
				}
			}
		}
		
		int nCount = 0;
		int mCount = 0;
		for (int i = 0; i < nums[0]; i++) {
			if(nArray[i] == 1) {
				nCount++;
			}
		}

		for (int i = 0; i < nums[1]; i++) {
			if(mArray[i] == 1) {
				mCount++;
			}
		}
		
		if(nCount >= mCount) {
			System.out.println(nCount);
		}else {
			System.out.println(mCount);
		}

	}

}
