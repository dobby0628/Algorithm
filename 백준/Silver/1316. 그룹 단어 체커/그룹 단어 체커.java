/*
 * [그룹 단어 체커]
 * 
 * # 문제 이해
 * 그룹 단어 : 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말함
 * 예를 들어 ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, 
 * kin도 k, i, n 연속으로 나타나기 때문에 그룹 단어이지만,
 * aabbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아님
 * 
 * 단어 n개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 * 
 * # 문제 풀이
 * 들어오는 문자를 저장하기 위한 set 선언
 * 해당 문자가 들어오면 배열 true로 변경
 * 앞 문자 저장해두고 앞문자와 동일하면 pass
 * 앞 문자와 다를 때 해당 소문자가 set에 있다면 연속문자가 아니므로 끝내기
 * 문자열이 다 끝나고 나왔다면  cnt +1
 */

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			Set<Character> character = new HashSet<>();
			char beforeChar = 'A';
			boolean result = true;
			for (char c : str.toCharArray()) {
				if (beforeChar != c) {
					if (character.contains(c)) {
						result = false;
					}
					else {
						character.add(c);
					}
				}
				beforeChar = c;
			}
			if (result) cnt++;
		}
		System.out.println(cnt);
	}
}
