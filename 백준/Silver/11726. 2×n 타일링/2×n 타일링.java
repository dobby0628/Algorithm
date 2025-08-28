/*
 * 2xn 타일링
 * # 문제 이해
 * 2xn 크기의 직사각형을 1x2, 2x1 형태의 타일로 채우는 방법의 수를 구하는 프로그램 작성하기
 * 
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[3+n];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] = dp[i] % 10007;
		}
		System.out.println(dp[n]);
	}
}
