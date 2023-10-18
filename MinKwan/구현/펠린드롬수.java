import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String str = sc.next();
			boolean ans = true;
			if (str.equals("0"))
				break;

			int left = 0;
			int right = str.length() - 1;
			while (true) {
				
				if (str.charAt(left) == str.charAt(right)) {
					left++;
					right--;
				} else {
					ans = false;
					break;
				}
				if (left == right || left > right )
					break;

			}

			if (ans == true)
				System.out.println("yes");
			else
				System.out.println("no");

		} // 0 나오면 입력 종료
	}
}
