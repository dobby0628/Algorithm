/*
 * # 문제 이해
 * n개의 수가 주어졌을 때 오름차순 정렬하는 프로그램 작성
 * 
 * # 입력
 * 1<= n <= 1000
 * 중복 없음
 * 
 * # 구현
 * 버블 정렬 이용해보기
 * 
 * # 시간복잡도 O(n^2)
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		for (int num : arr) {
			sb.append(num);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}

