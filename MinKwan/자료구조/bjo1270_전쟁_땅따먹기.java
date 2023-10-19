import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	/*
	 * �־����� ������ ��ȣ�� ��û Ŀ�� �迭�� ���ڸ� �÷����� ������� ã�°� �Ұ����ϴ�.
	 * 
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// ������ ��
		int n = Integer.parseInt(br.readLine());

		// Ư�� �ֵ� ���� ��ȣ�� ������ �ʰ��ϸ� �� ���� ���� ��
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// ������ �ֵ� ���� ����
			int armyNum = Integer.parseInt(st.nextToken());

			// �ؽ��� ���� �ؽø�
			Map<Long, Integer> hashMap = new HashMap<Long,Integer>();

			int max = 0;
			long maxIdx = 0;

			for (int j = 0; j < armyNum; j++) {
				long val = Long.parseLong(st.nextToken());

				Integer value = hashMap.get(val);
				
				//�ؽøʿ� ���� ��ȣ�� �ִ��� Ȯ���� ��, �ִٸ� value�� �÷��ְ� �ִ´�.
				
				if (value == null) {
					hashMap.put(val, 1);
				} else {
					value++;
					
					//max�� ����
					if (value > max) {
						max = value;
						maxIdx = val;
					}
					hashMap.put(val, value);
				}

			}

			if (max > armyNum/2) {
				System.out.println(maxIdx);
			} else {
				System.out.println("SYJKGW");
			}

		}

	}

}