package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea2832_미생물격리 {

	static int K; // Micro Size
	static int N; // Map Size
	static int M; // Micro Move Size	
	static int[][] map; //맵 
	static ArrayList<Micro> list;

	static class Micro {
		int x;
		int y;
		int power;
		int dir;

		public Micro(int x, int y, int power, int dir) {
			this.x = x;
			this.y = y;
			this.power = power;
			this.dir = dir;
		}

		public void UpdateMicro(int x, int y, int power, int dir) {
			this.x = x;
			this.y = y;
			this.power = power;
			this.dir = dir;
		}
		
		public void UpdateMicro(int power, int dir) {
			this.power = power;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) { //TestCase
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken()); 
			K = Integer.parseInt(st.nextToken()); 
			
			list = new ArrayList<>();
			map = new int[N][N];

			// Spray Medicine
			for (int i = 0; i < N; i++) {
				map[0][i] = 2;
				map[N - 1][i] = 2;
				map[i][0] = 2;
				map[i][N - 1] = 2;
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				list.add(new Micro(x, y, power, dir));
			}

			//Input End

			for (int m = 0; m < M; m++) { // Move Micro

				for (int j = 0; j < K; j++) { // Move Micro Index
					Micro micro = list.get(j);
					int x = micro.x;
					int y = micro.y;
					int dir = micro.dir;
					int power = micro.power;

					switch (dir) {
					case 1: {	// Up
						x -= 1;	
						if (map[x][y] == 2) {
							power /= 2;
							dir = 2;
							list.get(j).UpdateMicro(power, dir);
						}
						list.get(j).x = x;
						break;
					}
					case 2: {	
						x += 1;	//Down
						if (map[x][y] == 2) {
							power /= 2;
							dir = 1;
							list.get(j).UpdateMicro(power, dir);
						}
						list.get(j).x = x;
						break;
					}
					case 3: {
						y -= 1;	//Left
						if (map[x][y] == 2) {
							power /= 2;
							dir = 4;
							list.get(j).UpdateMicro(power, dir);
						}
						list.get(j).y = y;
						break;
						
					}
					case 4: {
						y += 1;	//Right
						if (map[x][y] == 2) {
							power /= 2;
							dir = 3;
							list.get(j).UpdateMicro( power, dir);
						}
						list.get(j).y = y;
						break;
					}
					}
				} 

				// Kill Micro
				for (int i = K - 1; i >= 0; i--) {
					if (list.get(i).power == 0) {
						list.remove(i);
						K--;
					}
				} 
			
				// Union Micro
				for (int i = 0; i < K; i++) {
					Micro m1 = list.get(i);
					if (m1.power == -1)
						continue;
					int max = m1.power;
					int maxIndex = i;
					int sum = m1.power;

					for (int j = i + 1; j < K; j++) {
						Micro m2 = list.get(j);

						if (m2.power == -1)
							continue;
						
						if (list.get(maxIndex).x == m2.x && list.get(maxIndex).y == m2.y) {
							sum += m2.power;
							if (max > m2.power) {
								list.get(j).power = -1;
							} else {
								list.get(maxIndex).power = -1;
								max = m2.power;
								maxIndex = j;
							}
						}
					}

					list.get(maxIndex).power = sum;
					//System.out.println(i +  " maxIndex: " +  maxIndex + " sum: " + sum);

				} // Union Micro

				// Kill Micro
				for (int i = K - 1; i >= 0; i--) {
					if (list.get(i).power == -1) {
						list.remove(i);
						K--;
					}
				}
			} //Move Micro
			

			int ans = 0;
			for (int i = 0; i < K; i++) {
				ans += list.get(i).power;
			}

			System.out.println("#" + t + " " + ans);

		} // TestCase For

	}

}