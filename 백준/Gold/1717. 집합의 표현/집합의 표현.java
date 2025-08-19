/*
 * # 문제 이해
 * 초기에 n+1개의 집합이 있음
 * 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산 수행
 * 
 * 집합을 표현하는 프로그램을 작성하기
 * 
 * # 입력
 * n : 집합의 개수
 * m : 입력으로 주어지는 연산의 개수
 * 
 * - 0 a b -> 합집합 연산
 * a : 포함되어 있는 집합
 * b : b가 포함되어 있는 집합을 합친다는 의미
 * 
 * - 1 a b -> 두 원소가 같은 집합에 있는지 확인하는 연산
 * return 값
 * ㄴ 같은 집합에 포함되면 YES or yes
 * ㄴ 다른 집합이면 NO or no
 * 
 * # 문제 풀이
 * unionfind 알고리즘을 활용하여 집합만들기!!
 * 
 */

import java.util.*;
import java.io.*;

public class Main {
	static class UnionFind {
		int[] parent;
		
		UnionFind(int n) {
			parent = new int[n+1];
			for (int i = 0; i <= n; i++)
				parent[i] = i;
		}
		
		int find(int x) {
			if (parent[x] == x) return x;
			else {
				return parent[x] = find(parent[x]);
			}
		}
		
		void union(int a, int b) {
			a = find(a);
			b = find(b);
			
			if (a != b)
				parent[b] = a;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		UnionFind u = new UnionFind(n);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int division = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch(division) {
			case 0:
				u.union(a, b);
				break;
			case 1:
				a = u.find(a);
				b = u.find(b);
				if (a != b)
					sb.append("NO\n");
				else
					sb.append("YES\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
