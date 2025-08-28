/*
 * 기타 레슨
 * # 문제 풀이
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		int max = 0, sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}
		
		int start = max, end = sum;
		while (start <= end) {
			int mid = (start + end) /2;
			int s = 0;
			int c = 0;
			for (int i = 0; i < n; i++) {
				if (s + arr[i] > mid) {
					c++;
					s = 0;
				}
				s += arr[i];
			}
			if (s != 0)
				c++;
			if (c > m)
				start = mid +1;
			else
				end = mid -1;
		}
		System.out.println(start);
	}
}
