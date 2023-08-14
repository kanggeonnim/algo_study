package day0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16637_괄호추가하기 {
	static char[] arr;
	static int Sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		arr = s.toCharArray();
		perm(1, arr[0] - '0');
		// 1번 연산자에서 괄호를 씌운다 > 1+4연산자로
		// 1번 연산자에서 괄호를 씌우지 않는다. > 1+2연산자로
		int ans = arr[0];
		System.out.println("##############\n" + (ans - '0'));
		System.out.println(Sum);
	}

	// 현재 보는 arr연산자 위치, 그 전까지의 합
	public static void perm(int cnt, int sum) {
		System.out.println("cnt: " + cnt);
		if (cnt >= arr.length) {
			System.out.println("Sum: " + Sum + ", sum: " + sum);
			Sum = Math.max(sum, Sum);
		}
		// 괄호로 묶지 않았을 때
		if (cnt + 2 <= arr.length) {
			int tmp = calc(sum, arr[cnt + 1] - '0', arr[cnt]);
			System.out.printf("%d %c %d \n", sum, arr[cnt], arr[cnt + 1] - '0');
			perm(cnt + 2, tmp);
		}

		// 괄호로 묶었을 때
		if (cnt + 4 <= arr.length && cnt >= 3) {
			int tmp = calc(arr[cnt - 1], arr[cnt + 1] - '0', arr[cnt]);// 괄호안의 계산
			tmp = calc(sum, tmp, arr[cnt - 2]);// 괄호전까지의 합 과 괄호 사이에 있는 연산 실행
			System.out.printf("%d %c %d \n", sum, arr[cnt], arr[cnt + 1] - '0');
			perm(cnt + 4, tmp); // 괄호가 끝나는 데 까지의 연산 전달
		}
	}// perm

	public static int calc(int a, int b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else if (op == '*') {
			return a * b;
		}
		return 0;
	}

}
