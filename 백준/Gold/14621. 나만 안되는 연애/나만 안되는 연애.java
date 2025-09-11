/*
 * [나만 안되는 연애]
 * 
 * # 문제 이해
 * 미팅 어플리케이션
 * 대학교 간 도로 데이터 수집하여 만듦
 * 
 * 사심 경로 제공 아래 3가지 특징
 * 1. 남초 대학교와 여초 대학교를 연결하는 도로만 있음
 * 2. 다양한 사람과 만날 수 있도록 어떤 대학교에서든 모든 대학교로 이동이 가능한 경로
 * 3. 경로의 길이는 최단 거리여야 한다.
 * 
 * 주어지는 거리 데이터를 이용하여 사심 경로의 길이를 구해보자
 * 
 * # 문제 풀이
 * 이분 그래프
 * 모든 노드가 연결되어야 함 -> 최단거리로 : mst 크루스칼
 * ㄴ 간선확인 시 두 점의 성별이 다른지 확인 필요
 */

import java.io.*;
import java.util.*;

public class Main {
	static class Line implements Comparable<Line> {
		int from;
		int to;
		int weight;
		public Line(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Line [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Line o) {
			return Integer.compare(this.weight, o.weight);
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int schoolN = Integer.parseInt(st.nextToken());
		int roadN = Integer.parseInt(st.nextToken());
		
		parent = new int[schoolN+1];
		for (int i = 1; i <= schoolN; i++)
			parent[i] = i;
		
		// 학교 성별 입력받기 : M_false, W_ture
		st = new StringTokenizer(br.readLine());
		boolean[] schoolGender = new boolean[schoolN+1];
		for (int i = 1; i <= schoolN; i++) {
			String gender = st.nextToken();
			if (gender.equals("M"))
				schoolGender[i] = false;
			else if (gender.equals("W"))
				schoolGender[i] = true;
		}
		
		PriorityQueue<Line> pq = new PriorityQueue<>();
		for (int i = 0; i < roadN; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.add(new Line(from, to, weight));
		}
		
		int totalDistance = 0;
		int totalCnt = 0;
		while (!pq.isEmpty()) {
			Line now = pq.poll();
			// 학교 성이 다른지 확인
			if (schoolGender[now.from] != schoolGender[now.to]) {
				if (!union(now.from, now.to)) {
					totalDistance += now.weight;
					totalCnt++;
				}
			}
		}
		
		if (totalCnt < schoolN -1)
			System.out.println("-1");
		else
			System.out.println(totalDistance);
	}
}
