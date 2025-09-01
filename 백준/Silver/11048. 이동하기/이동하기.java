/*
 * 이동하기
 * # 문제 이해
 * n*m 미로에 갇혀있다
 * 각 방에 사탕이 놓여있고
 * 1,1 -> n,m으로 이동하려고 한다
 * r,c -> r+1, c / r, c+1 / r+1, c+1 로 이동 가능
 * 각 방을 방문할 때마다 방에 놓여져있는 사탕 가져갈 수 있다
 * 미로 밖으로 나갈 수는 없다
 * 가져올 수 있는 최대 사탕 개수 구하기!!
 * 
 * # 문제 풀이
 * dfs로 갈 수 있는 이동 경로 모두 가기!!
 * 가면서 목적지 도착 시 최대값 비교하여 최대 사탕의 개수 갱신하기
 * -> 시간초과
 * dfs로 풀이 시 경우의 수가 지수적으로 늘어 시간초과 발생
 * 
 * 이동이 오른쪽/아래/대각아래 로만 진행되어 되돌아가지 않는 dag 구조라서 dp가 정석이다!!
 */

import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[][] dp;
	static int n, m;
	static int candyMax = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// map 크기 입력받기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// map, dp 초기화
		map = new int[n+1][m+1];
		dp = new int[n+1][m+1];

		// map 정보 입력받기
		for (int ni = 1; ni <= n; ni++) {
			st = new StringTokenizer(br.readLine());
			for (int mi = 1; mi <= m; mi++) {
				map[ni][mi] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int ni = 1; ni <= n; ni++) {
			for (int mi = 1; mi <= m; mi++) {
				dp[ni][mi] = Math.max(dp[ni-1][mi], Math.max(dp[ni][mi-1], dp[ni-1][mi-1])) + map[ni][mi];
			}
		}
		System.out.println(dp[n][m]);
	}
}
