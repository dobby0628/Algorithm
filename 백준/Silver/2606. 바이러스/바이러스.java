// dfs 연습 문제
// dfs 라는 것을 알고 풀려고 하니 dfs 적용하면 되는데
// 이후 다른 알고리즘을 알고 나서 접근방법에 대해서도 고민해봐야할 것 같다

import java.util.*;
import java.io.*;

public class Main {
	public static boolean[] visited;
	public static List<List<Integer>> graph;
	public static int count;
	
	public static void dfs(int node) {
		visited[node] = true;
		
		for (int to : graph.get(node)) {
			if (!visited[to]) {
				count++;
				dfs(to);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken()); // 컴퓨터개수
		st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken()); // 간선 개수
		
		// 초기화
		graph = new ArrayList<>();
		for (int i = 0; i <= c; i++)
			graph.add(new ArrayList<>());
		visited = new boolean[c + 1];
		
		// 간선 추가
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		count = 0;
		dfs(1);
		
		System.out.println(count);
	}
}

