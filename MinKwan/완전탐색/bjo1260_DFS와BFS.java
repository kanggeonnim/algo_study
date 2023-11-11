package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bjo1260_DFS와BFS {
	static int N; // 정점
	static int M; // 간선
	static int V; // 시작 정점
	static int[][] adj; // 인접 행렬
	static boolean[] visit;
	static ArrayList<Integer> ansBFS;
	static ArrayList<Integer> ansDFS;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adj = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		ansBFS = new ArrayList<>();
		ansDFS = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adj[from][to] = 1;
			adj[to][from] = 1;
		}

		// visit[V] = true;
		DFS(V);
		for (int i = 0; i < ansDFS.size(); i++)
			System.out.print(ansDFS.get(i) + " ");
		System.out.println();
		BFS();
		for (int i = 0; i < ansBFS.size(); i++)
			System.out.print(ansBFS.get(i) + " ");
	}

	static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		visit = new boolean[N + 1];
		q.add(V);
		visit[V] = true;
		ansBFS.add(V);

		while (!q.isEmpty()) {
			int v = q.poll();

			for (int i = 1; i <= N; i++) {
				if (adj[v][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
					ansBFS.add(i);
				}
			}
		}
	}

	static void DFS(int v) {
		ansDFS.add(v);
		visit[v] = true;

		for (int i = 1; i <= N; i++) {
			if (adj[v][i] == 1 && !visit[i]) {
				DFS(i);
			}
		}
	}
}
