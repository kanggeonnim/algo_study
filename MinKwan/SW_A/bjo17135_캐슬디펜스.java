package algo_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import algo.priorityQueue;

public class bjo17135_캐슬디펜스 {

	static int N;
	static int M;
	static int[][] arr;
	static Archer[] arches;

	// 격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Stack<Enemy>[] stack = new Stack[M];
		arches = new Archer[3];

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			stack[i] = new Stack<Enemy>();
			for (int j = 0; j < N; j++) {
				Enemy enemy = new Enemy();
				enemy.x = j;
				enemy.y = i;
				stack[i].add(enemy);
			}
		}

		// 입력 끝

		// 조합으로 궁수 배치 순서를 구한 뒤에 최대 값 구하기
		// 궁수 클래스, 적 클래스 만들기
		
		combination(0, 0);
	}

	static class Enemy {
		int x;
		int y;
	}

	static class Archer {
		int x = 6;
		int y;
	}

	//궁수 순서 뽑아내는 조합
	static void combination(int start, int cnt) {
		if (cnt == 3) {
			
			for(int i = 0; i<3;i++) {
				System.out.print(arches[i].y + " ");
			}
			System.out.println();
			
			
			// 최대값 구하기
			
			
			return;
		}

		for (int i = start; i < M; i++) {
			Archer archer = new Archer();
			archer.y = i;
			arches[cnt] = archer;
			combination(i + 1, cnt + 1);
		}

	}

}
