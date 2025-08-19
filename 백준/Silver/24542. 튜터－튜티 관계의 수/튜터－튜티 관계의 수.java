/*
 * # 문제 이해
 * 찬솔이가 담당한 반에는 N명의 교육생이 있음
 * 친분 관계를 나타내는 양방향 그래프 획득함
 * 친분 관계는 포레스트 형태임 -> 사이클이 없는 그래프 의미
 * 
 * 튜터-튜티 관계를 구성하고자 함
 * ㄴ 위의 관계는 친분 관계가 있는 사이에서 단방향으로만 가능함
 * 
 * 교육 자료는 튜터 -> 튜티만 전달 가능
 * 찬솔이가 최소한의 튜터에게 자료를 전달하기를 희망함
 * 
 * 위 조건을 만족하면서 교육생 튜터-튜티 관계를 정하는 경우의 수를 1000000007로 나눈 나머지를 출력하자
 * 
 * 경우의 수를 구하는 문제이므로 마지막에 해시맵에 같은 부모의 아이들의 개수를 세어 곱해줌
 * 
 * 
 * # 틀린 후 고친 부분
 * 1. 랭크가 같지 않을 때도 랭크를 올림 -> 비대칭으로 추가됨
 * 		ㄴ 랭크가 같을 때만 랭크를 올려야함
 * 2. result가 int 값을 넘어갈 수도 있음 -> long으로 변경
 * 3. 해시맵에 키를 추가할 때 parent[x] 가 아닌 find(x)로 수행해야 중복을 없앨 수 있음
 * 4. union 함수에서 두 수의 루트가 같다면 이미 같은 집합이므로 아무것도 수행해서는 안됨
 */

import java.util.*;
import java.io.*;

public class Main {
	static class UnionFind {
		int[] parent;
		int[] rank;
		
		UnionFind(int n) {
			parent = new int[n+1];
			rank = new int[n+1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}
		
		int find(int x) {
			if (parent[x] == x)
				return x;
			else
				return parent[x] = find(parent[x]);
		}
		
		void union(int a, int b) {
			a = find(a);
			b = find(b);
			
			if (a != b) {
				if (rank[a] > rank[b])
					parent[b] = a;
				else if (rank[a] < rank[b])
					parent[a] = b;
				else {
					parent[b] = a;
					rank[a]++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		UnionFind u = new UnionFind(n);
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			u.union(a, b);
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int x = 1; x <= n; x++) {
			if (!map.containsKey(u.find(x)))
				map.put(u.parent[x], 1);
			else
				map.put(u.parent[x], map.get(u.parent[x])+1);
		}
		
		long result = 1;
		for (int key : map.keySet()) {
			long value = map.get(key);
			result = (result * value) % (long)1000000007;
		}
		
		System.out.println(result);
	}
}
