package implementation;

import java.util.Scanner;

public class BJO1236 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt_rows = 0;
		int cnt_columns = 0;

		char[][] arr = new char[n][];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			boolean check_police = false;

			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 'X') {
					check_police = true;
				}
			}
			
			if (!check_police) {
				cnt_rows += 1;
			}
		}
		
		for (int j = 0; j < m; j++) {
			boolean check_police = false;

			for (int i = 0; i < n; i++) {
				if (arr[i][j] == 'X') {
					check_police = true;
				}
			}
			
			if (!check_police) {
				cnt_columns += 1;
			}
		}
		
		System.out.println(Math.max(cnt_rows, cnt_columns));
		


	}
}
