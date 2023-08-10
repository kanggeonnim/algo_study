package day0810;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class bjo1181_단어정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = sc.next();
		}

		Set<String> hashSet = new HashSet<>();

		for (String i : str)
			hashSet.add(i);

		String[] result = new String[hashSet.size()];
		int index = 0;
		for (String s : hashSet) {

			result[index++] = s;
		}

		for (int i = 0; i < result.length; i++) {
			for (int j = i + 1; j < result.length; j++) {

				if (result[i].length() > result[j].length()) {
					String temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}

				if (result[i].length() == result[j].length()) {
					if (result[i].compareTo(result[j]) > 0) {
						String temp = result[i];
						result[i] = result[j];
						result[j] = temp;
					}
				}
			}
		}

		for (String s : result) {

			System.out.println(s);
		}

	}

}
