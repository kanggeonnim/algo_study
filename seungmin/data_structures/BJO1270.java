import java.io.*;
import java.util.*;

public class BJO1270 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Map<Long, Integer> map;
		int n = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < n; i++) {
			map = new HashMap<Long, Integer>();
			st = new StringTokenizer(in.readLine());
			int ti = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < ti; j++) {
				long temp = Long.parseLong(st.nextToken());
				
				map.put(temp, map.containsKey(temp) ? map.get(temp) + 1 : 1);
			}
			
			Map.Entry<Long, Integer> temp = map.entrySet().stream().reduce((x, y) -> x.getValue() > y.getValue() ? x : y).get();			
			System.out.println(temp.getValue() > ti / 2 ? temp.getKey() : "SYJKGW");
		}
	}
}
