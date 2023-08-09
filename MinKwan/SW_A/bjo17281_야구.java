
import java.util.Arrays;
import java.util.Scanner;

/*
 * 야구는 9명으로 이루어진 두 팀이 공격과 수비를 번갈아 한다. 하나의 이닝은 공격과 수비로 이루어짐 
 * 한 이닝에 3 아웃이 발생하면 이닝 종료 후, 두 팀이 공격과 수비를 서로 바꾼다.
 * 경기 시작 전에 타순을 정한다. 9번 타자까지 공을 쳤는데 3 아웃이 발 생하지 않은 상태면 이닝은 끝나지 않고, 1번 타자가 다시 타석에 섬.
 * 타순은 이닝이 변경되어도 순서 유지 2번 이닝에 6번 타자가 마지막 타자면, 3 이닝은 7번 타자부터 타석에 섬.
 * 
 * 공격 팀의 선수가 1루, 2루, 3루를 거쳐서 홈에 도착하면 1점 획득. 타자가 1루 2루 3루에 머무를 수 있다. 이들을 주자라고 부른다.
 * 이닝이 시작될 때는 주자가 없다.
 * 
 * 안타: 타자와 모든 주자가 한 루씩 진루
 * 2루타: 타자와 모든 주자가 두 루씩 진루
 * 3루타: 타자와 모든 주자가 세 루씩 진루
 * 홈런: 타자와 모든 주자가 홈까지 진루한다.
 * 아웃: 모든 주자는 진루하지 못하고, 공격 팀에 아웃이 하나 증가
 * 
 * 
 */
public class bjo17281_야구 {

	static int n;
	static int[][] future;
	static int[] members;
	static int[] mappedMembers;
	static int[] selectedMembers1;
	static int[] selectedMembers2;
	static int cnt;
	static boolean[] visit;
	static int max = 0;
	static int sum1, sum2;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		// 각 선수들의 미래 결과를 담는다.
		future = new int[n + 1][10];
		members = new int[10];
		visit = new boolean[10];
		mappedMembers = new int[10];
		selectedMembers1 = new int[10];
		selectedMembers2 = new int[10];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 9; j++) {
				future[i][j] = sc.nextInt();
			}
		}

		members[4] = 1;

		permutation(1);
		System.out.println(max);
//		System.out.println("총 조합의 갯수는: " + cnt);

//		System.out.println("sum1: " + sum1 + " sum2: " + sum2);
//		System.out.println("s1 :" + Arrays.toString(selectedMembers1));
//		System.out.println("s2 :" + Arrays.toString(selectedMembers2));

	}

	// 1번 타자가 4번째에 고정된 채 순열 생성 함수
	static void permutation(int depth) {

		if (depth == 10) {
//			for (int i = 1; i <= 9; i++) {
//				System.out.print(members[i] + " ");
//			}	
//			System.out.println();
			getMaxValue();
			cnt++;

			return;
		}

		for (int i = 2; i <= 9; i++) {
			if (depth == 4) {
				permutation(depth + 1);
			} else {
				if (!visit[i]) {
					visit[i] = true;
					members[depth] = i;
					permutation(depth + 1);
					visit[i] = false;
				}
			}
		}
	}

	// 순열 결과값 구하기
	static void getMaxValue() {

		int index = 1;
		int sum = 0;

		for (int i = 1; i <= n; i++) {

			for (int mapping = 1; mapping <= 9; mapping++) {
				mappedMembers[mapping] = future[i][members[mapping]];
				// System.out.print(mappedMembers[mapping] + " ");
			}
			// System.out.println();

			int outCnt = 0;
			boolean[] ground = new boolean[4];

			while (true) {

				if (mappedMembers[index] == 0) {
					outCnt++;
				} else if (mappedMembers[index] == 1) {
					if (ground[3] == true) {
						sum += 1;
						ground[3] = false;
					}
					if (ground[2] == true)
						ground[3] = true;
					if (ground[1] == true)
						ground[2] = true;

					ground[1] = true;
				} else if (mappedMembers[index] == 2) {
					if (ground[3] == true) {
						sum += 1;
						ground[3] = false;
					}
					if (ground[2] == true) {
						sum += 1;
						ground[2] = false;
					}
					if (ground[1] == true)
						ground[3] = true;

					ground[2] = true;

				} else if (mappedMembers[index] == 3) {
					if (ground[3] == true) {
						sum += 1;
						ground[3] = false;
					}
					if (ground[2] == true) {
						sum += 1;
						ground[2] = false;
					}
					if (ground[1] == true) {
						sum += 1;
						ground[1] = false;
					}

					ground[3] = true;
				} else if (mappedMembers[index] == 4) {
					sum += 1;

					if (ground[3] == true) {
						sum += 1;
						ground[3] = false;
					}
					if (ground[2] == true) {
						sum += 1;
						ground[2] = false;
					}
					if (ground[1] == true) {
						sum += 1;
						ground[1] = false;
					}
				}

				index++;

				if (index > 9) {
					index = 1;
				}

				if (outCnt == 3) {
					break;
				}

			}
//			if (i == 1) {
//				sum1 = sum;
//				selectedMembers1 = mappedMembers;
//			}
//			if (i == 2) {
//				sum2 = sum;
//				selectedMembers2 = mappedMembers;
//			}
		}

		if (sum > max) {
			max = sum;

		}

	}

}
