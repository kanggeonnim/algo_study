package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJO2981 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/math/2981.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int GCD = arr[1] - arr[0];
		for (int i = 2; i < n; i++) {
			GCD = gcd(GCD, arr[i] - arr[i-1]);
		}
		
		for(int i = 2; i <= GCD/2; i++) {
			if(GCD%i==0) System.out.print(i+" ");
		}
		System.out.print(GCD + " ");
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}
}
