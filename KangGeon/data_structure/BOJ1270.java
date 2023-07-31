package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1270 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			HashMap<String, Integer> soldiers = new HashMap<String, Integer>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			// 케이스별로 검사
			String name = "";
			for (int j = 0; j < n; j++) {

				String num = st.nextToken();
				if (soldiers.containsKey(num)) {
					int value = soldiers.get(num) + 1;
					// 절반 넘었는지 검사.
					if (value > n / 2) {
						name = num;
						break;
					}
					soldiers.put(num, value);
					
				} else {
					soldiers.put(num, 1);
				}

			}
			if (name.length() == 0) {
				System.out.println("SYJKGW");
			} else {
				System.out.println(name);
			}
		}
	}
}