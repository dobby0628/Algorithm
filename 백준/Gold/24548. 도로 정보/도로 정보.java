/*
 * [도로 정보]
 * 
 * # 문제 이해
 * 흥미로운 구간 : 길이가 1 이상인 도로 구간 중 그에 속한 모든 물체의 수가 3의 배수인 것을 의미
 * 예시
 * 1. 나무3개, 울타리3개 -> o
 * 2. 나무3개, 울타리2개 -> x
 * 
 * 나무 : T | 잔디 : G | 울타리 : F | 사람 : P
 * 
 * # 문제 풀이
 * 구간합 + 나머지 풀이
 * 길을 지날때마다 모든 물체의 구간합의 나머지 정보를 hashmap에 저장
 * 마지막에 hashmap의 개수를 가지고 개수 구하기
 *
 *
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		String load = br.readLine();
		int[] mod = new int[4];
		int result = 0;
		HashMap<String, Integer> map = new HashMap<>();
		
		for (char c : load.toCharArray()) {
			if (c == 'T') {
				mod[0]++;
				mod[0] %= 3;
			}
			if (c == 'G') {
				mod[1]++;
				mod[1] %= 3;
			}
			if (c == 'F') {
				mod[2]++;
				mod[2] %= 3;
			}
			if (c == 'P') {
				mod[3]++;
				mod[3] %= 3;
			}
			
			if (mod[0] == 0 
				&& mod[1] == 0
				&& mod[2] == 0
				&& mod[3] == 0)
				result++;
			String key = Integer.toString(mod[0])
					+ Integer.toString(mod[1])
					+ Integer.toString(mod[2])
					+ Integer.toString(mod[3]);
			map.put(key, map.getOrDefault(key, 0) +1);
		}

		for (String key : map.keySet()) {
			int value = map.get(key);
			if (value > 1) {
				result += (value * (value -1)) /2;
			}
		}
		System.out.println(result);
		br.close();
	}
}
