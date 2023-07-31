package data_structures;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.StringTokenizer;

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
			
			Optional<Entry<Long, Integer>> temp = map.entrySet().stream().reduce((x, y) -> {
				if (x.getValue() > y.getValue()) return x;
				else return y;
			});
			
			if (temp.get().getValue() > sum / 2) System.out.println(temp.get().getKey());
			else System.out.println("SYJKGW");
			
			
		}
		
		
		
	}
}
