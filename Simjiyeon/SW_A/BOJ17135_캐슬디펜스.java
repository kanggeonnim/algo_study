package A형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17135_캐슬디펜스 {
	static int N, M, D;
	static int[][] map;
	static int[][] Map;
	static int arch;
	static int Max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		// 궁수 집합 만들기 위한
		map = new int[N + 1][M];
		Map = new int[N + 1][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Map[i][j] = map[i][j];
			}
		} // 입력 끝

		// 궁수 자리 뽑아서 넣을 배열
		int[] arr = new int[3];
		Archer(0, 0, arr);

		System.out.println(Max);

	}// main

	// 궁수 배치
	public static void Archer(int cnt, int start, int[] arr) {
		// 3명을 뽑았으면 끝
		if (cnt == 3) {
			// 게임 한 판 돌려서 최대효율로 죽일 수 잇는 적의 수 얻기
			int[][] m = new int[N + 1][M];
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					m[i][j] = map[i][j];
				}
			}
			int ans = Attack(arr, m);
			// 현재 최대값과 나온 값 비교 후 max업데이트
//			System.out.println("ans: " + ans + " Max: " + Max);
			Max = Math.max(ans, Max);
			// map 원상복구
			return;
		} // 기저조건

		for (int i = start; i < M; i++) {
			arr[cnt] = i;
			Archer(cnt + 1, i + 1, arr); // 현재 값을 추가했을 때
			Archer(cnt, i + 2, arr);// 현재 값을 추가하지 않았을 때
		}

	}// archer

	public static int Attack(int[] arr, int[][] m) {
		// 배열을 받아서 그곳에 적혀있는 위치에 궁수가 있다고 가정하고 턴제 공격 시작

		// 궁수 배치
		int count = 0; // 전체 배열이 1이 아니어야함
		int kill = 0;
		while (count < N * M) {// 모든 적이 없어지면 끝
			for (int i = 0; i < 3; i++) { // 궁수 다시 초기화
				m[N][arr[i]] = 1;
			}

			count = 0; // 배열이 다시 돌아왔으니 다시 count 초기화

			for (int j = 0; j < M; j++) {// 모든 배열 탐색
				for (int i = N - 1; i >= 0; i--) {

					if (m[i][j] == 1) {// 적이 있따.
						for (int k = 0; k < 3; k++) {// 궁수 자리 3개 탐색
							if (m[N][arr[k]] == 1) {
								// 궁수와의 거리
								int dx = Math.abs(i - N);
								int dy = Math.abs(j - arr[k]); // 궁수 y위치
								if (dx + dy <= D) {
//									System.out.println("ㅇㅇㅇ 가능해 죽어");
									m[i][j] = 0; // 적 죽음
									kill++; // 킬 수 높이기
									m[N][arr[k]] = 0;// 궁수도 무력화 시키기
								}
							}
						}
					} // 적이 자리에 있으면 가까운 궁수부터 탐색
					else {
						count++;
					}
				}
			} // 모든 배열 탐색

			// 배열 당기기
			for (int i = N - 1; i > 0; i--) { // 0열은 놔두고 1열부터 n-1열까지만 당기기
				for (int j = 0; j < M; j++) {
					m[i][j] = m[i - 1][j]; // 위에 있는 칸 당겨오기
				}
			}
			for (int j = 0; j < M; j++) {// 0열 0으로 초기화
				m[0][j] = 0;
			}
//			System.out.println("----------------");
//			print(m);
		} // while(배열에 아직 적이 남아있을 때만 돌리기)

		// 다음 턴을 위해서 배열 당기기
//		System.out.println("############## 끝 ############");
		return kill;
	}

	static void print(int[][] m) {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}// print

}
