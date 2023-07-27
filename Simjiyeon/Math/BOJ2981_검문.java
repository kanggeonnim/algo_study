package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2981 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
			if (arr[i] > max) {
				max = arr[i];
			}
		} // input for문

		

		for (int k = 2; k < max; k++) {
			int remain = arr[0] % k;
			for (int i = 0; i < n; i++) {
				if (remain != arr[i] % k) {
					break;
				}
				if (i == n - 1) {
//					System.out.print(k+" ");
					bw.write(k+" ");
				}

			}
			bw.flush();
			//System.out.println("현재 나누어본 수: "+k);
		}
		bw.close();

	}// main
}
