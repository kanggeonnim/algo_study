package data_structures;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.PriorityQueue;

public class BJO1927 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/data_structures/BJO1927.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); 
		int n = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt(in.readLine());
			if(temp == 0) sb.append(Optional.ofNullable(heap.poll()).orElse(0)).append("\n");
			else heap.add(temp);
		}
		System.out.print(sb.toString());
	}
}
