/*
 * 여행 가자
 * 
 * # 문제 이해
 * 도시 n개
 * 
 * 임의의 두 도시 사이에 길이 있을 수도 없을 수도
 * 
 * 여행 경로가 주어졌을 때 여행 계획대로 방문 가능한지 판단하는 프로그램
 * 
 * # 문제 풀이
 * bfs도 가능 하지만 시간복잡도에서 걸릴듯.... 계산 안해봄
 */

import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
	static int find(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			parent[b] = a;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int cityN = Integer.parseInt(br.readLine());
		int visitCityN = Integer.parseInt(br.readLine());
		
		parent = new int[cityN +1];
		for (int i = 0; i <= cityN; i++)
			parent[i] = i;
		
		// 도시간 연결 여부 확인하여 합집합으로 만들기
		for (int i = 1; i <= cityN; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int city = 1; city <= cityN; city++) {
				int relation = Integer.parseInt(st.nextToken());
				if (relation == 1) {
					union(i, city);
				}
			}
		}
		
		// 여행 경로 받으면서 합집합에 속해있는지 확인하기
		st = new StringTokenizer(br.readLine());
		int[] travelPath = new int[visitCityN];
		for (int i = 0; i < visitCityN; i++) {
			travelPath[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean result = true;
		for (int i = 1; i < visitCityN; i++) {
			int a = find(travelPath[i-1]);
			int b = find(travelPath[i]);
			
			if (a == b) continue;
			else {
				result = false;
				break;
			}
		}
		if (result) System.out.println("YES");
		else System.out.println("NO");
	}
}
