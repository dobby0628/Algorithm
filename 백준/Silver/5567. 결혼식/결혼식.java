/*
 * # 문제 이해
 * 상근이의 동기는 모두 N명
 * 학번은 1~N - 상근이의 학번은 1
 * 친구 관계 리스트가 주어질 때 상근이가 초대가능한 동기의 수 출력하기
 * 
 * # 문제 풀이
 * bfs
 * 
 */

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<Integer>());
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		boolean[] visited = new boolean[1+N];
		int result = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {1, 0});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int now_n = now[0];
			int deep = now[1];
			visited[now_n] = true;

			if (deep == 2) continue;
			
			for (int next : graph.get(now_n)) {
				if (!visited[next]) {
					visited[next] = true;
					result++;
					q.offer(new int[] {next, deep +1});
				}
			}
		}
		
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
	}
}
