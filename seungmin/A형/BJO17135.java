package sw_a.bjo17135;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJO17135 {
	static int[] archer1 = { 5, 1 };// fix
	static int[] archer2 = { 5, 2 };// fix
	static int[] archer3 = { 5, 3 };// fix
	static int[] comb;
	static ArrayList<int[]> enemy = new ArrayList<int[]>();
	static int max = -1;
	static int n;
	static int m;
	static int d;
	static int[][] arr;
	static int[][] tempArr;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(BJO17135.class.getResource("input.txt").getPath()));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		comb = new int[3];
		
		tempArr = new int[n][m];
		arr = new int[n][];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1)
					enemy.add(new int[] { i, j });
				tempArr[i][j] = temp;
			}
		}
		comb(0, 0);
		
		System.out.println(max);
	}
	
	static void cloneArr() {
		for(int i = 0; i <n ;i++) {
			arr[i] = tempArr[i].clone();
		}
	}
	
	static void comb(int start, int cnt) {
		if(cnt == 3) {
			archer1 = new int[]{n, comb[0]};
			archer2 = new int[]{n, comb[1]};
			archer3 = new int[]{n, comb[2]};
			cloneArr();
			game(arr, n, m, d);
			return;
		}
		
		for(int i = start; i < m; i++) {
			comb[cnt] = i;
			comb(i+1, cnt+1);
		}
	}

	static void game(int[][] arr, int n, int m, int d) {
		int deadLine = n - 1;
		int dead = 0;
		PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Com1(archer1));
		PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>(new Com1(archer2));
		PriorityQueue<int[]> pq3 = new PriorityQueue<int[]>(new Com1(archer3));

		for (int i = 0; i < enemy.size(); i++) {
			pq1.add(enemy.get(i).clone());
			pq2.add(enemy.get(i).clone());
			pq3.add(enemy.get(i).clone());
		}
		
		

		while (!pq1.isEmpty() && !pq2.isEmpty() && !pq3.isEmpty() && deadLine >= 0) {
			int x;
			int y;
			while (!pq1.isEmpty()) {
				x = pq1.peek()[0];
				y = pq1.peek()[1];
				
				if(!(arr[x][y] == 1 || arr[x][y] == -d)) {
					pq1.remove();
					continue;
				}
				if (Math.abs(x - archer1[0]) + Math.abs(y - archer1[1]) <= d) {
					pq1.remove();
					if (arr[x][y] == 1) {
						arr[x][y] = -d;
						dead += 1;
					}
				}
				break;
			}
			while (!pq2.isEmpty()) {
				x = pq2.peek()[0];
				y = pq2.peek()[1];
				if(!(arr[x][y] == 1 || arr[x][y] == -d)) {
					pq2.remove();
					continue;
				}
				if (Math.abs(x - archer2[0]) + Math.abs(y - archer2[1]) <= d) {
					pq2.remove();
					if (arr[x][y] == 1) {
						arr[x][y] = -d;
						dead += 1;
					}
				}
				break;
			}
			while (!pq3.isEmpty()) {
				x = pq3.peek()[0];
				y = pq3.peek()[1];
				if(!(arr[x][y] == 1 || arr[x][y] == -d)) {
					pq3.remove();
					continue;
				}
				if (Math.abs(x - archer3[0]) + Math.abs(y - archer3[1]) <= d) {
					pq3.remove();
					if (arr[x][y] == 1) {
						arr[x][y] = -d;
						dead += 1;
					}
				}
				break;
			}
			
			for(int i = 0 ; i < m; i++) {
				arr[deadLine][i] = 0;
			}
			deadLine -= 1;
			d += 1;
		}
		max = Math.max(max, dead);
	}

	static class Com1 implements Comparator<int[]> {
		int x;
		int y;

		Com1(int[] archer) {
			this.x = archer[0];
			this.y = archer[1];
		}

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			int x1 = Math.abs(x - o1[0]);
			int x2 = Math.abs(x - o2[0]);
			int y1 = Math.abs(y - o1[1]);
			int y2 = Math.abs(y - o2[1]);

			if (x1 + y1 != x2 + y2) {
				return (x1 + y1) - (x2 + y2);
			} else {
				return o1[1] - o2[1];
			}

		}

	}
}
