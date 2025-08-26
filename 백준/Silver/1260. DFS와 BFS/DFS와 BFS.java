/*
 * # 문제 이해
 * 정점의 개수 N 과 간선의 개수 M, 시작할 정점의 번호 V가 주어짐
 * 간선의 정보가 주어졌을 때
 * 
 * DFS, BFS 순으로 수행한 결과를 출력하라
 */

import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	static void dfs(int node) {
		visited[node] = true;
		sb.append(node).append(" ");
		for (int next : graph.get(node)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}
		
		// dfs
		dfs(V);
		sb.append("\n");
		
		// bfs
		visited = new boolean[N+1];
		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.offer(V);
		visited[V] = true;
		while (!dq.isEmpty()) {
			int present = dq.poll();
			sb.append(present).append(" ");
			for (int next : graph.get(present)) {
				if (!visited[next]) {
					visited[next] = true;
					dq.offer(next);
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
