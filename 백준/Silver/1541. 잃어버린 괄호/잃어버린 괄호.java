/*
 * 잃어버린 괄호
 * # 문제 이해
 * 세준이는 양수 + - 괄호 가지고 식을 만들었다.
 * 
 * 그리고 나서 세준이는 괄호를 모두 지웠다.
 * 
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드려고 한다
 * 
 * 식이 주어졌을 때 괄호를 쳐서 최소를 만들 수 있는 값을 출력하라
 * 
 * # 문제 풀이
 * - 이후 +가 나오면 뒤의 를 먼저 처리하기
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String command = br.readLine();
		
		List<Long> num = new ArrayList<>();
		List<Character> sign = new ArrayList<>();
		
		long n = 0;
		for (int i = 0; i < command.length(); i++) {
			char ci = command.charAt(i);
			if (ci >= '0' && ci <= '9') {
				n  = n * 10 + (ci -'0');
			}
			else if (ci == '+' || ci == '-') {
				num.add(n);
				n = 0;
				sign.add(ci);
			}
		}
		num.add(n);
		
		//System.out.println(num);
		//System.out.println(sign);
		
		long answer = num.get(0);
		long secondN = 0;
		boolean beforeMinus = false;
		
		for (int i = 1; i < num.size(); i++) {
			long presentN = num.get(i);
			
			if (sign.get(i-1) == '+') {
				if (beforeMinus) {
					secondN += presentN;
				}
				else {
					answer += presentN;
				}
			}
			else if (sign.get(i-1) == '-') {
				if (beforeMinus) {
					answer -= secondN;
					secondN = presentN;
				}
				else {
					beforeMinus = true;
					secondN += presentN;
				}
			}
			//System.out.println(i + " : " + answer + "," + secondN + "," + beforeMinus);
		}
		if (beforeMinus)
			answer -= secondN;
		
		System.out.println(answer);
	}
}
	