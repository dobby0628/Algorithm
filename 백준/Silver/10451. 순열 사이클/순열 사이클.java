import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	static void dfs(int node) {
		visited[node] = true;
		
		for (int n : graph.get(node)) {
			if (!visited[n]) {
				visited[n] = true;
				dfs(n);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 0; testcase < T; testcase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for (int i = 0; i <= N; i++)
				graph.add(new ArrayList<Integer>());
			visited = new boolean[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int to = Integer.parseInt(st.nextToken());
				graph.get(i).add(to);
			}
			
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					count++;
					dfs(i);
				}
			}
			System.out.println(count);
		}
	}
}
