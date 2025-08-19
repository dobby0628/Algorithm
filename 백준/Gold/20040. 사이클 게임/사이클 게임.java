/*
 * # 문제 이해
 * 사이클 게임 : 두 명의 플레이어가 차례대로 돌아가며 진행하는 게임
 * 선 플레이어 : 홀수번째 / 후 플레이어 : 짝수번째
 * 
 * 게임 시작 시
 * 0 ~ n-1까지 고유한 번호가 부여된 평명 상의 점 n개가 주어지며,
 * 이 중 어느 세 점도 일직선 위에 놓이지 않음
 * 
 * 매차례마다 플레이어는 두 점을 선택해서 이를 연결하는 선분을 그음
 * 이전에 그린 선분을 다시 그을 수는 없지만 이미 그린 다른 선분과 교차하는 것은 가능함
 * 
 * 게임을 진행하다가 처음으로 사이클을 완성하는 순간 게임이 종료됨
 * 사이클 c는 플레이어가 그린 선분들의 부분집합으로, 다음 조건을 만족함
 * ㄴ c에 속한 임의의 선분의 한 끝점에서 출발하여 모든 선불을 한 번 씩만 지나서 출발점으로 되돌아올 수 있다.
 * 
 * 문제는 사이클 완성 여부 판단이 어려움
 * 
 * 입력으로 점의 개수 n과 m번째 차례까지의 게임 진행 상황이 주어지면
 * 사이클이 완성 되었는지 판단
 * - 완성 o -> 몇 번째 차례에서 완성되었는지 출력
 * - 완성 x -> 0
 * 
 * # 입력 제한
 * 3 ≤ n ≤ 500,000
 * 3 ≤ m ≤ 1,000,000
 * 
 * # 문제 풀이
 * unionfind로 풀음
 * 
 * union하기 전에
 * 이미 부모가 같다면 그래프가 연결된 상태 -> 종료하면됨
 */

import java.util.*;
import java.io.*;

public class Main {
	
	static class UnionFind {
		int[] parent;
		
		UnionFind(int n) {
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}
		
		int find(int x) {
			if (parent[x] == x) return x;
			else {
				return parent[x] = find(parent[x]);
			}
		}
		
		boolean union(int a, int b) {
			a = find(a);
			b = find(b);
			
			if (a == b) return true;
			else {
				parent[b] = a;
				return false;
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
			
			if (u.union(a, b)) {
				System.out.println(i);
				return ;
			}
		}
		System.out.println(0);
	}
}
