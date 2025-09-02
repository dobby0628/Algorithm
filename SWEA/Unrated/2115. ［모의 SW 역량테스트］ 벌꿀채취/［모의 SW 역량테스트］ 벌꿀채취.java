/*
 *  벌꿀채취
 *  
 *  # 문제 이해
 *  N * N 개의 벌통이 정사각형 모양으로 배치되어 있다.
 *  
 *  각 칸의 숫자는 벌통에 있는 꿀의 양
 *  
 *  아래 과정으로 벌꿀을 채취하여 최대한 많은 수익을 얻으려고 한다.
 *  1. 두명의 일꾼은 벌통의 수 M이 주어질 때,
 *  가로로 연속되도록 M개의 벌통을 선택하여 채취 가능
 *  단, 두 명의 일꾼이  선택한 벌통은 겹치면 안됨
 *  
 *  2. 하나의 벌통에서 꿀을 채취할 때, 일부분만 채취할 수 없고 벌통에 있는 모든 꿀을 
 *  한번에 채취해야 함
 *  두 일꾼이 채취할 수 있는 꿀의 최대양 C
 *  
 *  ex) c = 10
 *   6 1 -> 둘 다 채취 가능
 *   8 5 -> 10을 넘어가므로 8,5 중 한 곳만 채취 가능
 *   
 *   수익 계산 방법
 *   꿀의 양 제곱 
 *   ex) 6, 1, 8 => 36 + 1 + 64 = 101
 *   
 *   일꾼의 수는 2로 고정
 *   N : 지도의 한 변 길이
 *   M : 벌통의 개수(가로로만 나열 가능)
 *   C : 꿀을 채취할 수 있는 최대 양
 *   
 *  # 문제 풀이
 *  일단 알고리즘 생각이 안나므로 완전탐색으로 풀어보기
 *  ㄴ 각 칸의 꿀통 수익을 계산해서 겹치지 않는 것들 중 최대값 2개를 뽑아보려 하였으나 -> 실패
 *  
 *  2명이 벌꿀을 선택할 때 조합
 *  선택한 벌꿀 중에서 C 이내의 부분조합 중 최대값 구하기
 *  
 *  이해가 안되서 코드 봄
 */

import java.io.*;
import java.util.*;

public class Solution {
	static int n, m, c;
	static int[][] honey;
	static boolean[][] visited;
	static int maxNum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// n : 변의 길이  m : 꿀통 개수  c : 채취가능 꿀 최대값
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			// 꿀 양 입력받기
			honey = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc + " " + combination());
		}
	}
	
	static int combination() {
		int result = 0;
		int max1 = 0;
		int max2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n-m; j++) {
				maxNum = 0;
				getMaxHoney(i, j, 0, 0, 0);
				max1 = maxNum;
				
				maxNum = 0;
				max2 = 0;
				for (int j2 = j + m; j2 <= n-m; j2++) {
					getMaxHoney(i, j2, 0, 0, 0);
					max2 = Math.max(max2,  maxNum);
				}
				
				for (int i2 = i+1; i2 < n; i2++) {
					for (int j2 = 0; j2 <= n-m; j2++) {
						getMaxHoney(i2, j2, 0, 0, 0);
						max2 = Math.max(max2,  maxNum);
					}
				}
				result = Math.max(result, max1+max2);
			} 
		}
		return result;
	}
	
	static void getMaxHoney(int i, int j, int cnt, int sum, int benefit) {
		if (sum > c)
			return;
		if (cnt == m) {
			if (maxNum < benefit)
				maxNum = benefit;
			return;
		}
		
		getMaxHoney(i, j+1, cnt+1, sum + honey[i][j], benefit+honey[i][j]*honey[i][j]);
		getMaxHoney(i, j+1, cnt+1, sum, benefit);
	}
}
