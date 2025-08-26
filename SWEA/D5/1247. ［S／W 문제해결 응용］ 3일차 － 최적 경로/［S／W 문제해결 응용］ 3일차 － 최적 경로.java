/*
 * # 문제 이해
 * N명 방문 후 자신의 집으로 돌아감
 * 위치 : x, y로 주어짐 (0 ≤ x ≤ 100, 0 ≤ y ≤ 100)
 * 두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산
 * 회사의 좌표, 집의 좌표, 고객들의 좌표는 모두 다름
 * 
 * N 명의 고객 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것을 찾으려고 함
 * 2 <= N <= 10
 * 
 * 
 * # 문제 풀이
 * 회사 좌표 -> N명의 고객 들리고 -> 집 좌표
 * 처음-회사 과 끝-집으로 고정해 놓은 상태에서 완전탐색으로 가장 작은 가중치 구하기
 * bfs로 완전탐색하면서 최소 가중치 구함
 */

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
	static int customerN;
	static Point start, end;
	static List<Point> list;
	static boolean[] visited;
	static int minWeight, presentWeight;
	
	// 가중치 구하는 함수
	static int getWeight(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	// dfs
	static void dfs(int present, int depth) {
        if (presentWeight > minWeight)
			return;
		if (depth == customerN) {
			presentWeight += getWeight(list.get(present), end);
			minWeight = Math.min(minWeight, presentWeight);
			presentWeight -= getWeight(list.get(present), end);
			return;
		}
		for (int next = 0; next < customerN; next++) {
			if (!visited[next]) {
				presentWeight += getWeight(list.get(present), list.get(next));
				visited[next] = true;
				dfs(next, depth +1);
				presentWeight -= getWeight(list.get(present), list.get(next));
				visited[next] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <= tc; testcase++) {
			customerN = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = -2; i < customerN; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if (i == -2) start = new Point(x, y);
				else if (i == -1) end = new Point(x, y);
				else list.add(new Point(x, y));
			}
			
			minWeight = Integer.MAX_VALUE;
			visited = new boolean[customerN];
			// 완전 탐색으로 모든 경우의 수 중 가장 작은 가중치 구하기
			for (int i = 0; i < customerN; i++) {
				presentWeight = 0;
				
				visited[i] = true;
				presentWeight += getWeight(start, list.get(i));
				dfs(i, 1);
				visited[i] = false;
				presentWeight -= getWeight(start, list.get(i));
			}
			sb.append("#").append(testcase).append(" ").append(minWeight).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
