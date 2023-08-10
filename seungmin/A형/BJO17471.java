package bjo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BJO17471 {
	static int n;
	static int min = Integer.MAX_VALUE;
	static Node[] arr;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_BJO/BJO17471.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		
		arr  = new Node[n+1];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 1; i < n+1; i++) {
			arr[i] = new Node();
			arr[i].people = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken());
			for(int j = 0; j < m; j++) {
				arr[i].area.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		a.add(1);
		
		
		powerSet(2, a, b);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static class Node {
		int people;
		Set<Integer> area = new HashSet<Integer>();
	}
	
	static void powerSet(int cnt, List<Integer> a, List<Integer> b) {
		if(cnt > n) {
			if (b.size() > 0) {
				int A = check(a);
				int B = check(b);
				if(A > 0 && B > 0) {
					min = Math.min(min, Math.abs(A - B));
				}
				
			}
			
			return;
		}
		
		a.add(cnt);
		powerSet(cnt + 1, a, b);
		a.remove(a.size()-1);
		
		b.add(cnt);
		powerSet(cnt + 1, a, b);
		b.remove(b.size()-1);
	}
	
	
	static int check(List<Integer> a) {
		boolean[] visited = new boolean[n+1];
		int cnt = 0;
		int sum = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(a.get(0));
		visited[a.get(0)] = true;
		cnt += 1;
		sum += arr[a.get(0)].people;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int x: arr[temp].area) {
				if(!visited[x] && a.contains(x)) {
					q.offer(x);
					visited[x] = true;
					cnt += 1;
					sum += arr[x].people;
				}
			}
		}
		
		if(cnt == a.size()) {
			return sum;
		}
		
		return 0;
	}
}
