/*
 * N-Queen 배치하기
 * # 문제 이해
 * N * N  체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 * N이 주어졌을 때 퀸을 놓는 방법의 수를 구하는 프로그램 만들기
 * 
 * 체스에서 퀸은 가로, 세로, 대각선으로 공격할 수 있다
 * 
 * # 문제 풀이
 * 백트래킹으로 놓을 수 있는 곳과 없는 곳을 판별하면서 퀸의 위치찾기
 * 
 */

import java.util.Scanner;

public class Main {
	static int N;
	static int[] arrN;
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arrN = new int[N];
		
		backtrack(0);
		System.out.println(cnt);
	}
	
	static void backtrack(int row) {
		if (row == N) {
			cnt++;
			return;
		}
		for (int col = 0; col < N; col++) {
			if (!isSafe(row, col)) continue;
			
			arrN[row] = col;
			backtrack(row+1);
			arrN[row] = 0;
		}
	}
	
	static boolean isSafe(int row, int col) {
		for (int prev = 0; prev < row; prev++) {
			if (arrN[prev] == col) return false;
			if (Math.abs(prev - row) == Math.abs(arrN[prev] - col)) return false;
		}
		return true;
	}
}
