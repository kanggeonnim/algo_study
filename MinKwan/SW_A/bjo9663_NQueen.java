import java.util.Scanner;

public class bjo9663_NQueen {

	static int N;
	static int[] queen;
	static boolean[] visit;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queen = new int[N];
		visit = new boolean[N];
		combination(0,0);
		System.out.println(count);
	}

	private static boolean check(int cnt) {

		for (int i = 0; i < cnt; i++) {

			int rowDiff = Math.abs(cnt - i);
			int colDiff = Math.abs(queen[i] - queen[cnt]);

			if (rowDiff == colDiff)
				return false;

		}

		return true;
	}

	// 순열 구하기
	private static void combination(int index,int cnt) {

		if (cnt == N) {
			count++;
			return;
		}
		
		visit[index] = true;
		combination(index+1,cnt+1);
		visit[index] = false;
		combination(index+1,cnt);
		
	}
}
