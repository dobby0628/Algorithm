/*
 * N과M (1)
 * # 문제 이해
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램 작성하기
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 
 * # 문제 풀이
 * 백트래킹 이용하여 수열구하기
 */

import java.util.Scanner;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] result;
	
	static void backtrack(int depth) {
		if (depth == M+1) {
			for (int i = 1; i <= M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = i;
			
				backtrack(depth+1);
			
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N+1];
		result = new int[M+1];
		
		backtrack(1);
	}
}
