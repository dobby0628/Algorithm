/*
 *  # 문제 이해
 *  재료는 각각 고유한 번호를 가지고 있음
 *  갑옷은 두 개의 재료로 만듦 -> 고유한 번호를 합쳐 M이 되면 갑옷이 생성됨
 *  본인이 가진 재료로 몇 개나 만들 수 있는지 궁금해짐
 *  
 *  N개의 재료로 M을 몇개 만들 수 있는지
 *  
 *  # 문제 풀이
 *  투포인터 사용
 *  
 *  # 시간복잡도 O(N)
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int material_n = Integer.parseInt(br.readLine());
		int material_sum = Integer.parseInt(br.readLine());
		
		List<Integer> material = new ArrayList<>(material_n);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < material_n; i++)
			material.add(Integer.parseInt(st.nextToken()));
		
		// 투포인터 사용을 위해 정렬하기
		Collections.sort(material);
		
		int start = 0 , end = material_n -1, result = 0;
		
		while (start < end) {
			int sum = material.get(start) + material.get(end);
			if (sum == material_sum) {
				result++;
				start++;
				end--;
			}
			else if (sum > material_sum) {
				end--;
			}
			else if (sum < material_sum) {
				start++;
			}
		}
		bw.write(Integer.toString(result));
		bw.flush();
		br.close();
		bw.close();
	}
}
