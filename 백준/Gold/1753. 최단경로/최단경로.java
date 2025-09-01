/*
 * 최단경로
 * # 문제 이해
 * 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램 작성하기
 * 모든 간선의 가중치는 10이하의 자연수이다
 * 
 * # 문제 풀이
 * 다익스트라 연습하기
 */

import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int to;
		int weight;
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	static List<List<Edge>> graph;
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		int start = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Edge(v, w));
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		dijkstra(start);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int now = cur.to;
			
			if (dist[now] < cur.weight) continue;
			
			for (Edge next : graph.get(now)) {
				if (dist[next.to] > dist[now] + next.weight) {
					dist[next.to] = dist[now] + next.weight;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}
	}
}
