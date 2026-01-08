/*
 * [좌표 정렬하기]
 * 2차원 평면 위 점 n개 주어짐
 * 좌표를 x좌표가 증가하는 순으로,
 * x좌표가 같다면 y좌표가 증가하는 순서로 정렬한 후 출력하는 프로그램
 * 
 * # 풀이
 * Edge 클래스 정의하고
 * PriorityQueue 이용하여 정렬되도록 정의하기
 */

import java.io.*;
import java.util.*;
class Edge {
	int x;
	int y;
	
	public Edge(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(
				(a, b) -> {
					if (a.x == b.x) return Integer.compare(a.y, b.y);
					return Integer.compare(a.x, b.x);
				}
				
		);

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new Edge(x, y));
		}
		
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			sb.append(e.x).append(" ").append(e.y).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
