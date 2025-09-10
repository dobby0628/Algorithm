/*
 * 거짓말
 * 
 * # 문제 이해
 * 사람의 수 n, 파티의 수 m
 * 
 * 이야기의 진실을 아는 사람 주어짐
 * 각 파티에 오는 사람들의 번호 주어짐
 * 
 * 지민이가 거짓말쟁이로 알려지지 않으면서, 과장된 이야기를 할 수 있는 파티 개수의 최대값 구하는 프로그램
 * 
 * # 문제 풀이
 * 유니온파인트로 거짓말을 아는 사람 연결
 * 합집합이라면 false
 * 아니라면 true
 * 
 * 자주 하는 실수
입력 순서에 따라 “먼저 열린 파티에서는 아직 전파 안 됐으니 거짓말 가능”이라고 생각하기 쉽지만, 
이 문제는 시간/순서 개념 없이, “같은 파티로 한 번이라도 연결되면 전부 같은 컴포넌트”로 취급합니다.

 * 우선 파티를 돌리면서 union 하고
 * 이후에 다시 돌리면서 union 여부 확인
 * 
 * # 틀린 이유 : 진실을 아는 그룹과 파티의 사람들을 모두 엮어버림
 */

import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
	static int find(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union (int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			parent[b] = a;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int personN = Integer.parseInt(st.nextToken());
		int partyN = Integer.parseInt(st.nextToken());
		
		parent = new int[personN+1];
		for (int i = 0; i <= personN; i++) {
			parent[i] = i;
		}
		
		// 진실을 아는 사람 정보 입력받아 0과 union하기
		st = new StringTokenizer(br.readLine());

		int trueN = Integer.parseInt(st.nextToken());
		for (int i = 0; i < trueN; i++) {
			union(0, Integer.parseInt(st.nextToken()));
		}
		
		// 파티 정보 받아 union 하기
		List<List<Integer>> partyInfo = new ArrayList<>();
		for (int i = 0; i < partyN; i++) {
			st = new StringTokenizer(br.readLine());
			int partyPerson = Integer.parseInt(st.nextToken());
			List<Integer> list = new ArrayList<>(partyPerson);
			for (int p = 0; p < partyPerson; p++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			partyInfo.add(list);
			
			// 파티 참석자들끼리 연결
			for (int p = 1; p < list.size(); p++)
				union(list.get(0), list.get(p));
		}
		
		// 파티 정보 다시 돌리면서 진실을 아는 사람이 있을 경우 false
		int result = 0;
		
		for (List<Integer> party : partyInfo) {
			boolean info = true;
			
			for (int p : party) {
				if (find(0) == find(p)) {
					info = false;
					break;
				}
			}
			
			if (info) result++;
		}
		
		System.out.println(result);
	}
}
