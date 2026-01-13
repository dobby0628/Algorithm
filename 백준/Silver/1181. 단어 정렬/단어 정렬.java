/*
 * [단어 정렬]
 * 소문자로 이루어진 n개의 단어가 들어오면 아래와 같은 조건에 따라 정렬
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 * 단, 중복된 단어는 하나만 남기고 제거해야 한다.
 * 
 * # 풀이
 * 클래스 선언 후 
 * 길이과 문자열 요소로 저장
 * priority queue로 정렬하여 출력
 * 
 */

import java.io.*;
import java.util.*;

class Word {
	int len;
	String word;
	
	
	public Word(int len, String word) {
		this.len = len;
		this.word = word;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Word other = (Word) obj;
		return Objects.equals(this.word,  other.word);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Word> words = new PriorityQueue<Word>(
			(a,b) -> {
				if (a.len == b.len) return a.word.compareTo(b.word);
				return Integer.compare(a.len, b.len);
			}
		);
		
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			Word w = new Word(word.length(), word);
			
			if (!words.contains(w))
				words.add(w);
		}
		
		while (!words.isEmpty()) {
			Word m = words.poll();
			sb.append(m.word).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
