/*
 * 이진수 표현
 * 
 * # 문제 이해
 * 정수 n,m이 주어질때, m의 이진수 표현의 마지막 n 비트가 모두 1로 켜져 있는지 아닌지를 판별하여 출력하기
 * 
 * 
 */

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append("#").append(tc).append(" ");
			if (m == 0) {
				sb.append("OFF\n");
			}
			else {
				boolean result = true;
				for (int i = n-1; i >=0; i--) {
					int bit = (m & (1 << i)) != 0? 1:0;
					if (bit == 0) {
						result = false;
						break;
					}
				}
				
				if (result)
					sb.append("ON\n");
				else
					sb.append("OFF\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
