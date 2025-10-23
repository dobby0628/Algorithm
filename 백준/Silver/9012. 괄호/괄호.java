/*
 * [괄호]
 * 
 * # 문제 이해
 * 괄호의 모양이 바르게 구성된 문자열 판단하는 프로그램
 * 
 * # 문제 풀이
 * ( 나오면 스택에 넣기
 * ) 나오면 스택에서 ( 를 빼서 수가 바른지 확인하기
 * 수가 같지 않으면 NO 마지막까지 봤는데 스택이 비어있다면 YES
 */

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= t; i++) {
			String str = br.readLine();
			int leftCnt = 0;
			boolean check = false;
			for (char c : str.toCharArray()) {
				if (c == '(') {
					leftCnt++;
				}
				else if (c == ')') {
					if (leftCnt == 0) {
						check = true;
						break;
					}
					else {
						leftCnt--;
					}
				}
			}
			if (check || leftCnt != 0) sb.append("NO\n");
			else sb.append("YES\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
