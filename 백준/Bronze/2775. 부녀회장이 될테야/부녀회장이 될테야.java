/*
 * [부녀회장이 될테야]
 * 
 * # 문제 이해
 * a층의 b호에 살려면 자신의 아래 (a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야한다
 * 
 * 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때,
 * 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
 * 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
 * 
 * # 문제 풀이
 * 누적합 사용
 * 0층을 기본값으로 세팅한 후
 * k층까지 반복문으로 dp 세팅
 *
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] dp = new int[k+1][n+1];
			
			// 0층 초기화
			for (int i = 1; i <= n; i++)
				dp[0][i] = i;
			
			// 점화식 실행
			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
			
			System.out.println(dp[k][n]);
		}
		
		br.close();
	}
}
