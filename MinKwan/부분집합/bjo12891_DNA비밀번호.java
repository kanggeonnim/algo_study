package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bjo12891_DNA비밀번호 {

	static char[] chars;
	static int s;
	static int p;
	static int A;
	static int C;
	static int G;
	static int T;
	static boolean[] visit;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken()); // 문자열 기이
		p = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

		chars = new char[s];
		visit = new boolean[s];
		chars = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		subset(0, 0);
		System.out.println(ans);

	}

	
}
