package sw_a.bjo16637;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJO16637 {
	static int[] nums;
	static char[] opers;
	static boolean[] visited;
	static int idx = 0;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(BJO16637.class.getResource("input.txt").getPath()));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		nums = new int[(n >> 1) + 1];
		opers = new char[n >> 1];
		idx = opers.length;
		visited = new boolean[n>>1];
		char[] c = in.readLine().toCharArray();
		for(int i = 0; i < n; i++) {
			if((i & 1) == 0) nums[i >> 1] = c[i] - '0'; 
			else opers[i >> 1] = c[i];
		}
		
		power(0);
		
		System.out.println(max);
	}
	
	static int[] result1;
	static char[] result2;
	static boolean[] result3;
	
	static void power(int idx) {
		if (idx == opers.length) {
			result1 = nums.clone();
			result2 = opers.clone();
			result3 = visited.clone();
 			for(int i = 0; i < idx; i++) {
				if(result3[i]) {
					eval(i);
					i -= 1;
					idx -= 1;
				}
			}
 			for(int i = 0; i < idx; i++) {
				eval(i);
				i -= 1;
				idx -= 1;
			}
 			max = Math.max(max, result1[0]);
			return;
		}
		
		power(idx+1);
		
		if (idx == 0 || !visited[idx-1]) {
			visited[idx] = true;
			power(idx+1);
			visited[idx] = false;
		}
	}
	
	static void eval(int i) {
		if(result2[i] == '+') result1[i] = result1[i] + result1[i+1];
		if(result2[i] == '-') result1[i] = result1[i] - result1[i+1];
		if(result2[i] == '*') result1[i] = result1[i] * result1[i+1];
		
		for(int j = i+1; j < idx; j++) {
			result1[j] = result1[j+1];
		}
		
		for(int j = i; j < idx - 1; j++) {
			result2[j] = result2[j+1];
		}
		
		for(int j = i; j < idx - 1; j++) {
			result3[j] = result3[j+1];
		}
	}
}
