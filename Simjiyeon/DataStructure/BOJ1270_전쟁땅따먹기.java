package day0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class boj1270 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());
		
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int Ti=Integer.parseInt(st.nextToken());
			//hashmap 생성
			HashMap<Integer, Integer> hmap = new HashMap<>();
			for(int i=0;i<Ti;i++) {
				int num = Integer.parseInt(st.nextToken());
				for(int j=0;j<num;j++) {
					if(hmap.get(num) == null) {
						hmap.put(num, 1);
					}else{
						hmap.put(num, hmap.get(num)+1);
					}
				}
				
				Set<Integer> keySet = hmap.keySet();
				boolean res = false;
				for(Integer key : keySet) {
					if(hmap.get(key)>num/2) {
						System.out.println(key+"번호의 군대가 점령중"+hmap.get(key));
						res =true;
						break;
					}
				}
				if(res=false) {
					System.out.println("SYJKGW");
				}
				
				
				
			}
			
			
			
		}//n
		
	}

}
