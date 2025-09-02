/*
 * 진우의 달 여행 (Large)
 * 
 * # 문제 이해
 * 지구와 우주 사이는 n * m 행렬로 나타낼 수 있으며
 * 각 원소의 값은 우주선이 그 공간을 지날 때 소모되는 연료의 양
 * 
 * 1. 이동방향은 왼쪽 하단, 하단, 오른쪽 하단
 * 2. 전에 움직인 방향으로 움직일 수 없음. 즉, 같은 방향으로 두번 연속 움직일 수 없다.
 * 
 * 목표 : 연료를 최소한으로 하여 지구->달 가는 것
 * 
 * # 문제 풀이
 * dp를 활용하는 것 같긴 한데
 * 같은 방향으로 두번 연속 못가는 것을 구현하는게 좀 빡셀듯
 * dp에 값을 넣을 때 방향을 같이 넣어서 그 방향을 제외하고 넣는 방향으로 구현해보기
 * 
 * gpt + 스터디 진행 후 풀이 방법
 * 3차원 배열을 만들어서 모든 방향의 최소값을 가지고 있기
 * 0 왼쪽위 1 바로 위 2 오른쪽 위
 * 나의 현재 위치의 위칸만 영향을 받기 때문에 2차원 배열의 dp만으로 풀이 가능
 * ㄴ 슬라이딩 윈도우
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[1+n][1+m];
		int[][] dp = new int[m+2][3];
		
		// dp 초기화
		for (int[] t : dp)
			Arrays.fill(t, 1_000_000_000);
		
		for (int ni = 1; ni <= n; ni++) {
			st = new StringTokenizer(br.readLine());
			for (int mi = 1; mi <= m; mi++) {
				map[ni][mi] = Integer.parseInt(st.nextToken());
				// dp 첫째줄 자기 자신으로 초기화하기
				if (ni == 1) {
					dp[mi][0] = dp[mi][1] = dp[mi][2] = map[ni][mi];
				}
			}
		}
		
		// dir 0:\  1:|  2: /
		for (int ni = 2; ni <= n; ni++) {
			// 임시로 쓸 dp 이차원 배열 선언
			int[][] tmp = new int[m+2][3];
			for (int[] t : tmp)
				Arrays.fill(t, 1_000_000_000);
			for (int mi = 1; mi <= m; mi++) {
				// 현재 칸의 원소값
				int value = map[ni][mi];
				for (int i = 0; i < 3; i++) {
					switch(i) {
					case 0:
						tmp[mi][i] = value + Math.min(dp[mi][1], dp[mi+1][2]);
						break;
					case 1:
						tmp[mi][i] = value + Math.min(dp[mi-1][0], dp[mi+1][2]);
						break;
					case 2:
						tmp[mi][i] = value + Math.min(dp[mi-1][0], dp[mi][1]);
						break;
					}
				}
			}
			dp = tmp;
		}
		
		// dp 값들 중 최소값 찾기
		int min = Integer.MAX_VALUE;
		for (int mi = 1; mi <= m; mi++) {
			for (int i = 0; i < 3; i++) {
				min = Math.min(min, dp[mi][i]);
			}
		}
		System.out.println(min);
		br.close();
	}
}
