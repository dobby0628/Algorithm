/*
 * # 문제 이해
 * N명 0~N-1번으로 번호가 매겨져 있음
 * 일부 사람들은 친구
 * 친구관계가 존재하는지 안하는지 구하는 프로그램 작성하기
 * - A B 친구
 * - B C 친구
 * - C D 친구
 * - D E 친구
 * 
 * 사람의 수 N / 친구 관계의 수 M 주어짐
 * 정수 a b : a b가 친구
 * 
 * - A에서 시작해서 E까지 깊이가 5인 연결이 있는지 없는지
 * 
 * # 문제 풀이
 * dfs로 깊이탐색을 하면서 깊이가 5가 되면 1로 출력하면서 종료
 * 1이 나오지 않는다면 0으로 출력하면서 종료
 */

import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> graph;
	static boolean[] visited;
	static boolean check;
	
	static void dfs(int node, int depth) {
		if (!check) {
			if (depth == 5) {
				check = true;
				return ;
			}
			visited[node] = true;
			for (int next : graph.get(node)) {
				if (!visited[next]) {
					dfs(next, depth+1);
				}
			}
			visited[node] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		visited = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		check = false;
		for (int i = 0; i < N; i++) {
			if (!check)
				dfs(i, 1);
		}
		
		if (check) System.out.println("1");
		else System.out.println("0");
	}
}
