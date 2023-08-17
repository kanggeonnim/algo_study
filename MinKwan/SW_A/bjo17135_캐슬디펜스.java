import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bjo17135_캐슬디펜스 {

	static int N;
	static int M;
	static int D;
	static int result;
	static int[][] arr;
	static Archer[] archers;
	static List<Enemy>[] enemies;

	// 격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		// 2차원 배열을 열 기준으로 쪼갠다.
		enemies = new ArrayList[M];
		archers = new Archer[3];

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			enemies[i] = new ArrayList<Enemy>();
			for (int j = 0; j < N; j++) {
				Enemy enemy = new Enemy();
				enemy.x = j;
				enemy.y = i;
				enemy.value = arr[j][i];
				enemies[i].add(enemy);
			}
		}

		// 입력 끝

		// 조합으로 궁수 배치 순서를 구한 뒤에 최대 값 구하기
		// 궁수 클래스, 적 클래스 만들기

		combination(0, 0);
		System.out.println(result);

	}

	static class Enemy {
		int x;
		int y;
		int value;
	}

	static class Archer {
		int x = N;
		int y;
		int distance;
	}

	// 궁수 순서 뽑아내는 조합
	static void combination(int start, int cnt) {
		if (cnt == 3) {

			for (int i = 0; i < 3; i++) {
				System.out.print(archers[i].y + " ");
			}
			System.out.println();

			Fight();

			// 최대값 구하기

			return;
		}

		for (int i = start; i < M; i++) {
			Archer archer = new Archer();
			archer.y = i;
			archers[cnt] = archer;
			combination(i + 1, cnt + 1);
		}

	}

	// 격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.

	static void Fight() {

		// archer 한 명씩 자기 최대 사거리 내의 적들을 순차적으로 탐색
		// 최소 거리를 가진 적을 찾고 count를 올려준다.
		// 최소값을 담아놓은 배열
		int sum = 0;
		int index = 0;
		List<Enemy>[] tempEmenies = new ArrayList[M];
		deepCopy(tempEmenies);

		while (true) {
			int[] mins = new int[3];
			Enemy[] minEnemies = new Enemy[3];

			for (int i = 0; i < 3; i++) { // archers

				mins[i] = Integer.MAX_VALUE;

				for (int j = 0; j < tempEmenies.length; j++) {

					// enemies list의 수, enemies의 마지막 원소와 궁수들의 거리를 비교하여 불필요한 연산을 줄인다.
					
//					System.out.println("eneimes 거리 유효성 조사  j" + " I " + i + " J " + j + " 크기 " + tempEmenies[i].size());
//					System.out.println(getDistance(i, j, tempEmenies));
					
					
					//******************2차원 배열로 다시 바꾸기....!******************  
					if (getDistance(i, j, tempEmenies) < D) {
						System.out.println("거리 유효성 탈락 " + getDistance(i, j, tempEmenies));
						for (int removeFor = 0; removeFor < M; removeFor++) {
							tempEmenies[i].remove(tempEmenies[i].size() - 1);

						}

						continue;
					}

					for (int k = tempEmenies[j].size() - 1; k >= 0; k--) { // enemies list[j]의 인덱스 만큼 거꾸로 계산
						// System.out.println("eneimes 요소 탐색 k");

						if (tempEmenies[j].get(k).value == 0) // 적이 없으면 0
							continue;

						int DistanceWithEnemy = getDistance(i, j, k, tempEmenies); // 적과의 거리를 담은 변수

						if (DistanceWithEnemy <= D) {
							if (mins[i] > DistanceWithEnemy) {
								System.out.println(" enemy 하나 저장 " + " i " + i + " j " + j + " k " + k + "        "
										+ DistanceWithEnemy);
								mins[i] = DistanceWithEnemy;
								minEnemies[i] = tempEmenies[j].get(k);
							}

						} else {
							System.out.println("궁수와 적의 거리가 멀다  " + " i " + i + " j " + j + " k " + k + "        "
									+ DistanceWithEnemy + " 적의 위치: " + tempEmenies[j].get(k).x + " "
									+ tempEmenies[j].get(k).y + " 궁수 위치 " + archers[i].x + "  " + archers[k].y);
							break;
						}

					}
				}
			}

			for (int i = 0; i < 3; i++) {
				if (minEnemies[i] != null) {
					arr[minEnemies[i].x][minEnemies[i].y] = -1;
					minEnemies[i] = null;
					sum++;
				}
			}

			for (int i = 0; i < M; i++) {
				tempEmenies[i].remove(tempEmenies[i].size() - 1);
			}

			if (tempEmenies[0].size() == 0)
				break;

			System.out.println(" Index " + index + " Sum " + sum);
			index++;
		}

		if (sum > result)
			result = sum;

	}

	static int getDistance(int i, int j, List<Enemy>[] tempEmenies) {
		return Math.abs(archers[i].x - tempEmenies[j].get(tempEmenies[j].size() - 1).x)
				+ Math.abs(archers[i].y - tempEmenies[j].get(tempEmenies[j].size() - 1).y);
	}

	// 함숨 오버로딩??
	static int getDistance(int i, int j, int k, List<Enemy>[] tempEmenies) {
		return Math.abs(archers[i].x - tempEmenies[j].get(k).x) + Math.abs(archers[i].y - tempEmenies[j].get(k).y);
	}

	// 깊은 복사
	static void deepCopy(List<Enemy>[] tempEmenies) {

		for (int i = 0; i < M; i++) {
			tempEmenies[i] = new ArrayList<Enemy>();

			for (int j = 0; j < N; j++) {
				Enemy enemy = new Enemy();
				enemy.x = j;
				enemy.y = i;
				enemy.value = arr[j][i];
				tempEmenies[i].add(enemy);
			}
		}
	}

}
