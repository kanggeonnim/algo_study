import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11582_치킨TOPN {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] input = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());

		int cnt = 0;

		for (int i = 1; i <= N / 2; i++) {
			if (k == N / (2 * i)) {
				cnt = i;
				break;
			}
		}
		// 몇개의 구역으로 나뉘었는지 구함
		long[][] arr = new long[cnt][];
		for (int i = 0; i < cnt; i++) {
			int flag = i * (N / cnt); // 배열에 들어가게 될 개수
			arr[i] = Arrays.copyOfRange(input, flag, flag + N / cnt);
		}

		for (int i = 0; i <= cnt; i++) {
			Arrays.sort(arr[i]);
			for (int j = 0; j < cnt; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}

	}// main

}
