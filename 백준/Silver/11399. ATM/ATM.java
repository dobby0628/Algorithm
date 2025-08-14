/*
 * # 문제 이해
 * ATM 1대 
 * N명 줄 섬 1~ N 번호 주어짐
 * i번 사람이 인출하는데 걸리는 시간 p_i분
 * 
 * 모든 사람이 돈을 뽑을 때 걸리는데 필요한 시간의 합의 최솟값 구하기
 * 
 * # 문제 풀이
 * 
 * p를 오름차순으로 정렬하여 누적합의 합을 구하면 됨
 * 삽입 정렬로 풀어보기
 * 
 * # 입력
 * N(1 ≤ N ≤ 1,000)
 * P(1 ≤ Pi ≤ 1,000)
 * 
 * # 시간복잡도
 * 최대값이 적어 O(n^2)도 상관없음
 * 
 * 
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int person = Integer.parseInt(br.readLine());
		
		int[] arr = new int[person];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < person; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		insertionsort(arr);
		
		// 누적 시간 합 구하기
		int sum = 0;
		for (int i = 0; i < person; i++) {
			sum += arr[i] * (person - i);
		}
		System.out.println(sum);
	}
	
	public static void insertionsort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i -1;
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
}
