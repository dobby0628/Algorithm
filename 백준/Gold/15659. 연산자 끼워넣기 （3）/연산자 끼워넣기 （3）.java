/*
 * 연산자 끼워넣기 (3)
 * 
 * # 문제 이해
 * n개의 수가 주어짐
 * 수 사이에 끼울 수 있는 연산자 n-1 주어짐
 * 
 * 수 사이에 연산자를 넣어서 수식을 만들어 낼 수 있는 최소값, 최대값 만드는 프로그램
 * 단, 수의 순서는 바꿀 수 없음
 * 
 * # 문제 풀이
 * N(2 ≤ N ≤ 11)
 * 연산자 1 ≤ N ≤ 10
 * 숫자가 고정되어 있고 연산자만 순서가 바뀌기 때문에 시간초과가 나지 않음
 * 
 * dfs와 백트래킹을 활용하여 연산자가 올 수 있는 모든 경우의 수를 탐색하면서 최종값 배열 구하기
 * 배열의 최소값과 최대값 출력하기
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] num;
	static int[] operator;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static char[] cal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		cal = new char[n - 1];
		
		// 숫자 입력받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		// 연산자 개수 입력받기
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());
		
		dfs(0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void dfs(int depth) {
		if (depth == n-1) {
			calculateResult();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operator[i] == 0) continue;
			
			cal[depth] = getOperatorBySeq(i);
			
			operator[i]--;
			dfs(depth+1);
			operator[i]++;
		}
	}
	
    private static void calculateResult() {

        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> operatorStack = new LinkedList<>();
        numStack.add(num[0]);

        for (int i = 0; i < cal.length; i++) {
            char operator = cal[i];

            switch (operator) {
                case '+': case '-' :
                    operatorStack.addLast(operator);
                    numStack.addLast(num[i + 1]);
                    break;
                case '*':
                    numStack.addLast(numStack.pollLast() * num[i + 1]);
                    break;
                case '/':
                    numStack.addLast(numStack.pollLast() / num[i + 1]);
                    break;
            }
        }

        int result = numStack.poll();

        while (!operatorStack.isEmpty()) {
            Character operator = operatorStack.poll();

            Integer num = numStack.poll();

            if (operator == '+') result += num;
            if (operator == '-') result -= num;
        }

        max = Math.max(result, max);
        min = Math.min(result, min);
    }
	
	private static char getOperatorBySeq(int i) {

        if (i == 0) return '+';
        if (i == 1) return '-';
        if (i == 2) return '*';
        if (i == 3) return '/';

        throw new RuntimeException("잘못된 요청");
    }
}
