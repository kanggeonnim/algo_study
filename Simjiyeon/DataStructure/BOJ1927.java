package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1927 {
	public static ArrayList<Long> heap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		heap = new ArrayList<Long>();
		heap.add((long) 0);//이 노드는 사용하지 않는다.
		for(int i = 0; i<n;i++) {

			StringTokenizer tk = new StringTokenizer(br.readLine());
			long x=Integer.parseInt(tk.nextToken());
			if(x==0) {
				System.out.println(delete());
			}else {
				insert(x);
			}
		}
	}//main
	
	
	public static void insert(long val) {
		heap.add(val);
		int p = heap.size()-1;
		while(p>1&&heap.get(p/2)>heap.get(p)) {
			//새로 삽입한 노드의 위치가 1 초과 &&
			//부모가 자식보다 크면 진행 ->
			//새로 삽입한 노드의 위치가 루트까지 가거나 새로 삽입한 노드가 부모보다 클때까지 진행
			Long tmp = heap.get(p/2);//부모 노드의 값
			heap.set(p/2, val);
			heap.set(p, tmp);
			
			p/=2;
		}
	}
	
	public static long delete() {
		if(heap.size()==0) {
			return 0;
		}
		//삭제할 노드, 루트노드
		Long delt = heap.get(1);
		
		//마지막 노드를 root에 삽입하고 마지막 노드 삭제
		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int pos = 1;
		
		//pos*2 는 왼쪽자식의 인덱스 값, 자식의 인덱스 값이 힙의 사이즈 값보다 크다는 것은 
		//더이상 삽입할 위치를 벗어낫다는 것임
		while((pos*2)<heap.size()) {
			long min = heap.get(pos*2);//왼쪽 자식의 값
			long minPos = pos*2; //왼쪽 자식의 인덱스 값
			
			//오른쪽 자식의 인덱스가 사이즈보다 작고
			//왼쪽보다 더 작을 때 오른쪽 자식을 부모와 바꿔줄 자식으로 지정
			if(((pos*2+1)<heap.size()) && min>heap.get(pos*2+1)) {
				min = heap.get(pos*2+1);
				minPos = pos*2+1;
			}
			
			//부모가 더 작으면 stop
			if(min>heap.get(pos)) {
				break;
			}
			
			//부모 자식 교환
			long tmp = heap.get(pos);
			heap.set(pos, heap.get((int) minPos));
			heap.set((int) minPos, tmp);
			pos = (int) minPos;
			
			
		}
		return delt;
	}



}
