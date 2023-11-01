package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bjo1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {

			int n = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String c= st.nextToken();
				int pos = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				//System.out.println(c + " " + pos + " " + cnt);
				for (int j = 0; j < cnt; j++) {
					list.add(pos++, Integer.parseInt(st.nextToken()));
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++)
				System.out.print(list.get(i) + " ");
			System.out.println();
		}
	}
}
