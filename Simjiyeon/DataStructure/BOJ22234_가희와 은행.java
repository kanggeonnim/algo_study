package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj22234 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<int[]> queue = new PriorityQueue<>() {
			private int compare(int[] a,int[]b) {
				if(a[2]>b[2]) {
					return -1;
				}else if(a[2]<b[2]) {
					return 1;
				}else return 0;
				
			}
		};
		
		
		int N,T,W,M;
		
		N =Integer.parseInt(st.nextToken());
		T =Integer.parseInt(st.nextToken());
		W =Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {//먼저 생긴 대기 손님
			StringTokenizer tk1 = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(tk1.nextToken());
			int time = Integer.parseInt(tk1.nextToken());
			//배열에 저장
			int[] data= {id,time,0};
			//큐에 추가
			queue.add(data);
			//arraylist 추가 (고객 정보)
		}
		//2번째 줄 입력 처리완료
		StringTokenizer tk2 = new StringTokenizer(br.readLine());
		M =Integer.parseInt(tk2.nextToken());
		for(int i=0;i<M;i++) {
			StringTokenizer tk3 = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(tk3.nextToken());
			int time = Integer.parseInt(tk3.nextToken());
			int arrive = Integer.parseInt(tk3.nextToken());
			//배열에 저장
			int[] data= {id,time,arrive};
			//큐에 추가
			queue.add(data);
			//arraylist 추가 (고객 정보)
		}
		
		
		
	}

}
