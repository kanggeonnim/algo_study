package data_structures;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJO22234 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/data_structures/BJO22234.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<int[]> q1 = new LinkedList<>();
		PriorityQueue<int[]> q2 = new PriorityQueue<>((x, y) -> x[2] - y[2]);
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			q1.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		int m = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			q2.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		for(int i = 0; i < w && !q1.isEmpty();) {
			int[] temp = q1.poll();
			int px = temp[0];
			int tx = temp[1];
			
			for(int j = 0; j < Math.min(t, tx) && i < w; j++, i++) {
				sb.append(px + "\n");
			}
			
			tx -= t;
			
			while(!q2.isEmpty() && q2.peek()[2] <= i) {
				temp = q2.poll();
				q1.add(new int[] {temp[0], temp[1]});
			}
			
			if (tx > 0)	q1.add(new int[] {px, tx});
			
		}
		
		System.out.println(sb.toString());
	}
}
