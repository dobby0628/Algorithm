/*
 * # 문제 이해
 * n이 주어짐
 * 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램
 * 
 * A_i ~ A_j 까지의 구간합이 M으로 나누어 떨어지는 i,j 쌍의 개수를 구해야함
 * 
 * # 입력 개수
 * (1 ≤ N ≤ 10^6, 2 ≤ M ≤ 10^3)
 * (0 ≤ Ai ≤ 10^9)
 * 
 * # 시간 제한 1초
 * 
 * # 문제 풀이
 * n을 입력받는데만 1초가 걸리므로
 * 입력받으면서 정답이 나올 수 있게 끝내야함
 * 
 * 구간합 사용
 * **************** 풀이 보고 이해함
 * 
 * 구간합들을 m으로 나누어 나머지가 되었을 때
 * 나머지가 같은 아이들을 빼면 나머지가 0이 됨
 * 하여 나머지가 같은 아이들의 2개씩 나열 가능한 수를 찾으면 정답 도출
 * 
 * # 시간복잡도 O(n) 상수는 취급하지 않으므로
 * 
 * # 유의할 점
 * 구간합과 결과가 int 범위를 넘어갈 수 있으므로 long으로 처리
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 구간합 구하여 나머지 구하기
		long result = 0;
		long sum = 0;
		long[] remain = new long[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			sum += Long.parseLong(st.nextToken());
			int remainder = (int)(sum % (long)m);
			if (remainder == 0) result++;
			remain[remainder]++;
		}

		for (int i = 0; i < m; i++) {
			if (remain[i] > 1) {
				result += remain[i] * (remain[i] - 1) / 2;
			}
		}
		
		bw.write(Long.toString(result));
		bw.flush();
		br.close();
		bw.close();
	}
}

