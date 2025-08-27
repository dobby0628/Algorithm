/*
 * # 문제 이해
 * 트리의 지름 : 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것
 * 
 * 트리의 지름을 구하는 프로그램 만들기
 * 
 * 트리의 정점의 개수 V 가 주어짐 (2 ≤ V ≤ 100,000)
 * 
 * 간선의 정보가 주어짐
 * 정점 번호  | 연결된 정점 번호 | 연결된 정점까지의 거리 | ... | -1
 * 
 * # 문제 풀이
 * 모든 점들을 순차적으로 bfs로 탐색하면서 비중을 더해감
 * 비중을 더할때 배열을 사용하여 부모의 비중에 나의 비중을 더함
 * 그 중 가장 큰 값을 결과값으로 출력한다.
 * 
 * 임의의 s에서 가장 먼곳-u을 찾고
 * u에서 가장 먼곳-v을 찾으면 u-v가 트리의 지름이다!!
 * ㄴ 트리이기 때문에!!
 */

import java.io.*;
import java.util.*;

public class Main {
	static int V, max, max_i;
	static List<List<edgeInfo>> graph;
	static boolean visited[];
	static int[] distance;
	
	static class edgeInfo {
		int to;
		int weight;
		public edgeInfo(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "edgeInfo [to=" + to + ", weight=" + weight + "]";
		}
	}
	
	static void bfs(int start) {
		distance = new int[V+1];
		visited = new boolean[V+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int present = q.poll();
			for (edgeInfo next : graph.get(present)) {
				int next_to = next.to;
				int next_weight = next.weight;
				if (!visited[next_to]) {
					visited[next_to] = true;
					q.add(next_to);
					distance[next_to] = distance[present] + next_weight;
				}
			}
		}
	}
	
	static void distanceMax() {
		max = 1;
		for (int i = 1; i <= V; i++) {
			if (distance[i] > max) {
				max = distance[i];
				max_i = i;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// V 입력받고 리스트 초기화하기
		V = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i <= V; i++)
			graph.add(new ArrayList<>());
		
		// 간선 정보 입력받기
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1) break;
				int weight = Integer.parseInt(st.nextToken());
				graph.get(from).add(new edgeInfo(to, weight));
			}
		}
		
		// bfs 활용하여 1번 정점에서 가장 먼 정점 찾기
		bfs(1);
		// bfs 결과의 최대값 찾기
		distanceMax();
		// bfs 활용하여 위에서 구한 가장 먼 정점에서 먼 정점 찾기
		bfs(max_i);
		distanceMax();

		System.out.println(max);
	}
}
