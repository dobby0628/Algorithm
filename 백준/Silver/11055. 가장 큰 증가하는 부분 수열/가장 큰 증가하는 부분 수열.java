/*
 * 가장 큰 증가하는 부분 수열
 * # 문제 이해
 * 수열 a가 주어졌을 때, 그 수열의 증가하는 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램
 * 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 
 * 합이 가장 큰 증가하는 부분 수열은 A = {(1), 100, (2), (50), (60), 3, 5, 6, 7, 8}
 * 합은 113
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			dp[i] = a[i];
			// 그 전까지 값들 중에서
			for (int j = 0; j < i; j++) {
				// 현재 값보다 해당 값이 작다면
				// 해당 값의 최대값과 현재 값을 더했을 때와 비교하여 최대값 저장
				if (a[j] < a[i])
					dp[i] = Math.max(dp[i], dp[j] + a[i]); 
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}
}
