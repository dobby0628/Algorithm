/*
 * [트리]
 * 
 * # 문제 이해
 * 리프 노드 : 자식의 개수가 0인 노드
 * 트리가 주어지고 노드 하나를 지웠을 때, 그 때, 남은 리프 노드의 개수 구하는 프로그램
 * 노드를 지우면 그 노드와 노드의 모든 자손이 트리에서 제거됨
 * 
 * # 문제 풀이
 * 인접리스트를 만들어서 관계 저장 후
 * 1부터 dfs를 돌려 리프노드를 찾아 개수 구하기
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<List<Integer>> graph;
	static boolean[] visited;
	static int deleteNode;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];

		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		int root = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent != -1) {
				graph.get(parent).add(i);
				graph.get(i).add(parent);
			} else {
				root = i;
			}
		}

		deleteNode = Integer.parseInt(br.readLine());
		cnt = 0;
		if (deleteNode != root) {
			dfs(root);
		}
		System.out.println(cnt);
		
		br.close();
	}
	
	static void dfs(int n) {
		visited[n] = true;
		int count = 0;
		
		for (int next : graph.get(n)) {
			if (!visited[next] && next != deleteNode) {
				count++;
				dfs(next);
			}
		}
		if (count == 0) {
			cnt++;
		}
	}
}
