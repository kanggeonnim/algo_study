package bjo.bjo1976;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJO1976 {
	static int[] nodes;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(BJO1976.class.getResource("input.txt").getPath()));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		initNodes(n);
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				if(st.nextToken().equals("1")) mergeSet(i, j);
			}
		}
		
		st = new StringTokenizer(in.readLine());
		
		int std = findRoot(Integer.parseInt(st.nextToken()) - 1);
		boolean result = true;
		
		for(int i = 0; i < m-1; i++) {
			if(std == findRoot(Integer.parseInt(st.nextToken()) - 1)) continue;
			result = false;
			break;
		}
		
		System.out.println(result ? "YES" : "NO");
		
	}
	
	static void initNodes(int n) {
		nodes = new int[n];
		for(int i = 0; i < n; i++) {
			nodes[i] = i;
		}
	}
	
	static int findRoot(int x) {
		if(x == nodes[x]) return x;
		return x = findRoot(nodes[x]);
	}
	
	static boolean mergeSet(int a, int b) {
		int tempA = findRoot(a);
		int tempB = findRoot(b);
		
		if(tempA == tempB) return false;
		
		if(tempA > tempB) nodes[tempA] = tempB;
		else nodes[tempB] = tempA;
		
		return true;
	}
}