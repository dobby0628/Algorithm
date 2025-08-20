import java.io.*;
import java.util.*;

/*
 * # 문제 이해
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램 작성
 * 
 * # 문제 풀이
 * 병합 정렬 이용하여 문제 풀이해보기
 */



public class Main {
	public static void mergeSort(int[] arr, int start, int end) {
		// 배열의 개수가 1개면 쪼갤 수가 없으므로 종료
		if (start >= end) return;
		
		// 중간 인덱스를 찾아
		int mid = (start + end) /2;
		
		// 쪼개고
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		
		// 병합하면서 정렬하기
		merge(arr, start, mid, end);
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		// 정렬할 배열 선언
		int[] tmp = new int[end-start +1];
		// 왼쪽 그룹의 인덱스 start ~ mid
		int l_i = start;
		// 오른쪽 그룹의 인덱스  mid+1 ~ end
		int r_i = mid+1;
		// 정렬할 배열 tmp의 인덱스
		int t_i = 0;
		
		// 왼쪽 그룹과 오른쪽 그룹 중 1개라도 끝에 도달하면 종료하기
		while (l_i <= mid && r_i <= end) {
			// 왼쪽 그룹 수가 오른쪽 그룹 수보다 작으면 -> 왼쪽의 수를 임시 배열에 먼저 넣음 -> 인덱스 한칸 씩 옮기기
			if (arr[l_i] <= arr[r_i]) tmp[t_i++] = arr[l_i++];
			// 오른쪽 그룹 수가 왼쪽 그룹 수보다 작으면 -> 오른쪽의 수를 임시 배열에 먼저 넣음 -> 인덱스 한칸 씩 옮기기
			else tmp[t_i++] = arr[r_i++];
		}
		
		// 남아 있는 수가 있을 수 있으니 끝까지 도달하도록 반복문 돌리기
		while (l_i <= mid) tmp[t_i++] = arr[l_i++];
		while (r_i <= end) tmp[t_i++] = arr[r_i++];
		
		// 정렬된 임시 배열의 값을 원래 배열로 옮기기
		for (int i = 0; i < tmp.length; i++) {
			arr[start + i] = tmp[i];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		mergeSort(arr, 0, N-1);
		
		for (int n : arr)
			bw.write(n + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
