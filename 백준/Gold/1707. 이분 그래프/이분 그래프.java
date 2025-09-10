/*
 * 이분 그래프
 * # 문제 이해
 * 그래프의 정점의 집합을 둘로 분할하여,
 * 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 
 * 그러한 그래프를 특별히 이분 그래프라 부른다.
 * 
 * 그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램 작성하기
 * 
 * # 문제 풀이
 * bfs로 그래프를 그려나가면서 이웃 정점의 색을 나와 다른 색으로 칠하기
 * if 색이 같다면 NO
 * 끝까지 그려진다면 YES
 * 
 * 1. 정점에 컬러를 넣었더니 간선의 정보마다 색정보가 업데이트 되지 않음
 * 2. 컬러용 배열을 따로 두기(visited 대신으로 사용 가능)
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph.get(from).add(to);
				graph.get(to).add(from);
			}
			
			// 0:미선택, 1:red, -1:blue
			int[] edgeColor = new int[V+1];
			boolean result = true;
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 1; i <= V; i++) {
				if (!result) break;
				if (edgeColor[i] == 0) {
					edgeColor[i] = 1;
					q.add(i);
					
					while (result && !q.isEmpty()) {
						int now = q.poll();
						for (int next : graph.get(now)) {
							if (edgeColor[next] == 0) {
								edgeColor[next] = edgeColor[now] * -1;
								q.add(next);
							}
							else {
								if (edgeColor[now] == edgeColor[next]) {
									result = false;
									break;
								}
							}
						}
					}
				}
			}
			
			if (result) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
