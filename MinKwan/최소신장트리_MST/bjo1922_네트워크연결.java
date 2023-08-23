package algo_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bjo1922_네트워크연결 {

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		@Override
		public int compareTo(Edge o) {

			// 음수면 오름차순??
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return this.from + " " + this.to + " " + this.weight;
		}
	}

	static int[] parents;
	static int N;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		PriorityQueue<Edge> edgePQ = new PriorityQueue<>();
		parents = new int[N + 1];

		makeSet();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Edge edge = new Edge();
			edge.from = Integer.parseInt(st.nextToken());
			edge.to = Integer.parseInt(st.nextToken());
			edge.weight = Integer.parseInt(st.nextToken());
			edgePQ.add(edge);
		}

		// 입력 종료

		int ans = 0;
		int cnt = 0;
		while (!edgePQ.isEmpty()) {
			Edge edge = edgePQ.poll();
			
			if (Union(edge.from, edge.to)) {
				//System.out.println(edge + " " + " 간선 결정 ");
				Union(edge.from, edge.to);
				ans += edge.weight;
				cnt++;
			} else {
		//		System.out.println(edge + " " + " 충돌 발생 ");
			}
			
			if(cnt == N-1)
				break;

		}
		
		System.out.println(ans);
	}

	static void makeSet() {
		parents = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int Find(int x) {
		if (x == parents[x])
			return x;

		return parents[x] = Find(parents[x]);

	}

	static boolean Union(int a, int b) {
		int leftRoot = Find(a);
		int rightRoot = Find(b);

		if (leftRoot == rightRoot)
			return false;

		parents[rightRoot] = leftRoot; //대표자끼리 교환!!
		return true;
	}

}
