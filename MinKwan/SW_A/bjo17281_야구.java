package day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bjo17281_야구 {

	static int N;
	static int[] members; // 선수들의 경기 순서를 기록
	static int[][] membersStat; // 선수들의 타율
	static boolean[] visit;
	static int max = 0;
	static int num = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		membersStat = new int[N][10];
		visit = new boolean[10];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				membersStat[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		members = new int[10];
		members[4] = 1;
		visit[1] = true;

		permutation(1);

		System.out.println(max);
		// System.out.println(num);
	}

	static void permutation(int cnt) {
		if (cnt == 10) {
			max = Math.max(max, getMaxScore());
			num++;
			return;
		}

		if (cnt == 4) {
			permutation(cnt + 1);
			return;
		}

		for (int i = 2; i <= 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				members[cnt] = i;
				permutation(cnt + 1);
				visit[i] = false;
			}
		}
	}

	// 여기서 시간초과 발생
	static int getMaxScore() {

		int start = 1; // 시작 타자
		int score = 0;

		// 한 이닝에서 낼 수 있는 최대 점수는 24점
		for (int i = 0; i < N; i++) { // 이닝 for문

//			if (max > score + ((N - i) * 24)) {
//				break;
//			}

			int out = 0; // out이 3이 될때까지 게임 반복
			int base[] = new int[4];

			while (true) { // out이 3이 될때까지 반복

				if (start > 9)
					start = 1;

				int memberStat = membersStat[i][members[start++]];

				if (memberStat == 0) {
					++out;

					if (out == 3)
						break;

				} else if (memberStat == 1) {

					score += base[3];

					base[3] = base[2];
					base[2] = base[1];
					base[1] = 1;

				} else if (memberStat == 2) {

					score += base[3] + base[2];

					base[3] = base[1];
					base[2] = 1;
					base[1] = 0;

				} else if (memberStat == 3) {
					score += base[3] + base[2] + base[1];

					base[3] = 1;
					base[2] = 0;
					base[1] = 0;

				} else if (memberStat == 4) {
					score += base[3] + base[2] + base[1] + 1;

					base[3] = 0;
					base[2] = 0;
					base[1] = 0;

				}
			}
		}

		return score;

	}

}
