import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class bjo1752_최단경로 {

	static int V;
	static int E;
	static int[] dis;
	static boolean[] visit;

	static class Node {
		int from;
		int to;
		int cost;

		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		Node[] nodes = new Node[E];
		dis = new int[V + 1];
		visit = new boolean[V + 1];

		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			nodes[i] = new Node(from, to, cost);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(start);

		while (!pq.isEmpty()) {
			int nowVertex = pq.poll();
			visit[nowVertex] = true;

			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i].from == nowVertex) {
					Node node = nodes[i];
					int from = node.from;
					int to = node.to;
					int cost = node.cost;

					dis[to] = Math.min(dis[to], dis[from] + cost);
					//System.out.println(Arrays.toString(dis));
					if (!visit[to])
						pq.add(to);
				}

			}
		}

		for (int i = 1; i <= V; i++) {
			if (dis[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dis[i]);
		}
	}

}
