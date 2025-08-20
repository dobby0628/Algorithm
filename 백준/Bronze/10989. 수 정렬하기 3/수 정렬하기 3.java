/*
 * # 문제 이해
 * N개의 수가 주어졌을 때, 오름차순으로 정렬하는 프로그램 작성하기
 * 
 * # 문제 풀이
 * 기수정렬을 이용하여 정렬해보기
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void countingSort(int[] arr, int exp) {
		int arr_len = arr.length;
		int[] output = new int[arr_len];
		int[] digit_count = new int[10];
		
		// 1. digit count 구하기
		for (int i = 0; i < arr_len; i++) {
			int digit = (arr[i] / exp) % 10;
			digit_count[digit]++;
		}
		
		// 2. digit_count 구간합 구하기 ->자리 보존을 위해서
		for (int i = 1; i < 10; i++) {
			digit_count[i] += digit_count[i-1];
		}
		
		// 3. exp 자리에 맞게 정렬하면서 output에 넣기 : 뒤에서부터
		for (int i = arr_len -1; i >= 0; i--) {
			int digit = (arr[i] / exp) % 10;
			output[digit_count[digit] -1] = arr[i];
			digit_count[digit]--;
		}
		
		// 4. 기존 배열에 변경된 내용 수정하기
		for (int i = 0; i < arr_len; i++)
			arr[i] = output[i];
	}
	public static void radixSort(int[] arr, int max) {
		for (int exp = 1; max / exp > 0; exp*=10) {
			countingSort(arr, exp);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		radixSort(arr, max);
		for (int i = 0; i < N; i++)
			sb.append(arr[i]).append("\n");
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
