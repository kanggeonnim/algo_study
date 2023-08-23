package bjo.bjo1922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJO1922 {
	static List<Edge>[] edges;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(BJO1922.class.getResource("input.txt").getPath()));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		edges = new ArrayList[n+1];
		
		for(int i = 1; i < n+1; i++) {
			edges[i] = new ArrayList();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[a].add(new Edge(b, c));
			edges[b].add(new Edge(a, c));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue();
		
		boolean[] visited = new boolean[n+1]; 
		pq.add(new Edge(1, 0));
		int sum = 0;
		int cnt = 0;
		while(!pq.isEmpty() && cnt < n) {
			Edge current = pq.remove();
			if(visited[current.to]) continue;
			cnt += 1;
			sum += current.weight;
			visited[current.to] = true;
			
			for(int i = 0; i < edges[current.to].size(); i++) {
				if(!visited[edges[current.to].get(i).to]) pq.add(edges[current.to].get(i));
			}
		}
		
		System.out.println(sum);
		
	}
	
	static class Edge implements Comparable<Edge>{
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
}
