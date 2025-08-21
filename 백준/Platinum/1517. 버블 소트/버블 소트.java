/*
 * # 문제 이해
 * N 개의 수로 이루어진 수열 A가 있음
 * 이 수열에 대해서 버블 소트를 수행할 때 swap이 총 몇 번 발생하는지 알아내는 프로그램 작성하기
 * 
 * # 문제 풀이
 * 버블 정렬로 진행하면서 swap의 개수 세기 -> 시간복잡도 n^2으로 불가
 * 병합 정렬로 진행하면서 뒤 배열의 값을 넣을 때 swap이 일어났다고 가정하고
 * result에 차이를 저장한다
 * 
 * # 틀린 이유
 * 1) result 의 값이 정수값을 넘어갈 수 있어 long으로 변경해야함
 * 2) result를 구할 때 왼쪽에 남은 개수를 구해야하므로
 * r_i - o_i 가 아닌 mid -1 - l_i +1 이다
 */

import java.io.*;
import java.util.*;

public class Main {
	static long result;
	public static void mergeSort(int[] arr, int start, int end) {
		if (end - start  < 1) return;
		
		int mid = (start + end) /2;
		
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		
		merge(arr, start, mid, end);
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		int[] output = new int[end - start +1];
		int l_i = start, r_i = mid+1, o_i = 0;
		
		while (l_i <= mid && r_i <= end) {
			// 뒤에 있는 값이 더 작아 선택할 때
			// swap이 일어났다고 가정하고, 현재 남아 있는 앞쪽 데이터 개수만큼 결과값에 더함
			if (arr[l_i] > arr[r_i]) {
				output[o_i++] = arr[r_i++];
				result += mid - l_i + 1;
			}
			else output[o_i++] = arr[l_i++];
		}
		
		while (l_i <= mid) output[o_i++] = arr[l_i++];
		while (r_i <= end) output[o_i++] = arr[r_i++];
		
		for (int i = 0; i < output.length; i++)
			arr[start+i] = output[i];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열의 개수 및 배열의 값 입력받기
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		result = 0;
		mergeSort(arr, 0, N-1);
		System.out.println(result);
	}
}
