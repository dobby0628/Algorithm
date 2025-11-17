/*
 * [나무 자르기]
 * 
 * # 문제 이해
 * 나무 m미터가 필요함
 * 
 * - 목재 절단기 동작 방법
 * 절단기 높이 h 지정해야함
 * 높이를 지정하면 톱날이 땅으로부터 h미터 위로 올라간다.
 * 그 다음, 한 줄에 연속해있는 나무를 모두 절단해버림
 * 따라서, 높이가 h보다 큰 나무는 h 위의 부분이 잘릴 것이고,
 * 낮은 나무는 잘리지 않을 것이다.
 * 
 * 예를 들어, 한줄에 연속해있는 나무의 높이가 20,15,10,17 일 때,
 * 상근이가 높이를 15로 지정하면
 * 나무를 자른 뒤의 높이는 15,15,10,15가 될 것이고,
 * 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다(총 7미터 가지고 감)
 * 절단기 설정 높이는 양의 정수 또는 0임
 * 
 * 나무를 필요한 만틈만 집으로 가져가려고 할때,
 * 이때, 적어도 m미터의 나무를 집에 가져가지 위해 절단기에 설정할 수 있는 
 * 높이의 최댓값을 구하는 프로그램
 * 
 * # 문제 풀이
 * 이진탐색
 * start=0, end=나무 길이 중 최댓값
 * 이진탐색으로 오면서 절단기에 설정할 수 있는 높이의 최댓값 구하기
 *
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long[] trees = new long[(int)n];
		
		long start = 0;
		long end = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			end = Math.max(end, trees[i]);
		}
		
		long mid = 0;
		long answer = 0;
		
		while (start <= end) {
			mid = (start + end) /2;
			
			//System.out.printf("start:%d, mid:%d, end:%d\n", start, mid, end);
			
			long cnt = 0;
			for(long tree : trees) {
				if (tree >= mid)
					cnt += tree - mid;
			}
			
			//System.out.println(cnt);
			
			// 정답 최댓값 구하기
			if (cnt >= m) {
				answer = Math.max(answer, mid);
			}
			
			//System.out.printf("answer:%d, cnt:%d\n\n", answer, cnt);
			
			// 이진탐색
			if (cnt >= m) {
				start = mid +1;
			}
			else {
				end = mid -1;
			}
		}
		
		System.out.println(answer);
	}
}
