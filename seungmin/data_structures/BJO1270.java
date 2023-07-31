package data_structures;

import java.io.*;
import java.util.*;

public class BJO1270 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/data_structures/1270.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		Map<Long, Integer> map;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int ti = Integer.parseInt(st.nextToken());
			int sum = 0;
			map = new HashMap<Long, Integer>();
			
			for(int j = 0; j < ti; j++) {
				long temp = Long.parseLong(st.nextToken());
				
				if (map.containsKey(temp)) map.put(temp, map.get(temp) + 1);
				else map.put(temp, 1);
				
				sum++;
			}
			
			Map.Entry<Long, Integer> temp = map.entrySet().stream().reduce((x, y) -> x.getValue() > y.getValue() ? x : y).get();
			
			System.out.println(temp.getValue() > sum / 2 ? temp.getKey() : "SYJKGW");
		}
	}
}
