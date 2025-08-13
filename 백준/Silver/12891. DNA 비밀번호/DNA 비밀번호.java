/*
 *  # 문제 이해
 *  dna 문자열 모든 문자열에 등장하는 문자가 A C G T 인 문자열
 *  
 *  예) ACKA x , ACCA o
 *  
 *  dna 문자열의 부분문자열을 비밀번호로 사용
 *  but,  AAAA와 같은 보안에 취약한 부분문자열이 생성됨
 *  
 *  부분문자열에 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙 생성
 *  
 *  # 입력
 *  임의의 문자열 dna_len 부분문자열의 길이 pw_len
 *  dna str
 *  A C G T가 몇번 이상 등장해야하는지 각각의 숫자 dna_need[]
 *  
 *  # 문제 풀이
 *  슬라이딩 윈도우
 *  문자열을 받은 배열을 pw_len만큼씩 포함된 글자수를 확인하여 가능 여부 판단
 *  
 *  # 시간복잡도 O(n)
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int dna_len = Integer.parseInt(st.nextToken());
		int pw_len = Integer.parseInt(st.nextToken());
		
		char[] dna = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('A', Integer.parseInt(st.nextToken()));
		map.put('C', Integer.parseInt(st.nextToken()));
		map.put('G', Integer.parseInt(st.nextToken()));
		map.put('T', Integer.parseInt(st.nextToken()));
		
		// dna pw_len만큼 반복문 돌면서 ACGT의 개수 확인하기
		HashMap<Character, Integer> acgt_cnt = new HashMap<>();
		acgt_cnt.put('A', 0);
		acgt_cnt.put('C', 0);
		acgt_cnt.put('G', 0);
		acgt_cnt.put('T', 0);
		
		int result = 0;
		for (int i = 0; i <= dna_len - pw_len; i++) {
			// 초기값 세팅
			if (i == 0) {
				for (int j = 0; j < pw_len; j++) {
					acgt_cnt.put(dna[j], acgt_cnt.get(dna[j]) +1);
				}
			}
			// 그 이후부터는 본인 앞의 문자 개수 줄이고 마지막 문자 개수 늘리기
			else {
				acgt_cnt.put(dna[i-1], acgt_cnt.get(dna[i-1]) -1);
				acgt_cnt.put(dna[i+pw_len -1], acgt_cnt.get(dna[i+pw_len -1]) +1);
			}
			
			// 주어진 문자 조건을 충족하는지 판단하기
			if (acgt_cnt.get('A') >= map.get('A')
				&& acgt_cnt.get('C') >= map.get('C')
				&& acgt_cnt.get('G') >= map.get('G')
				&& acgt_cnt.get('T') >= map.get('T'))
				result++;
		}
		System.out.println(result);
	}
}
