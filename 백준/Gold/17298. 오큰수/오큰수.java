/*
 * # 문제 이해
 * 크기 N인 수열 A가 있음
 * 수열의 각 원소 A_i에 대해서 오큰수NGE(i)를 구하려고 한다.
 * 
 * 오큰수? A_i의 오른쪽에 있으면서 A_i보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미
 * ㄴ 오큰수가 없을 경우 : -1
 * 
 * 예시) A=[3,5,2,7]인 경우
 * 3의 오큰수 : 5
 * 5의 오큰수 : 7
 * 2의 오큰수 : 7
 * 7의 오큰수 : -1
 * 
 * # 문제 풀이
 * 나보다 오른쪽에 있는 수열 중 큰 수들만 큐에 넣기
 * 큐에서 꺼내오는 값이 그 값의 오큰수
 * if 큐 isEmpty -> -1
 * 
 * # 실제 풀이
 * 1) 2중 반복문 사용 : 오른쪽 수들 중 가장 왼쪽의 값만 필요하므로 굳이 큐에 넣지 않아도 됨 -> 시간 초과
 * 		// 반복문으로 풀이 시 1,000,000 * 1,000,000 = 10^12
 * 		// 1초는 10^6 -> 반복문으로 풀이 시 시간 초과 발생
 * 2) 단조 스택 사용 : O(n)
 * 
 * # 시간복잡도 O(n)
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int sequence_n = Integer.parseInt(br.readLine());
		
		int[] sequence = new int[sequence_n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<sequence_n; i++)
			sequence[i] = Integer.parseInt(st.nextToken());
		
		
		/* 1) 풀이
		for (int i = 0; i < sequence_n; i++) {
			int target = sequence[i];
			int result = -1;
			for (int j = i+1; j < sequence_n; j++) {
				int comparison = sequence[j];
				if (target < comparison) {
					result = comparison;
					break;
				}
			}
			sb.append(result);
			sb.append(" ");
		}
		*/
		
		// 단조 스택 사용 2)
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[sequence_n];
		stack.push(0);
		for (int i = 1; i < sequence_n; i++) {
			while (!stack.isEmpty() && sequence[stack.peek()] < sequence[i])
				answer[stack.pop()] = sequence[i];
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}
		for (int i = 0; i < sequence_n; i++) {
			sb.append(answer[i]);
			sb.append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
