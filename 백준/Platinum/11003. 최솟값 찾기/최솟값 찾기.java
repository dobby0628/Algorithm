/*
 * # 문제 이해
 * N개의 수와 L이 주어진다.
 * D = 나를 포함한 앞의 L개의 수 중 최소값
 * 음수인 값은 무시하고 구하기
 * 
 * # 문제 풀이
 * 슬라이딩 윈도우 사용하여 최소값 갱신하기
 * 
 * 문제 1) 최소값만 기억하면 될 줄 알았는데 범위가 달라지므로 불가
 * 
 * # 입력 최대
 * 1 ≤ L ≤ N ≤ 5,000,000
 * -10^9 ≤ A_i ≤ 10^9 -2147483648
 * 
 * # 시간 제한 2.4초 O(n)으로 끝낼 수 있어야함
 * 
 */

import java.util.*;
import java.io.*;

class team{
	int index;
	int value;
	
	team(int index, int value) {
		this.index = index;
		this.value = value;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Deque<team> teams = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			// 덱의 맨 앞 team.index가 i - L + 1보다 작을 경우 삭제하기
			if (!teams.isEmpty() && teams.peekFirst().index < i - L + 1)
				teams.pollFirst();
			
			int value = Integer.parseInt(st.nextToken());
			if (teams.isEmpty())
				teams.addLast(new team(i, value));
			else {
				// 뒤에 넣는 수는 가장 작아야함 -> value값이 가장 작을 때까지 poll해줘야함
				while (!teams.isEmpty() && teams.peekLast().value > value)
					teams.pollLast();
				teams.addLast(new team(i, value));
			}
			sb.append(teams.peekFirst().value);
			sb.append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
