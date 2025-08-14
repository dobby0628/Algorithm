/*
 * # 문제 이해
 * n이라는 수가 주어졌을 때 그 수의 각 자리수를 내림차순으로 정렬하기
 * 
 * # 입력
 * 1<= n <= 1,000,000,000 정수 범위 안이므로 int 배열 사용 가능
 * 
 * # 문제 풀이
 * 
 * n 입력받기
 * 
 * n 자리수별로 나눠서 몫을 배열에 넣기
 * 
 * 선택정렬로 정렬하기
 * 
 * # 시간복잡도 O(n^2)
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		int len = s.length();
		
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = s.charAt(i) - '0';
		}
		
		for (int i = 0; i < len-1; i++) {
			int max_i = i;
			for (int j = i+1; j < len; j++) {
				if (arr[max_i] < arr[j])
					max_i = j;
			}
			if (max_i != i) {
				int tmp = arr[i];
				arr[i] = arr[max_i];
				arr[max_i] = tmp;
			}
		}
		for (int n : arr)
			System.out.print(n);
	}
}
