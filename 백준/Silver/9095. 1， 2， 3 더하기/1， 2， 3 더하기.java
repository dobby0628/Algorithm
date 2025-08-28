/*
 * 1,2,3 더하기
 * # 문제 이해
 * 정수 n이 주어졌을 대 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램 작성하기
 * 
 * # 문제 풀이
 * dp 이용
 * 1,2,3의 값에 각각 3, 2, 1을 더하면 4가 된다는 점을 이용하여 점화식 세울 수 있음
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(sc.nextLine());
			
			int[] dp = new int[4+n];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int j = 4; j <= n; j++) {
				dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
			}
			
			System.out.println(dp[n]);
		}
	}
}
