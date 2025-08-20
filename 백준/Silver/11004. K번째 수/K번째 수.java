/*
 * # 문제 이해
 * 주어진 N개의 수를 오름차순 정렬 후 K번째 있는 수 출력하기
 * 
 * # 문제 풀이
 * 퀵소트로 정렬 후 K번째 수 출력
 */

import java.io.*;
import java.util.*;

public class Main {
	
	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) return;
		
		int pivot = arr[(start + end) /2];
		int index = partition(arr, start, end, pivot);

		quickSort(arr, start, index-1);
		quickSort(arr, index, end);
	}
	
	public static int partition(int[] arr, int start, int end, int pivot) {
		while (start <= end) {
			while (arr[start] < pivot) start++;
			while (arr[end] > pivot) end--;
			
			if (start <= end) {
				int tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;
				start++;
				end--;
			}
		}
		return start;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		quickSort(arr, 1, N);

		System.out.println(arr[K]);
	}
}
