package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class bjo1270_전쟁_땅따먹기 {

	/*
	 * 주어지는 병사의 번호가 엄청 커서 배열에 숫자를 늘려가는 방식으로 찾는건 불가능하다.
	 * 
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 지역의 수
		int n = Integer.parseInt(br.readLine());

		// 특정 주둔 군대 번호가 절반을 초과하면 그 땅을 지배 중
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			// 지역에 주둔 중인 군대
			int armyNum = Integer.parseInt(st.nextToken());

			// 해싱을 위한 해시맵
			Map<Long, Integer> hashMap = new HashMap<Long,Integer>();

			int max = 0;
			long maxIdx = 0;

			for (int j = 0; j < armyNum; j++) {
				long val = Long.parseLong(st.nextToken());

				Integer value = hashMap.get(val);
				
				//해시맵에 군대 번호가 있는지 확인한 후, 있다면 value를 올려주고 넣는다.
				
				if (value == null) {
					hashMap.put(val, 1);
				} else {
					value++;
					
					//max값 갱신
					if (value > max) {
						max = value;
						maxIdx = val;
					}
					hashMap.put(val, value);
				}

			}

			double ratio = ((double)max / armyNum) * 100;
			//System.out.println(ratio);
			if (ratio > 50.0) {
				System.out.println(maxIdx);
			} else {
				System.out.println("SYJKGW");
			}

		}

	}

}
