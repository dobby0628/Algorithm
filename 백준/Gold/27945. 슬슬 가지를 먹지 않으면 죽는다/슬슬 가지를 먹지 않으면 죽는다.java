

import java.util.*;
import java.io.*;
/*
 * [슬슬 가지를 먹지 않으면 죽는다]
 * 1 ~ N 번호가 붙은 N개의 요리 학원에 다니기 시작
 * M개의 양방향 길, i번째 길에는 정확히 ti 일에만 문을 여는 가지 디저트 노점이 있음(ti는 모두 다름)
 * 기억력이 퇴화해 n-1 개의 길만 기억함
 * 
 * 모든 요리 학원에 다닐 수 있도록  n-1개의 길을 골랐을 때, 키위새가 쓰러지는 날이 d일차라고 하자.
 * 날짜가 1일차부터 시작할 때, d의 최댓값을 구해보자
 * 
 * 요리 학원 수 n / 길의 수 m
 * 학원 번호 ui, vi, 노점이 여는 날 ti 가 주어짐
 * 두 요리 학원
 * 
 * # 풀이 방법
 * 1. 디저트 노점이 여는 날인 t의 값이 모두 다른데
 * 하루라도 먹지 않으면 쓰러지므로 t값을 기준으로 오름차순 정렬하여 
 * t값이 없으면 그날 쓰러짐
 * + 내가 알고 있는 길이 n-1개 여야 함
 * 
 */

public class Main {
	static class Road implements Comparable<Road> {
		int u;
		int v;
		int t;

		public Road(int u, int v, int t) {
			super();
			this.u = u;
			this.v = v;
			this.t = t;
		}

		@Override
		public int compareTo(Road o) {
			return Integer.compare(this.t, o.t);
		}

		@Override
		public String toString() {
			return "Road [u=" + u + ", v=" + v + ", t=" + t + "]";
		}
	}
	
	static class UnionFind {
		int[] parent;
		int[] rank;
		
		public UnionFind(int n) {
			parent = new int[n+1];
			rank = new int[n+1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}
		
		int find(int x) {
			if (parent[x] == x) return x;
			return parent[x] = find(parent[x]);
		}
		
		boolean union(int a, int b) {
			a = find(a);
			b = find(b);
			
			if (a == b) return false;
			
			if (rank[a] < rank[b]) {
				parent[a] = b;
			}
			else if (rank[a] > rank[b]) {
				parent[b] = a;
			}
			else {
				parent[b] = a;
				rank[a]++;
			}
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Road> pq = new PriorityQueue<>();
		
		for (int i = 0; i < g; i++) {
			st = new StringTokenizer(br.readLine());
			
			int tmp_u = Integer.parseInt(st.nextToken());
			int tmp_v = Integer.parseInt(st.nextToken());
			int tmp_t = Integer.parseInt(st.nextToken());
			
			pq.add(new Road(tmp_u, tmp_v, tmp_t));
		}
		
		int day = 1;
		UnionFind uf = new UnionFind(n);
		
		while (day <= n-1) {
			Road cur = pq.poll();
			if (!uf.union(cur.u, cur.v)) break;
			
			if (day == cur.t) {
				day++;
			}
			else {
				break;
			}
		}
		System.out.println(day);
	}
}
