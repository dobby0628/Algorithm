/*
 * # 문제 요약
 * 비상연락망과 연락을 시작하는 당법에 대한 정보가 주어질 때,
 * 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하는 함수를 작성하시오.
 * 
 * 연락을 받지 못하는 사람 생길 수 있음
 * 
 * # 제약 사항
 * 연락 인원 최대 100명
 * 부여될 수 있는 번호 1 <= p <= 100
 * 중간 중간 비어있는 번호가 있을 수 있음
 * 
 * # 문제 풀이
 * 연락할 수 있는 가까운 사람들의 연락 순서가 동일하므로 bfs로 풀이함
 * 
 * - 고민할 사항
 * priorityQueue를 활용한 bfs로 가까운 곳부터 그래프 돌기
 * 돌면서 정답을 찾아나감
 * Person 클래스를 만들어서 compareTo 함수를 이용해
 * 정답을 저장해나가면서 bfs를 돌리면 정답 완성
 */

import java.io.*;
import java.util.*;

class Person implements Comparable<Person>{
	int pNum;
	int rank;
	public Person(int pNum, int rank) {
		super();
		this.pNum = pNum;
		this.rank = rank;
	}
	
	@Override
	public int compareTo(Person o) {
		// pNum 오름차순 rank도 오름차순 정렬
		if (this.rank == o.rank)
			return Integer.compare(this.pNum, o.pNum);
		else
			return Integer.compare(this.rank, o.rank);
	}

	@Override
	public String toString() {
		return "Person [pNum=" + pNum + ", rank=" + rank + "]";
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			st = new StringTokenizer(br.readLine());
			int person_n = Integer.parseInt(st.nextToken()) /2;
			int start_person = Integer.parseInt(st.nextToken());
			
			List<List<Integer>> graph = new ArrayList<>(person_n);
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < person_n; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			int graph_i = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < person_n; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int real_index = -1;
				if (map.containsKey(from)) {
					real_index = map.get(from);
				}
				else {
					map.put(from, graph_i);
					real_index = graph_i;
					graph_i++;
				}
				graph.get(real_index).add(to);
				if (!map.containsKey(to))
					map.put(to, graph_i++);
			}
			
			PriorityQueue<Person> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[person_n];
			
			// hashmap에 매핑해놓은 graph의 인덱스 값
			Person newP = new Person(start_person, 0);
			pq.offer(newP);
			visited[map.get(start_person)] = true;
			Person answer = newP;

			while (!pq.isEmpty()) {
				Person parent = pq.poll();
				for (int n : graph.get(map.get(parent.pNum))) {
					// 방문한 적이 없으면 큐에 넣기
					int presnet_i = map.get(n);
					if (!visited[presnet_i]) {
						Person p = new Person(n, parent.rank +1);
						pq.offer(p);
						visited[presnet_i] = true;
						if (answer.compareTo(p) < 0)
							answer = p;
					}
				}
			}
			
			sb.append("#");
			sb.append(testcase);
			sb.append(" ");
			sb.append(answer.pNum);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
