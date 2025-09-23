/*
 * [이항계수2]
 * 
 * # 문제 이해
 * 이항계수는 조합의 다른말
 * N, K가 주어졌을 때 N개의 수 중 K를 뽑는 조합의 개수 구하여 10007로 나눈 나머지 구하기
 * 
 * # 문제 풀이
 * 조합을 실행시켜 개수 구하기 -> 시간초과
 * 파스칼의 삼각형 공식으로 dp 식 구해서 조합의 개수 찾아내기
 * -> 틀림 : 수가 너무 커서 long도 벗어나버림
 * 		ㄴ 점화식을 구할 때마다 10007로 나눈 나머지를 dp에 저장해야 함
 */

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[n+1][n+1];
		
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}
		
		System.out.println(dp[n][k]);

		br.close();
	}
}
