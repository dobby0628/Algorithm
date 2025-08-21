/*
 * # 문제 이해
 * 해야 할  V개의 작업이 있다.
 * 이들 중에 어떤 작업은 특정 작업이 끝나야 시작 가능 -> 선행 관계
 * 선행 관계를 나타낸 그래프 주어짐
 * 사이클 존재하지 않음
 * 
 * # 입력
 * 정점의 개수 V(3 ≤ V ≤ 1000)
 * 간선의 개수 E(2 ≤ E ≤ 3000)
 * 
 * # 문제 풀이
 * 진입 차수 이용
 * 
 * 진입 차수가 0인 것부터 큐에 넣어서 bfs로 순회
 */
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<List<Integer>> graph = new ArrayList<>();
			HashMap<Integer, Integer> visitCnt = new HashMap<>();
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<Integer>());
				if (i == 0) continue;
				visitCnt.put(i, 0);
			}

			st = new StringTokenizer(br.readLine());
			int max_value = 0;
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.get(from).add(to);
				int value = visitCnt.get(to) + 1;
				visitCnt.put(to, value);
				max_value = Math.max(max_value, value);
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			boolean[] visited = new boolean[V+1];
			int zeroCnt = 0;
			while (zeroCnt < V) {
				for (int key : visitCnt.keySet()) {
					if (!visited[key] && visitCnt.get(key) == 0) {
						zeroCnt++;
						q.offer(key);
						visited[key] = true;
						for (int next : graph.get(key)) {
							if (!visited[next])
								visitCnt.put(next, visitCnt.get(next) -1);
						}
					}
				}
			}

			while (!q.isEmpty()) {
				int present = q.poll();
				sb.append(present).append(" ");
			}
			sb.append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
