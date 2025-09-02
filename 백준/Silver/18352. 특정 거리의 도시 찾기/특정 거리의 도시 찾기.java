/*
 * 특정 거리의 도시 찾기
 * 
 * # 문제 이해
 * 1 ~ N 까지의 도시와 M개의 단방향 도로가 존재함
 * 모든 도로의 거리는 1
 * 
 * 특정한 도시 x로부터 출발하여 도달할 수 있는 모든 도시 중에서,
 * 최단 거리가 정확히 k인 모든 도시들의 번호를 출력하는 프로그램을 작성하기
 * 또한 출발도시 x에서 출발도시 x로 가는 최단거리는 항상 0이라고 가정한다
 * 
 * # 문제 풀이
 * 다익스트라 활용하여 출발도시로부터 모든 도시의 거리 구하기
 * 이후 거리가 k인 도시들 출력 
 * 없다면 -1 출력
 */

import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> graph;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// n : 노드 수 / m : 간선 수 / k : 거리 정보 / x : 출발 도시 번호
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		// n개 만큼 그래프 초기화하기
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		// m개의 간선 정보 그래프에 입력하기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}
		
		// dijkstra 이용하여 x로부터 노드들의 최단거리 알아내기
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(x);
		
		// dist 값들 중 k가 있으면 출력 / 출력할게 없으면 -1 출력
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] == k) {
				System.out.println(i);
				cnt++;
			}
		}
		if (cnt == 0)
			System.out.println(-1);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(start);
		
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			
			if (cur != start && dist[cur] < 1) continue;
			for (int next : graph.get(cur)) {
				if (dist[next] > dist[cur] + 1) {
					dist[next] = dist[cur] + 1;
					pq.add(next);
				}
			}
		}
	}
}
