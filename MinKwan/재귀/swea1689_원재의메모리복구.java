import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1689_원재의메모리복구 {

	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String str = br.readLine();

			func('0', 0, str);
			
			/* for문을 이용한 정답 찾기
			char now = '0';
			int answer = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != now) {
					// System.out.println(now + " " + answer + " str Index " + str.charAt(i));

					if (now == '0')
						now = '1';
					else
						now = '0';

					answer++;
				}
			}
 
			 */

			System.out.println("#" + t + " " + ans);

		}
	}
	
	
	//재귀를 이용한 탐색
	static void func(char now, int cnt, String str) {

		if (cnt == str.length())
			return;

		if (str.charAt(cnt) != now) {
			if (now == '0')
				now = '1';
			else
				now = '0';

			ans++;
		}

		func(now, cnt + 1, str);

	}
}
