/*
 * [이항계수]
 * 
 * # 문제 이해
 * 이항계수는 조합의 다른말
 * N, K가 주어졌을 때 N개의 수 중 K를 뽑는 조합의 개수 구하기
 * 
 * # 문제 풀이
 * 조합을 실행시켜 개수 구하기
 *
 */

import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int k;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		comb(0, 0);
		
		System.out.println(cnt);

		br.close();
	}
	
	static void comb(int depth, int start) {
		if (depth == k) {
			cnt++;
			return ;
		}
		
		for (int i = start; i < n; i++) {
			comb(depth+1, i+1);
		}
	}
}
