import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bjo1752_최단경로 {

	static int V;
	static int E;
	static int[] dis;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		ArrayList<Edge>[] edges = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++)
			edges[i] = new ArrayList<>();
		dis = new int[V + 1];
		visit = new boolean[V + 1];

		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges[from].add(new Edge(to, cost));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int to = now.to;

			if (visit[to])
				continue;

			visit[to] = true;

			for (Edge next : edges[to]) {
				if (dis[next.to] > now.cost + next.cost) {
					dis[next.to] = now.cost + next.cost;
					pq.add(new Edge(next.to, now.cost + next.cost));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dis[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(dis[i]).append("\n");
		}

		System.out.println(sb);
	}

}
