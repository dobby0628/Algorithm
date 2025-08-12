/*
 * # 문제 이해
 * N개의 수가 주어졌을 때 i ~ j 수까지 합을 구하는 프로그램 작성
 * 
 * # 문제 풀이
 * 구간합 알고리즘 사용
 * 
 * # 시간복잡도 O(N + M)
 * 구간의 합을 미리 구해놓으므로 n개의 배열을 만들때 비용 모두 사용
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] section_sum = new int[1+N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			section_sum[i] = section_sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(section_sum[end] - section_sum[start -1]);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
