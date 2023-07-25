package CodingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 사전순, 스택, 초과 숫자
 * 
 */

public class b6603 {

	// 출력 함수
	static void PrintAry(int[] ary) {
		for (int a : ary) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	// 초과 List에서 최솟값 찾기
	static int GetMin(List<Integer> aryList) {
		int min = aryList.get(0);
		int minIdx = 0;
		for (int j = 0; j < aryList.size(); j++) {
			if (aryList.get(j) < min) {
				min = aryList.get(j);
				minIdx = j;
			}
		}
		aryList.remove(minIdx);
		return min;

	}
	
	static void InsertArrayList(List<Integer> aryList, List<Integer> tempList) {
		for (int i : tempList) {
			aryList.add(i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
	
		int crossNum = n - 6;

		int[] ary = new int[6];
		//초과 숫자를 담는 리스트
		List<Integer> store = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (i <= 5) {
				ary[i] = sc.nextInt();
			} else {
				store.add(sc.nextInt());
			}

		}

		int idx = 5;
		int ChangeN = store.size();

		for (int i = 6; i >= 0; i--) {

			List<Integer> tempStore = new ArrayList<>();
			
			for (int j = 0; j < crossNum; j++) {

				PrintAry(ary);


				// 초과 배열에서 최소값 찾기. 사전식 배열이기 때문에
				int min = GetMin(store);

				if (idx >= 0) {
					tempStore.add(ary[idx]);
					ary[idx] = min;
				}
				// System.out.println(store.size());
			}
			
			InsertArrayList(store, tempStore);
			//원소 삽입 순서를 바꾸기 위해 인덱스 값 --
			idx--;

		}

	}

}
