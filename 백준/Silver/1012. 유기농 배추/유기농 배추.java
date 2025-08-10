
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int K;
	static int[][] graph;
	static int[] kx;
	static int[] ky;
	static boolean[] visited;
	
	static int[] dx = {0, 0, -1, +1};
	static int[] dy = {-1, +1, 0, 0};
	
	static void dfs(int node) {
		visited[node] = true;
		for (int i = 0; i < 4; i++) {
			int cx = kx[node] + dx[i];
			int cy = ky[node] + dy[i];
			if (cx >= 0 && cx < N && cy >= 0 && cy < M) {
				for (int ki = 0; ki < K; ki++) {
					if (visited[ki]) continue;
					if (cx == kx[ki] && cy == ky[ki])
						dfs(ki);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			graph = new int[N][M];
			
			kx = new int[K];
			ky = new int[K];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
				kx[i] = x;
				ky[i] = y;
			}
			
			visited = new boolean[K];
			
			int result = 0;
			for (int i = 0; i < K; i++) {
				if (!visited[i]) {
					result++;
					dfs(i);
				}
			}
			bw.write(Integer.toString(result) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
