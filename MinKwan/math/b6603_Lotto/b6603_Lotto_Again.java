package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b6603_Lotto_Again {
	static int n;
	static boolean[] visit;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			arr = new int[n];
			visit = new boolean[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			back(0, 0);
			
			System.out.println(sb);

		}
	}

	static void back(int start, int depth) {
		if (depth == 6) {
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					sb.append(arr[i] + " ");
				}
			}
			sb.append('\n');
		} else {
			for (int i = start; i < n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					back(i + 1, depth + 1);
					visit[i] = false;
				}
			}
		}
	}

}
