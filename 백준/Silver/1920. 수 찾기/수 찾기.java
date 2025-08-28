/*
 * 수 찾기 
 * # 문제 이해
 * N 개의 정수가 주어져 있을 때 이안에 x라는 정수가 존재하는지 알아내는 프로그램 작성하기
 * 
 * # 문제 풀이
 * 이진탐색으로 풀이해보기
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			sb.append(BinarySearch(x)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	static int BinarySearch(int x) {
		int start = 0;
		int end = n-1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int midV = arr[mid];
			if (x == midV) {
				return 1;
			}
			else if (x < midV) {
				end  = mid -1;
			}
			else {
				start  = mid +1;
			}
		}
		return 0;
	}
}
