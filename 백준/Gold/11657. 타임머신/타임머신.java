/*
 * [타임머신]
 * 
 * # 문제 이해
 * n개의 도시
 * a에서 출발하여 b로 도착할 때 걸리는 시간 : c
 * ! c는 음수일수도 있음
 * 
 * 1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램
 * 
 * # 문제 풀이
 * 간선의 정보가 주어지고 비중에 음수가 있으므로 벨만포드 알고리즘 사용하여 풀이 진행
 * 
 */

import java.io.*;
import java.util.*;

class Edge {
	int from;
	int to;
	int weight;
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
}
public class Main {
	static final long INF = Long.MAX_VALUE / 4;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(a, b, c));
		}
		
		// 거리 배열 초기화
		long[] dist = new long[V+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		// 1) v-1만큼 엣지 돌리기
		for (int i = 1; i < V; i++) {
			for (Edge e : edges) {
				if (dist[e.from] != INF && dist[e.from] + e.weight < dist[e.to]) {
					dist[e.to] = dist[e.from] + e.weight;
				}
			}
		}
		
		// 2) 음수 사이클 여부 확인하기
		boolean hasNegativeCycle = false;
		for (Edge e : edges) {
			if (dist[e.from] != INF && dist[e.from] + e.weight < dist[e.to]) {
				hasNegativeCycle = true;
				break;
			}
		}
		
		if (hasNegativeCycle)
			sb.append("-1\n");
		else {
			for (int i = 2; i <= V; i++) {
				if (dist[i] == INF) sb.append("-1\n");
				else sb.append(dist[i]).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
