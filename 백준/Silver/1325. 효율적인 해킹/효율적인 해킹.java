/*
 * # 문제 이해
 * N개의 컴퓨터가 있을 때
 * A가 B를 신회하는 경우 B를 해킹하면, A도 해킹 가능
 * 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램 작성하기
 * 
 * # 문제 풀이
 * dfs 이용
 * 
 * # 특이사항
 * 
 */

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static List<List<Integer>> graph;
	static boolean[] visited;
	static int[] hack;
	static int hacking_n;
	static int hack_max;
	
	static void dfs(int node) {
		visited[node] = true;
		hacking_n++;
		for (int next : graph.get(node)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// N : 컴퓨터 수 / M : 신뢰관계 수
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//dfs에 사용할 변수들 초기화
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<Integer>());
		
		// M만큼 신뢰관계 graph에 적용하기
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(B).add(A);
		}
		
		// dfs로 컴퓨터별 해킹가능한 컴퓨터 개수 알아내기
		hack = new int[1+N];
		hack_max = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[1+N];
			hacking_n = 0;
			dfs(i);
			hack[i] = hacking_n;
			hack_max = hack_max < hack[i]? hack[i] : hack_max;
		}
		
		// hack_max와 개수가 같은 컴퓨터번호 출력하기
		for (int i = 1; i <= N; i++) {
			if (hack[i] == hack_max) {
				sb.append(i);
				sb.append(" ");
			}
		}
		
		// 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
