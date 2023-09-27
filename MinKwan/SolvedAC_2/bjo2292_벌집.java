import java.util.Scanner;

public class bjo2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int value = 1;
		int ans = 1;
		int sumValue = 6;
		
		while(n > value) {
			value += sumValue;
			sumValue += 6;
			ans++;
		}
		System.out.println(ans);
	}
}
