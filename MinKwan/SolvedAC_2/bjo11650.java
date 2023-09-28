import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class bjo11650 {
	
	static StringBuilder sb;
	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point() {
		}

		@Override
		public int compareTo(Point o) {
			if (this.y != o.y) {
				return Integer.compare(this.y, o.y);
			} else
				return Integer.compare(this.x, o.x);
		}

	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		PriorityQueue<Point> pq = new PriorityQueue<Point>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point p = new Point();
			p.x = Integer.parseInt(st.nextToken());
			p.y = Integer.parseInt(st.nextToken());
			pq.add(p);
		}

		while (!pq.isEmpty()) {
			Point p = pq.poll();
			sb.append(p.x);
			sb.append(" ");
			sb.append(p.y);
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
}
