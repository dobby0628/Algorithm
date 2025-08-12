/*
 * # 문제 이해
 * n*n 크기의 표에 값이 들어있을 때
 * (x1, y1) ~ (x2, y2) 까지의 합을 구하는 프로그램 작성
 * x 행 y열 의미함
 * 
 * # 문제 풀이
 * 2차원 배열의 구간합을 생성함
 * 
 * x의 구간에서 y의 합들을 구하면 됨
 * 
 * # 시간복잡도
 * 구간합을 구하는 이중 포문에서 사용 O(N * N) 1024 * 1024 = 10^6
 * m 줄 O(M) = 100000 상수 취급
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] sum = new int[n+1][n+1];
		
		for (int x = 1; x <= n; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 1; y <= n; y++) {
				sum[x][y] = sum[x][y-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = 0;
			for (int x = x1; x <= x2; x++) {
				result += sum[x][y2] - sum[x][y1 -1];
			}
			sb.append(result);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
