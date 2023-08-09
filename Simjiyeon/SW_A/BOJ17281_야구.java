package A형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17281 {
	static int[][] arr;
	static int N;
	static boolean[] isused = new boolean[9];
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][9];

		for (int i = 0; i < N; i++) {
			StringTokenizer tk1 = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(tk1.nextToken());
			}
		}

		int[] board = new int[9];
		// 1번 선수 고정
		board[3] = 0;
		isused[0] = true;
		max = 0;

		perm(board, 0);
		System.out.println(max);

	}

	static void perm(int[] board, int cnt) {
		if (cnt == 9) { // 1번 선수를 빼고 조합을 완료하면?
			// 1이닝의 점수를 구한다.
			if (play(board) > max) {
				max = play(board);
			}
			return;
		} // 기저조건

		if (cnt == 3) {
			cnt++;
		}

		for (int i = 0; i < 9; i++) {
			if (i == 0)
				continue;
			if (isused[i] == false) {
				isused[i] = true;
				board[cnt] = i;
				perm(board, cnt + 1);
				isused[i] = false;
			}

		} // fori->9
	}

	static int play(int[] board) {
		int score = 0;

		Queue<Integer> q = new LinkedList<Integer>();
		int[] ground = new int[3];// 경지장 타석 0: 1루 , 1: 2루, 2:3루

		for (int i = 0; i < 9; i++) { // q에 사람 넣기
			q.add(board[i]);
		}
		for (int i = 0; i < N; i++) {// 이닝 횟수 돌리기

			for (int k = 0; k < 3; k++) {// ground 초기화
				ground[k] = 0;
			}
			int out = 0; // out 횟수

			while (true) {// 이닝이 끝날때까지 돌리기
				int now = q.poll(); // 현재 선수 큐에서 뽑기
				q.add(now);// 다시 맨 뒤에 큐를 넣는다.

//				if (arr[i][now] == 0) {// 만약 파울이 아니면? 1루에 사람 추가 +1
//					out++; // 만약 파울이라면 out횟수 추가
//				}

				switch (arr[i][now]) {
				case 1:
					score += ground[0];
					ground[0] = ground[1];
					ground[1] = ground[2];
					ground[2] = 1;
					break;
				case 2:
					score += ground[0] + ground[1];
					ground[0] = ground[2];
					ground[1] = 1;
					ground[2] = 0;
					break;
				case 3:
					score += ground[0] + ground[1] + ground[2];
					ground[0] = 1;
					ground[1] = 0;
					ground[2] = 0;
					break;

				case 4:
					score += ground[0] + ground[1] + ground[2] + 1;
					ground[0] = 0;
					ground[1] = 0;
					ground[2] = 0;
					break;

				default:
					out++;
					break;
				}
//코드는 짧아지지만 시간 복잡도 고려하지 않음.
//for문으로 시간이 더 오래걸림
//				for (int k = 0; k < arr[i][now]; k++) { // 경기 진행
//					for (int dir = 1; dir <= 4; dir++) {
//						ground[dir - 1] += ground[dir];
//						ground[dir] = 0;
//					}
//				}

				if (out == 3) {
					break;
				}

			}
			// 홈에 들어온 사람명 수 만큼이 점수니깐 더하기

		}

//		System.out.println(score);
		return score;
	}

	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
