/*
 * 줄 세우기
 * 
 * # 문제 이해
 * n 명의 학생들을 키 순서대로 줄 세우기
 * 
 * 일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램
 * 
 * # 문제 풀이
 * 주어진 방향그래프를 통해 위상정렬 이용해서 줄세우기
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int studentN = Integer.parseInt(st.nextToken());
		int compareN = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= studentN; i++) {
			graph.add(new ArrayList<>());
		}
		int[] studentInput = new int[studentN+1];
		
		for (int i = 0; i < compareN; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			studentInput[b]++;
			graph.get(a).add(b);
		}
		
		boolean[] visited = new boolean[studentN+1];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= studentN; i++) {
			if (studentInput[i] == 0) {
				q.add(i);
				visited[i] = true;
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();
			
			sb.append(now).append(" ");
			
			for (int next : graph.get(now)) {
				// now에서 가는 가지 지우기
				studentInput[next]--;
			}
			
			for (int i = 1; i <= studentN; i++) {
				if (studentInput[i] == 0 && visited[i] == false) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
