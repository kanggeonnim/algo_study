package day0810;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471_게리 {
	static int N;
	static node[] nodes; // 지역 번호와 인구수를 담은 객체 배열
	static ArrayList<ArrayList<Integer>> list; // 연결 리스트
	static int ans = Integer.MAX_VALUE;

	public static class node {
		int nodeNum;
		int peopleNum;

		public node(int nodeNum, int peopleNum) {
			this.nodeNum = nodeNum;
			this.peopleNum = peopleNum;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 구역 개수

		st = new StringTokenizer(br.readLine());
		nodes = new node[N + 1];
		for (int i = 1; i <= N; i++) {// 구역번호 당 인구 수
			int man = Integer.parseInt(st.nextToken());
			nodes[i] = new node(i, man);
		}
		list = new ArrayList<>();// 연결구역 저장할 리스트 생성
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) { // 리스트 받기
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				list.get(i).add(temp);
			}
		}
		// 입력 끝

		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 1; i <= N / 2; i++) { // N/2이상으로 서치하면 어차피 반절 구한 조합의 반대상황이 되기 때문에 같은 상황이 중복된다.
			boolean[] visited = new boolean[N];
			comb(1, i, A); // 조합을 통한 지역 분리
		}

		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();

	}// main

	static void comb(int start, int r, ArrayList<Integer> arr) {
		if (r == 0) {
//			System.out.println(arr.toString());
//			System.out.println(arr);
			Calcmin(arr);
			return;
		}
		for (int i = start; i <= N; i++) {
			arr.add(i);
			comb(i + 1, r - 1, arr);
			arr.remove(arr.size() - 1);

		}

	}// comb

	static void Calcmin(ArrayList<Integer> arr) {

		if (!isConnected(nodes[arr.get(0)].nodeNum, arr, arr.size())) {
			return;
		}
		ArrayList<Integer> b = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (arr.contains(i)) {
				continue;
			}
			b.add(i);
		}
//		System.out.println("b의 구역: " + b);

		if (!isConnected(nodes[b.get(0)].nodeNum, b, b.size())) {
			return;
		}

		int resultA = 0;
		// a지역 인구수 계산
		for (int i = 0; i < arr.size(); i++) {
			resultA += nodes[arr.get(i)].peopleNum;
		}
//		System.out.println("resultA: " + resultA);

		int resultB = 0;
		// b지역 인구수 계산
		for (int i = 0; i < b.size(); i++) {
//			System.out.println(i + "번째 노드의 인구: " + nodes[b.get(i)].peopleNum);
			resultB += nodes[b.get(i)].peopleNum;
		}

//		System.out.println("resultB: " + resultB);
		int result = Math.abs(resultB - resultA);
		ans = Math.min(ans, result);

	}// Calcmin

	static boolean isConnected(int nodenum, ArrayList<Integer> arr, int size) {
		boolean[] visited = new boolean[N + 1];
		visited[nodenum] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(nodenum);

		int count = 1;
		while (!q.isEmpty()) {
			int start = q.poll();

			for (int i : list.get(start)) {
				// 방문하지 않았고 arr에 속해야함
				if (!visited[i] && arr.contains(i)) {
					visited[i] = true;
					count++;
					q.offer(i);
				}
			}
		}
		if (count == size) {
			return true;
		}

		return false;

	}

}
