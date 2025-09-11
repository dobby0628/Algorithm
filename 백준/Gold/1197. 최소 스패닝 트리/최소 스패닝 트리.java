/*
 * 최소 스패닝 트리
 * 
 * # 문제 이해
 * 그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램
 * 
 * # 문제 풀이 
 * 크루스칼 풀이로 풀기
 */

import java.io.*;
import java.util.*;

public class Main {
	static class Line implements Comparable<Line> {
		int a;
		int b;
		long weight;
		public Line(int a, int b, long weight) {
			super();
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		@Override
		public int compareTo(Line o) {
			return Long.compare(this.weight, o.weight);
		}
		@Override
		public String toString() {
			return "Line [a=" + a + ", b=" + b + ", weight=" + weight + "]";
		}
	}
	static int[] parent;
	
	static int find(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return true;
		else {
			parent[b] = a;
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		parent = new int[v+1];
		for (int i = 0; i <= v; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Line> pq = new PriorityQueue<>();
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new Line(a, b, weight));
		}
		
		long result = 0;
		while (!pq.isEmpty()) {
			Line now = pq.poll();
			
			if (union(now.a, now.b)) {
				continue;
			}
			else {
				result += now.weight;
			}
		}
		
		System.out.println(result);
	}
}
