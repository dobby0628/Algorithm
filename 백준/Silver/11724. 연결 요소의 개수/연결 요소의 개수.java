/*
 * # 문제 이해
 * 방향 없는 그래프가 주어졌을 때, 연결 요소의 개수를 구하는 프로그램 작성하기
 * 
 * # 문제 풀이
 * dfs로 연결된 요소들의 개수 구하기
 */

import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	static void dfs(int node) {
		visited[node] = true;
		for (int next : graph.get(node)) {
			if (!visited[next])
				dfs(next);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		int cnt = 0;
		for (int node = 1; node <= N; node++) {
			if (!visited[node]) {
				cnt++;
				dfs(node);
			}
		}
		System.out.println(cnt);
	}
}
