package Homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1208_Flatten {

	static int N;
	static int[] arr;
	static int ans;
	static int max;
	static int maxIndex;
	static int min;
	static int minIndex;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int t = 1; t <= T; t++) {

			// 덤프 횟수
			N = Integer.parseInt(br.readLine());
			ans = 0;
			arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 입력 끝

			for (int i = 0; i < N; i++) {
	
				Arrays.sort(arr);
				arr[0] += 1;
				arr[99] -= 1;
			}
			Arrays.sort(arr);
			ans = arr[99] - arr[0];
		

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		} // 테스트케이스 For문

		System.out.println(sb);

	}

	static void Dump() {

		max = 0;
		maxIndex = 0;
		min = Integer.MAX_VALUE;
		minIndex = 0;

		for (int j = 0; j < 100; j++) {
			if (arr[j] > max) {
				max = arr[j];
				maxIndex = j;
			} else if (arr[j] < min) {
				min = arr[j];
				minIndex = j;
			}
		}

		arr[maxIndex] -= 1;
		arr[minIndex] += 1;
	}

	static int findDif() {

		max = 0;
		min = Integer.MAX_VALUE;

		for (int j = 0; j < 100; j++) {
			if (arr[j] > max) {
				max = arr[j];
			} else if (arr[j] < min) {
				min = arr[j];
			}
		}

		return max - min;
	}
}
