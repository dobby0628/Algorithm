/*
 * 1로 만들기
 * # 문제 이해
 * 정수 x에 사용할 수 있는 연산은 다음과 같이 세가지이다
 * 	1) x가 3으로 나누어 떨어지면, 3으로 나눈다
 *  2) x가 2로 나누어 떨어지면, 2로 나눈다.
 *  3) 1을 뺀다
 *  
 *  정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
 *  연산을 사용하는 횟수의 최소값을 출력하시오
 *  
 *  # 문제 풀이
 *  dp
 *  점화식 세우는 방법을 몰라서 풀이 봄
 *  
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i -1] + 1;
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i /2] +1);
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i /3] +1);
		}
		System.out.println(dp[n]);
	}
}
