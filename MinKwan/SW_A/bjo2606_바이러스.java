import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bjo2606_바이러스 {
	
	static int N;
	static int P;
	
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		makeSet();
		for(int i = 0; i <P;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			Union(left, right);
		}
		
		
		int ans = 0;
		for(int i = 2; i<=N;i++) {
			if(Find(1) == Find(i))
				ans++;
		};
		System.out.println(ans);
	
		
		
	}
	
	
	static void makeSet() {
		parent = new int[N+1];
		
		for(int i = 1; i <= N;i++) {
			parent[i] = i;
		}
	}
	
	//대표자 찾기
	static int Find(int x) {
		
		if(x == parent[x])
			return x;
		
		//return parent[x] = Find(parent[x]);
		return Find(parent[x]);
	}
	
	static boolean Union(int a,int b) {
		int leftRoot = Find(a);
		int rightRoot = Find(b);
		
		if(leftRoot == rightRoot)
			return false;
		
		parent[rightRoot] = leftRoot;
		return true;
	}
}
