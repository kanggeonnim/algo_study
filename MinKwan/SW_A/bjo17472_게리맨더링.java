package day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bjo17472_게리맨더링 {

	static int N;
	static int[] people;
	static int[][] adjMat;
	static boolean[] visit;		 //부분집합 뽑아내기용
	static boolean[] isSelected; // DFS용
	static int d;				

	// 뽑아낸 부분집합 저장용 배열
	static ArrayList<Integer> A;
	static ArrayList<Integer> B;

	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		people = new int[N + 1];
		adjMat = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		isSelected = new boolean[N + 1];
		ans = -1;

		A = new ArrayList<>();
		B = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				adjMat[i][a] = 1;

			}

		}

		// 입력 종료

		subset(1);
		System.out.println(ans);

	}

	// 부분집합 생성 함수 , 여기서 부분집합 생성 -> 선거 지역구 유효성 검사 함수 -> 사람들 차 구하기 함수 실행
	static void subset(int cnt) {
		if (cnt == N) {

			A = new ArrayList<>();
			B = new ArrayList<>();

			for (int i = 1; i <= N; i++) {
				if (visit[i] == true) {
					A.add(i);
				} else
					B.add(i);
			}

			if (A.size() > 0 && B.size() > 0) {

				boolean checkA = false;
				boolean checkB = false;

				isSelected = new boolean[N + 1];
				d = 1;

				DFS(A.get(0), 'A');

				if (d == A.size())
					checkA = true;
				else
					return;

				isSelected = new boolean[N + 1];
				d = 1;

				DFS(B.get(0), 'B');

				if (d == B.size())
					checkB = true;
				else
					return;

				if (checkA && checkB) {
					int sum = getPeopleSubtract();
					if (ans == -1 || ans > sum) {
						ans = sum;
					}
				}

				// System.out.println(checkA + " " + checkB);
			}

			return;
		}

		visit[cnt] = true;
		subset(cnt + 1);
		visit[cnt] = false;
		subset(cnt + 1);
	}

	// 인접 행렬을 통해 유효한지 체크하는 DFS 함수
	static void DFS(int v, char c) {

		isSelected[v] = true;
		if (c == 'A') {
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < A.size(); j++) {
					if (adjMat[v][i] == 1 && i == A.get(j) && !isSelected[A.get(j)]) {
						// System.out.println("DFS 타고가기 A형 " + " v, i, j, d " + v + " " + i + " " + j +
						// " " + (d + 1));
						d++;
						DFS(A.get(j), 'A');
					}
				}

			}
		} else {
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < B.size(); j++) {
					if (adjMat[v][i] == 1 && i == B.get(j) && !isSelected[B.get(j)]) {
						d++;
						DFS(B.get(j), 'B');
					}
				}

			}
		}

	}
	
	
	//인구 수 차이 구하기
	static int getPeopleSubtract() {

		int aSum = 0;
		int bSum = 0;

		for (int a : A) {
			aSum += people[a];
		}

		for (int b : B) {
			bSum += people[b];
		}

		return Math.abs(aSum - bSum);
	}

}
