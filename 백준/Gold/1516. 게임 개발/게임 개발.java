/*
 * 게임 개발
 * 
 * # 문제 이해
 * n개의 건물의 선행 관계가 주어질 때 각 건물이 완성되기까지 걸리는 최소 시간 출력하기
 * 
 * # 문제 풀이
 * 건물의 수 buildingN
 * 건물 짓는 시간 buildingTime[]
 * 선행관계 통해 그래프 만들기
 * 선행관계 있는 숫자대로 buildingBefore[]
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int buildingN = Integer.parseInt(br.readLine());
		
		int[] buildingTime = new int[buildingN+1];
		int[] buildingBefore = new int[buildingN+1];
		List<List<Integer>> graph = new ArrayList<>();
		List<List<Integer>> beforeGraph = new ArrayList<>();
		for (int i = 0; i <= buildingN; i++) {
			graph.add(new ArrayList<>());
			beforeGraph.add(new ArrayList<>());
		}
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= buildingN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			buildingTime[i] = time;
			
			int cnt = 0;
			while (true) {
				int before = Integer.parseInt(st.nextToken());
				if (before == -1) break;
				graph.get(before).add(i);
				beforeGraph.get(i).add(before);
				cnt++;
			}
			buildingBefore[i] = cnt;
			if (cnt == 0)
				q.add(i);
		}
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			// time 업데이트
			// 선행 건물 중 제일 큰 값 찾기
			int beforeMax = 0;
			for (int before : beforeGraph.get(now))
				beforeMax = Math.max(beforeMax, buildingTime[before]);
			// beforeMax와 내 건물짓는 시간 더해서 time 갱신하기
			buildingTime[now] += beforeMax;
			
			for (int next : graph.get(now)) {
				buildingBefore[next]--;
				
				if (buildingBefore[next] == 0)
					q.add(next);
			}
		}
		for (int i = 1; i <= buildingN; i++) {
			sb.append(buildingTime[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
