package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1228 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static LinkedList<Integer> ll;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int test_case = 1; test_case <= 10; test_case++) {
			ll = new LinkedList<Integer>();
			N = Integer.parseInt(br.readLine());
			// 원본 암호문 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				ll.add(Integer.parseInt(st.nextToken()));
			}

			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String input = st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				if (input.equals("I")) {
					int[] tmp = new int[count];
					// 입력받기
					for (int j = 0; j < count; j++) {
						tmp[j] = Integer.parseInt(st.nextToken());
					}
					// LinkedList에 넣기
					for (int j = count - 1; j >= 0; j--) {
						ll.add(index, tmp[j]);
					}
				}
			}
			// 출력
			sb.append("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(ll.get(i) + " ");
			}
			bw.append(sb + "\n");
			bw.flush();
			sb.setLength(0);
		}
		bw.close();
	}
}
