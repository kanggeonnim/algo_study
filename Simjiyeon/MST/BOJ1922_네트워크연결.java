package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1922_네트워크연결 {
	static int N, M;
//	static ArrayList<ArrayList<Edge>> edge;
	static ArrayList<Edge> edge;
	static int[] parents;
	static int mincost = 0;

	static void Make() {
		parents = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean Union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);

		if (rootb == roota)
			return false;

		parents[rootb] = roota;
		return true;
	}

	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}// class-Edge

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		// 간선 정보 저장
		edge = new ArrayList<>();

		Make();// union parents 생성

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edge.add(new Edge(from, to, cost));
		} // input end
		Collections.sort(edge);
		// edge의 가장 cost가 작은 것 부터
		bfs(edge.get(0));
		System.out.println(mincost);

	}// main

	private static void bfs(Edge e) {
		Queue<Edge> q = new ArrayDeque<Edge>();
		for (int i = 0; i < edge.size(); i++) {
			// cost가 적은 순서대로 q에 넣고 순서대로 체크
			q.add(edge.get(i));
		}
		q.add(edge.get(0));
		// 비용이 가장 작은 간선 추가
		while (!q.isEmpty()) {
			Edge ed = q.peek();
			if (Union(ed.a, ed.b)) { // 만약 union이 된다면 서로 집합이 아니었던 관계는 코스트를 등록하고 빼내고
//				System.out.println("오, " + ed.a + " - " + ed.b + " 연결 완료");
				mincost += ed.cost;
				q.poll();
			} else { // 아니면 그냥 빼내기
//				System.out.println("오, " + ed.a + " -x- " + ed.b + " 연결 실패");
				q.poll();
			}
		}

	}
}
