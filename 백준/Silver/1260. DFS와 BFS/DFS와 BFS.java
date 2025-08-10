import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static List<List<Integer>> graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int node) {
		visited[node] = true;
		sb.append(node);
		sb.append(" ");
		
		for (int next : graph.get(node)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 간선 입력받기
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		// dfs
		visited = new boolean[1+N];
		dfs(V);
		sb.append("\n");

		// bfs
		visited = new boolean[1+N];
		Queue<Integer> q = new LinkedList<>();
		q.offer(V);
		while (!q.isEmpty()) {
			int now = q.poll();
			visited[now] = true;
			sb.append(now);
			sb.append(" ");
			for (int next : graph.get(now)) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
