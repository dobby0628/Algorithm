/*
 * # 문제 이해
 * 절대값 힙은 다음과 같은 연산을 지원하는 자료구조
 * 1. 배열에 정수 x(x != 0) 를 넣는다.
 * 2. 배열에서 절댓값이 가장 작은 값 출력 후 배열에서 제거
 * 		절댓값이 가장 작은 값이 여러개 -> 가장 작은 수를 출력 후 배열에서 제거
 * 
 * 프로그램은 처음 비어있는 배열에서 시작
 * 
 * # 문제 풀이
 * 배열에 절대값과 원래 값을 넣을 것인지
 * 배열에 어떤식으로 정렬할 것인지
 * 
 * 어떤 자료구조를 이용할 것인지
 * 
 * 힙을 사용하나 정렬기준이 오름차순이 아니므로 Comparator를 이용하여 비교하는 기준을 세워주기
 * 1. 절대값기준
 * 2. 절대값이 같다면 음수가 앞에 가도록
 * 
 * # 시간복잡도 O(n)
 * n : 100000
 * 
 * ************ 못풀어서 풀이 봄 나중에 다시 풀기
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 절댓값이 같으면 오름차순 정렬(음수가 앞에 들어가도록)
				if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
				// 절대값이 다르면 오름차순 정렬
				else return Math.abs(o1) - Math.abs(o2);
			}
		});
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			int result = 0;
			if (input == 0) {
				result = pq.isEmpty() ? 0 : pq.poll();
				sb.append(result);
				sb.append("\n");
			}
			else {
				pq.offer(input);
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
