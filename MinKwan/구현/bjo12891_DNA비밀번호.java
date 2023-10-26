	package homework;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.StringTokenizer;
	
	public class bjo12891_DNA비밀번호 {
	
		static char[] dna;
		static int S;
		static int P;
	
		static int A;
		static int C;
		static int G;
		static int T;
	
		static int ans;
	
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken()); // 문자열 길이
			P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
	
			dna = new char[S];
			dna = br.readLine().toCharArray();
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
	
			int a = 0, c = 0, g = 0, t = 0;
			int s = 0;
			int e = P - 1;
	
			for (int i = 0; i < P; i++) {
				char value = dna[i];
	
				switch (value) {
				case 'A': {
					a++;
					break;
				}
				case 'C': {
					c++;
					break;
				}
	
				case 'G': {
					g++;
					break;
				}
	
				case 'T': {
					t++;
					break;
				}
				}
			}
			
			if (a >= A && c >= C && g >= G && t >= T)
				ans++;
	
			while (true) {
	
				switch (dna[s]) {
				case 'A': {
					a--;
					if (a < 0)
						a = 0;
					break;
				}
				case 'C': {
					c--;
					if (c < 0)
						c = 0;
					break;
				}
	
				case 'G': {
					g--;
					if (g < 0)
						g = 0;
					break;
				}
	
				case 'T': {
					t--;
					if (t < 0)
						t = 0;
					break;
				}
				}
	
				s++;
				e++;
				
				if (e == S)
					break;
	
				switch (dna[e]) {
				case 'A': {
					a++;
					break;
				}
				case 'C': {
					c++;
					break;
				}
	
				case 'G': {
					g++;
					break;
				}
	
				case 'T': {
					t++;
					break;
				}
				}
	
				if (a >= A && c >= C && g >= G && t >= T)
					ans++;
	
			}
	
			System.out.println(ans);
		}
	}
