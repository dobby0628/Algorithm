/*
# 문제 : 케빈 베이컨의 6단계 법칙
유저의 수와 친구 관계의 수가 주어졌을 때
몇 다리를 거쳐야 연결되는 관계인지 구하고 그 값이 최소가 되는 사람을 출력한다.
단, 그런 사람이 여러 명일 경우 번호가 가장 작은 사람을 출력한다.
*/

import java.util.*;
import java.io.*;

public class Main
{
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;
    
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    dist[next] = dist[now] + 1;
                }
            }
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
    graph[i] = new ArrayList<>();
}
		
		for (int i = 0; i < m; i++) {
		    st = new StringTokenizer(br.readLine());
		    
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		
		    graph[a].add(b);
		    graph[b].add(a);
		}
		
		int[] sum = new int[n+1];
		int min_index = 1;
		
		for (int i = 1; i <= n; i++) {
		    visited = new boolean[n+1];
		    dist = new int[n+1];
		    bfs(i);
		    
		    for (int j = 1; j <= n; j++) {
		        sum[i] += dist[j];
		    }
		    
		    if (sum[i] < sum[min_index]) {
                min_index = i;
            }
		}
		
		System.out.println(min_index);
	}
}