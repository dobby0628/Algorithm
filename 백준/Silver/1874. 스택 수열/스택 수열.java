/*
 *  # 문제 이해
 *  1 ~ n 까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
 *  push하는 순서는 반드시 오름차순
 *  
 *  임의의 수열이 주어질 때
 *  스택을 활용하여 주어진 수열을 만들 수 있는지 없는지
 *  ㄴ 있다면, 어떤 순서로 +(push) -(pop)하는지 수행 연산 출력
 *  ㄴ 없다면, NO 출력
 *  
 *  # 문제 풀이
 *  일단 1 ~ n까지 stack에 넣는 반복문 필요
 *  
 *  주어진 수열의 처음 수가 스택에 들어갈때까지 push 반복 후 pop
 *  그 다음 타겟이 스택의 현재 위치에 있거나 현재 위치의 값보다 크면 push 반복 후 pop 반복
 *  but, 그 다음 타겟이 현재 위치 값보다 작으면 구현 불가 -> NO
 *  
 *  # 시간복잡도 O(n)
 *  - 수열받을 때 반복문 O(n)
 *  - 수열만들 때 반복문 O(n) + 내부 스택 O(n)
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] sequence = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sequence[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		int stack_i = 1; // stack에 넣는 수 1부터 시작
		
		// 수열의 값 반복문
		for (int s_i = 1; s_i <=n; s_i++) {
			int target = sequence[s_i];
			
			while (stack_i <= target) {
				stack.add(stack_i);
				sb.append("+\n");
				stack_i++;
			}
			if (stack.peek() == target) {
				stack.pop();
				sb.append("-\n");
			}
			else {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
