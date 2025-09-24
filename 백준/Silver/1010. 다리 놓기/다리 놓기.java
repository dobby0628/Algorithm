/*
 * [다리 놓기]
 * 
 * # 문제 이해
 * 서쪽에 n개의 사이트, 동쪽에 m개의 사이트
 * 
 * 서쪽에서 동쪽으로 다리를 연결하려고 함
 * (이때, 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.)
 * 
 * 재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 n개만큼 다리를 지으려고 한다.
 * 다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라 
 * 
 * # 문제 풀이
 * n <= m 
 * mCn 문제 조합으로 풀이
 * 단, 시간이 0.5이므로 dp식을 세워서 풀기
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[m+1][m+1];
			
			for (int i = 1; i <= m; i++) {
				dp[i][0] = 1;
				dp[i][i] = 1;
			}
			
			for (int i = 2; i <= m; i++) {
				for (int j = 1; j <= i; j++) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
			
			sb.append(dp[m][n]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}