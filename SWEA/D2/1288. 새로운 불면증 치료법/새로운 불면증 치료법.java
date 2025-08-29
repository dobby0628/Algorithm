/*
 * 새로운 불면증 치료법
 * # 문제 이해
 * n의 배수 번호인 양을 세기로 하였다
 * n = 2
 * 2 4 6 8 .... 2k
 * 
 * 이전에 셌던 번호들의 각 자리수에서 0~9까지의 모든 숫자를 보는 것은 최소 몇 번 양을 센 시점일까?
 * 
 * # 문제 풀이
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
			long n = Long.parseLong(br.readLine());
			long k = 1;
			
			HashMap<Integer, Integer> nMap = new HashMap<>();
			
			for (int i = 0; i <= 9; i++) {
				nMap.put(i, 0);
			}
			
			// 배수 진행하면서 해당하는 숫자에 digit를 올리기
			// digit에 값이 모두 0이 아니면 종료
			while (true) {
				String strN = Long.toString(n*k);
				for (int i = 0; i < strN.length(); i++) {
					nMap.put(strN.charAt(i) - '0', 1);
				}
				if (!nMap.containsValue(0)) break;
				k++;
			}
			sb.append("#").append(tc).append(" ").append(n*k).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
