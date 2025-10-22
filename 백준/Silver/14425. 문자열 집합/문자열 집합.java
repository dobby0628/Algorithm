/*
 * [문자열 집합]
 * 
 * # 문제 이해
 * n개의 문자열로 이루어진 집합 s가 주어짐
 * 입력으로 주어지는 m개의 문자열 중에서 집합 s에 포함되어 있는 것이 총 몇 개인지 구하시오
 * 
 * # 문제 풀이
 * 트라이 알고리즘 사용하여 풀이
 * -> 시간초과 소문자로만 이루어진 문자열이므로 hashset으로 풀이 가능 또는 배열기반 트라이 사용 가능
 */

import java.io.*;
import java.util.*;

import javax.swing.InputMap;

public class Main {
	class Node {
		Map<Character, Node> child = new HashMap<>();
		int passCount;
		int endCount;
	}
	
	private final Node root = new Node();
	
	public void insert(String word) {
		Node cur = root;
		cur.passCount++;
		
		for (char c : word.toCharArray()) {
			if (!cur.child.containsKey(c)) {
				cur.child.put(c, new Node());
			}
			cur = cur.child.get(c);
			cur.passCount++;
		}
		cur.endCount++;
	}
	
	public boolean search(String word) {
		Node node = findNode(word);
		return node != null && node.endCount > 0;
	}
	
	private Node findNode(String s) {
		Node cur = root;
		
		for (char c : s.toCharArray()) {
			cur = cur.child.get(c);
			if (cur == null) return null;
		}
		return cur;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
//		
//		B14425 trie = new B14425();
		int answer = 0;
//		
//		for (int i = 1; i <= n; i++) {
//			trie.insert(br.readLine());
//		}
//		
//		for (int i = 1; i <= m; i++) {
//			if (trie.search(br.readLine()) == true)
//				answer++;
//		}
//		

		
		HashSet<String> union = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			union.add(br.readLine());
		}
		
		for (int i = 1; i <= m; i++) {
			if (union.contains(br.readLine()))
				answer++;
		}
		System.out.println(answer);
	}
	
}
