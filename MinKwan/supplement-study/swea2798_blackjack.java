package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2798_blackjack {

	static int n;
	static int max;
	static int resultMax;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());

		arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//입력받기 종료

		BlackJack(0, 0, 0);

		System.out.println(resultMax);
	}

	//블랙잭 재귀 함수
	static void BlackJack(int start, int depth, int sum) {
		//깊이 3까지 도달하면 결고값 구하고 최대값과 같아지면 재귀함수 종료
		if (depth == 3) {
			if (sum > resultMax && sum <= max) {
				resultMax = sum;
				if (sum == max)
					return;
			}

			//가지치기
		} else {
			for (int i = start; i < n; i++) {
				//옆으로 가지치기
				sum += arr[i];
				if (sum <= max)
					BlackJack(i + 1, depth + 1, sum); //밑으로 가지치기
				sum -= arr[i];
			}
		}
	}

}
