/* # 문제 이해
 * 환경부담금 공식 : 환경부담세율(E) * 해저터널 길이(L^2)
 * 환경부담금을 최소로 지불하며, N개의 섬을 연결할 수 있는 교통 시스템 설계하기
 * 
 * 
 */

import java.io.*;
import java.util.*;

public class Solution {
	static int islandN;
	static int[] x;
	static int[] y;
	static List<Edge> edgeList;
	static int[] presents;
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double weight;
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}
	
	static double getWeight(int a, int b) {
		return Math.pow(Math.abs(x[a] - x[b]), 2) 
				+ Math.pow(Math.abs(y[a] - y[b]), 2);
	}
	
	static void initPresents() {
		presents = new int[islandN];
		for (int i = 0; i < islandN; i++) {
			presents[i] = i;
		}
	}
	
	static int find(int node) {
		if (presents[node] == node) return node;
		else return presents[node] = find(presents[node]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		else {
			presents[b] = a;
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <= tc; testcase++) {
			islandN = Integer.parseInt(br.readLine());
			
			x = new int[islandN];
			y = new int[islandN];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < islandN; j++) {
					if (i == 0) x[j] = Integer.parseInt(st.nextToken());
					else y[j] = Integer.parseInt(st.nextToken());
				}
			}
			double E = Double.parseDouble(br.readLine());
			
			// 간선 정보 저장하기
			edgeList = new ArrayList<>();
			for (int i = 0; i < islandN; i++) {
				for (int j = i+1; j < islandN; j++) {
					edgeList.add(new Edge(i, j, getWeight(i, j)));
				}
			}
			
			Collections.sort(edgeList);
			
			initPresents();
			double minWeight = 0;
			int cnt = 0;
			
			for (Edge e : edgeList) {
				if (find(e.from) != find(e.to)) {
					union(e.from, e.to);
					minWeight += e.weight;
					cnt++;
				}
				
				if (cnt > islandN) {
					break;
				}
			}
			sb.append("#").append(testcase).append(" ");
			sb.append(Math.round(minWeight * E)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
