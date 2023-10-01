import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bjo15649_N과M {

	static boolean[] visit;
	static Integer[] arr;
	static int N;
	static int M;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N + 1];
		arr = new Integer[M];
		sb = new StringBuilder();

		Combination(1, 0);
		System.out.println(sb);
	}

	static void Combination(int index, int cnt) {

		if (cnt == M) {
			for (int i = 0; i < M; i++) {


				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = index; i <= N; i++) {
				arr[cnt] = i;
				Combination(i, cnt + 1);
		
		
		}

	}
}
