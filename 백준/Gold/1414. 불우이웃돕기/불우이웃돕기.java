/*
 * 불우이웃돕기
 * 
 * # 문제 이해
 * n개의 방, 각 방에 모두 한 개의 컴퓨터
 * 각각의 컴퓨터는 랜선으로 연결되어 있다.
 * 컴퓨터 a, b가 있을 때, 
 * ㄴ a와 b가 서로 랜선으로 연결되어 있거나,
 * ㄴ 또 다른 컴퓨터를 통해서 연결이 되어있으면 서로 통신 할 수 있다.
 * 
 * 다솜이는 모든 컴퓨터를 서로 연결되게 하고 싶다
 * 
 * n 개의 컴퓨터가 서로 연결되어 있는 랜선의 길이가 주어질 때,
 * 다솜이가 기부할 수 있는 랜선의 길이의 최대값을 구하는 프로그램
 * 
 * # 문제 풀이
 * 크루스칼 알고리즘 사용
 * 
 * 틀림 : 연결성 판정 방식 잘못됨
 * connect로 연결된 간선의 길이가 0이면 연결이 안되었다고 판단하였으나
 * 정점 3개 중 1-2만 연결되고 3은 연결이 안되었다면 이또한 연결이 안된 걸로 판단해야함
 * 
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
		
		int n = Integer.parseInt(br.readLine());
		
		parent = new int[1+n];
		for (int i = 1; i <= n; i++)
			parent[i] = i;
		PriorityQueue<Line> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= n; i++) {
			String values = br.readLine();
			for (int j = 1; j <= n; j++) {
				char v = values.charAt(j-1);
				int value = 0;
				if (v >= 'a' && v <= 'z')
					value = v - '0' - 48;
				else if (v >= 'A' && v <= 'Z')
					value = v - 38;
				
				if (value > 0)
					pq.add(new Line(i, j, value));
			}
		}
		
		int answer = 0;
		int connect = 0;
		while (!pq.isEmpty()) {
			Line now = pq.poll();
			
			if (now.a == now.b || union(now.a, now.b))
				answer += now.weight;
			else
				connect ++;
		}
		if (connect < n-1)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
}
