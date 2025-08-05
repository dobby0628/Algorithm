import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	public static void dfs(int node) {
		visited[node] = true;
		
		for (int a : graph.get(node)) {
			if (!visited[a]) {
				visited[a] = true;
				dfs(a);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N +1];
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		for (int i = 1; i <= N; i++)
			Collections.sort(graph.get(i));
		
		int count = 0;
		for (int i = 1; i <=N; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
}
