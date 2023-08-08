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
//		print(board);
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
		int out = 0; // out 횟수
		Queue<Integer> q = new LinkedList<Integer>();
		int[] ground = new int[5];// 경지장 타석 0: 홈 , 1: 3루, 2:2루, 3:1루

		for (int i = 0; i < 9; i++) { // q에 사람 넣기
			q.add(board[i]);
		}
		for (int i = 0; i < N; i++) {// 이닝 횟수 돌리기
			
			while (true) {// 이닝이 끝날때까지 돌리기
				int now = q.poll(); // 현재 선수 큐에서 뽑기
				q.add(now);// 다시 맨 뒤에 큐를 넣는다.
				
				System.out.println(now+"선수의 "+i+"이닝 점수: "+arr[i][now]);
				if (arr[i][now] ==0) {// 만약 파울이 아니면? 1루에 사람 추가 +1
					out++; // 만약 파울이라면 out횟수 추가
				}else {
					ground[4] = 1;
				}
				
				for (int k = 0; k < arr[i][now]; k++) { //경기 진행
					for (int dir = 1; dir <= 4; dir++) {
						ground[dir - 1] += ground[dir];
						ground[dir] = 0;
					}
				}
				
				if (out == 3) {
					break;
				}

			}
			System.out.println("##########################");
			print(board);
			System.out.println(i+"번째 이닝 점수: "+ground[0]);
			// 홈에 들어온 사람명 수 만큼이 점수니깐 더하기
			score += ground[0];

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
