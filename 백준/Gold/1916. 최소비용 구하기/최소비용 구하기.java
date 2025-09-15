/*
 * 여행을 떠나요
 * # 문제이해
 * 도시는 1 ~ N번
 * 도시 사이 버스 운행하고 있음
 * 버스는 시작 도시와 도착도시 비용으로 표현됨
 * 여러 개의 버스가 같은 두 도시를 오갈 수 있으며, 비용은 다를 수 있음
 * 
 * 도시를 이동할 때 가장 적은 비용을 들이고 싶음
 * 
 * # 문제 풀이
 * 다익스트라
 * 
 */
import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int to;
		long weight;
		public Edge(int to, long weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	static long[] dist;
	static List<List<Edge>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// graph init
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());
		
		// 간선 정보 받기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			
			graph.get(from).add(new Edge(to, weight));
		}
		
		// start end input
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		dikcstra(start);
		
		System.out.println(dist[end]);
		br.close();
	}

	static void dikcstra(int start) {
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if (dist[now.to] < now.weight) continue;
			
			for (Edge next : graph.get(now.to)) {
				if (dist[next.to] > dist[now.to] + next.weight) {
					dist[next.to] = dist[now.to] + next.weight;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}
	}
}
