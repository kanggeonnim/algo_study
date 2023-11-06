package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea5656_벽돌깨기 {
	static int N;
	static int W;
	static int H;
	static int maxH;
	static int[][] map;
	static LinkedList<Integer> temp[];
	static int[] selected;
	static int ans;
	static StringBuilder sb = new StringBuilder();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			maxH = 0;
			selected = new int[N];
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 입력 종료

//			for(int i = 0; i<W;i++) {
//				for(int j = 0; j<list[i].size();j++) {
//					System.out.print(list[i].get(j) + " ");
//				}
//				System.out.println();
//			}
			permutation(0);
			if(ans == Integer.MAX_VALUE)
				sb.append("#").append(t).append(" ").append(0).append("\n");
			else
				sb.append("#").append(t).append(" ").append(ans).append("\n");
		} // 테스트케이스 for문

		System.out.println(sb);
	}

	// 중복 순열
	static void permutation(int cnt) {
		if (cnt == N) {

			// Temp 초기화
			deepCopy();
			for (int i = 0; i < N; i++) {
				// 선택한 인덱스가 최고 높이에 있는지부터 판별한다.
				// System.out.println("selected " + selected[i]);
				int pos = selected[i];
				if (temp[pos].isEmpty())
					return;
				explode(pos, temp[pos].size() - 1, temp[pos].getLast());
				sort();
			}
			// System.out.println();
			int rest = getRest();
			//System.out.println(rest);
			ans = Integer.min(rest, ans);
			return;
		}

		for (int i = 0; i < W; i++) {
			selected[cnt] = i;
			permutation(cnt + 1);
		}
	}

	// 발해서 맞춘 곳 폭파
	static void explode(int w, int h, int power) {
		temp[w].set(h, 0);
		for (int i = 0; i < 4; i++) {
			int nx = w;
			int ny = h;
			for (int j = 1; j < power; j++) {
				nx += dx[i];
				ny += dy[i];

				if (nx >= 0 && nx < W && ny >= 0 && ny < temp[nx].size()) {
					explode(nx, ny, temp[nx].get(ny));
				}
			}
		}
	}

	// 숫자 0 인벽돌 파괴
	static void sort() {
		for (int i = 0; i < W; i++) {
			for (int j = temp[i].size() - 1; j >= 0; j--) {
				if (temp[i].get(j) == 0)
					temp[i].remove(j);
			}
		}
	}

	// 최대 높이 판별
	static void getMaxHeight() {
		int max = 0;
		for (int i = 0; i < W; i++) {
			max = Integer.max(max, temp[i].size());
		}
		maxH = max;
	}

	static int getRest() {
		int sum = 0;
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < temp[i].size(); j++) {
				sum++;
			}
		}
		return sum;
	}

	// 깊은 복사 수행
	static void deepCopy() {

		temp = new LinkedList[W];
		for (int i = 0; i < W; i++)
			temp[i] = new LinkedList<>();

		for (int i = H - 1; i >= 0; i--) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0)
					temp[j].add(map[i][j]);
			}
		}
	}

}
