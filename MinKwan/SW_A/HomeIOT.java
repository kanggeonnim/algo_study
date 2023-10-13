package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

//N 크기의 맵에 R 통신 범위를 가진 AP(5개 제한) 배치
//맵에 숫자로 AP가 설치될 수 있는 위치와 IOT 설치 위치가 표시된다. 
//AP가 설치될 수 있는 위치는 9로 표시. 1~3이 적힌 곳은 IOT가 설치되고, IOT의 통신 범위
//모든 IOT는 AP와 최소한 하나이상 꼭 통신되어야 한다.
//이때, 모든 IOT가 통신이 가능한 AP의 최소 개수는 몇개인가?


public class HomeIOT {

	static int N;
	static int R;

	static ArrayList<IOT> iotlist;
	static ArrayList<AP> aplist;
	static boolean[] selected;
	static int ans;

	
	static class IOT {
		int x;
		int y;
		int range;

		public IOT(int x, int y, int range) {
			this.x = x;
			this.y = y;
			this.range = range;
		}
	}

	static class AP {
		int x;
		int y;

		public AP(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		aplist = new ArrayList<>();
		iotlist = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int val = sc.nextInt();

				if (val == 9)
					aplist.add(new AP(i, j));
				else if (val > 0)
					iotlist.add(new IOT(i, j, val));
			}

		}
		ans = Integer.MAX_VALUE;
		selected = new boolean[aplist.size()];
		// 입력 종료
		
		
		
		subset(0);
		
		
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	// 부분집합
	static void subset(int cnt) {

		if (cnt == aplist.size()) {

			match();

			return;
		}

		selected[cnt] = true;
		subset(cnt + 1);
		selected[cnt] = false;
		subset(cnt + 1);

	}

	//뽑아낸 부분집합으로 추려내기
	static void match() {
		ArrayList<AP> temp = new ArrayList<>();

		// 선택된 부분집합을 ArrayaList에서 뽑아내서 temp에 저장한다.
		for (int i = 0; i < aplist.size(); i++) {
			if (selected[i]) {
				temp.add(aplist.get(i));
			}
		}

		// 공집합이면 계산할 필요가 없다.
		if (temp.size() == 0)
			return;

		// IOT 성공 개수 확인용 cnt
		int cnt = 0;

		
		//IOT의 통신 범위 + AP의 통신 범위를 기준으로 거리 비교 수행
		for (int i = 0; i < iotlist.size(); i++) {
			IOT iot = iotlist.get(i);
			int x = iot.x;
			int y = iot.y;
			int range = iot.range;

			for (int j = 0; j < temp.size(); j++) {

				int dis = Math.abs(x - temp.get(j).x) + Math.abs(y - temp.get(j).y);

				System.out.println(i + " 번 IOT와 " + j + " 번 AP의 거리 : " + dis + " " + " 기준 거리: " + (range + R));
				if (dis <= range + R) {
					cnt++;
					break;
				}
			}
		}

		if (cnt == iotlist.size())
			ans = Math.min(ans, temp.size());
	}

}
