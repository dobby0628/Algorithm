/*
 * 문제 이해
 * - 부모를 찾으면서 겹치는 부분 출력하는 문제
 * - 노드 본인도 답으로 가능하다
 * 
 * 문제 풀이
 * - 노드 저장할 때 자식 -> 부모  순서로 간선 저장
 * - 첫번째 노드 값을 dfs 경로 탐색 -> 이때 visited 값이 true로 변경됨
 * - 두번재 노드 값을 dfs 경로 탐색 -> 지나가면서 visited 값이 true인 값을 만나면 해당 값이 정답
 */

import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> graph;
	static boolean[] visited;
	static int cmn_parent;
	static void dfs(int node) {
		visited[node] = true;

		for (int n : graph.get(node)) {
			if (!visited[n]) {
				visited[n] = true;
				dfs(n);
			}
			else
				cmn_parent = n;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<Integer>());
			}
			visited = new boolean[N + 1];
			
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				graph.get(child).add(parent);
			}
			
			// 가까운 공통 조상을 구할 두 노드
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			// 첫번째 노드 dfs 실행하기
			dfs(node1);
			dfs(node2);
			System.out.println(cmn_parent);
		}
	}
}
