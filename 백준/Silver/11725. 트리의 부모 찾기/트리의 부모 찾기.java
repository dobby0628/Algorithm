/*
 * [트리의 부모 찾기]
 * 
 * # 문제 이해
 * 루트 없는 트리가 주어짐
 * 트리의 루트를 1로 정했을 때, 각 노드의 부모를 구하는 프로그램 구하기
 * 
 * # 문제 풀이
 * 인접리스트를 만들어서 관계 저장 후
 * 1부터 dfs를 돌려 부모 찾기
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static boolean[] visited;
	static List<List<Integer>> graph;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		answer = new int[n+1];
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 1; i <= n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		dfs(1);
		
		for (int i = 2; i <= n; i++) {
			sb.append(answer[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void dfs(int parent) {
		visited[parent] = true;
		
		for (int child : graph.get(parent)) {
			if (!visited[child]) {
				answer[child] = parent;
				dfs(child);
			}
		}
	}
}
