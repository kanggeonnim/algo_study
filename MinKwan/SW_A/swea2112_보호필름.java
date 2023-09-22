import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea2112_보호필름 {

	// 두께, 가로크기 ,합격기준
	static int T, D, W, K;
	static int[][] map;
	static boolean[] visit;
	static ArrayList<Medicine> list;
	static int min;

	static class Medicine {
		int x;
		int version;

		public Medicine(int x, int version) {
			this.x = x;
			this.version = version;
		}

	}

	// A는 0 B는 1
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;
			map = new int[D][W];
			visit = new boolean[D];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			subset(0);
			System.out.println("#" + t + " " + min);
		}

	}

	// 약을 어디에 넣을지를 구하는 부분집합
	static void subset(int cnt) {

		if (cnt == D) {
			list = new ArrayList<Medicine>();
			for (int i = 0; i < D; i++) {
				if (visit[i]) {
					list.add(new Medicine(i, 0));
					//System.out.print(i + " ");
				}
				// medicine의 초기값은 0, 즉 A
			}
			//System.out.println();
			subsetVersion(0);
			return;
		}
		visit[cnt] = true;
		subset(cnt + 1);
		visit[cnt] = false;
		subset(cnt + 1);

	}

	// 약의 버전 구하는 부분집합
	static void subsetVersion(int cnt) {
		if (cnt == list.size()) {
			change();
			return;
		}

		list.get(cnt).version = 0;
		subsetVersion(cnt + 1);
		list.get(cnt).version = 1;
		subsetVersion(cnt + 1);
	}

	// 약 투하
	static void change() {

		int[][] temp = new int[D][W];

		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i).x;
			int v = list.get(i).version;
			for (int j = 0; j < W; j++) {
				temp[x][j] = v;

			}
		}

		check(temp);
	}

	// 검사
	static void check(int[][] temp) {

		for (int i = 0; i < W; i++) {
			int cnt = 0;
			int value = temp[0][i];
			for (int j = 0; j < D; j++) {
				if (temp[j][i] == value) {
					cnt++;
				} else {
					value = temp[j][i];
					cnt = 1;
				}

				// 통과 바로 다음 셀 검사
				if (cnt == K)
					break;
			}

			// 불합격이므로 검사할 가치가 없음
			if (cnt < K)
				return;
		}

		// 여기까지 왔으면 다 통과...대박..!!
//		for(int[] t : temp) {
//			System.out.println(Arrays.toString(t));
//		}
//		for(int i = 0; i<list.size();i++)
//			System.out.println("x " + list.get(i).x + " version " + list.get(i).version);
//		System.out.println("-----------------------");
		min = Math.min(min, list.size());
	}

}
