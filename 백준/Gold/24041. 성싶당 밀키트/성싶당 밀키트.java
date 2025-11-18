import java.util.*;
import java.io.*;
/*
 * 성싶당 밀키트
 * 
 * 재료의 세균 수 : si * max(1, x - li)
 * 
 * 세균수의 합이 g 이하일 때 안심하고 먹을 수 있을 때
 * 중요하지 않은 재료 최대 k
 * 
 * # 문제 풀이
 * 
 * 일수에 따른 세균수가 일정하지 않으므로 계산 필요
 * 그렇다면 계산하는 일수를 줄이기 위해 이분탐색 사용
 * 
 * 최대일수 구하는 방법
 * Si <= G
 * 
 * 1 <= G <= 10^9
 * 
 * 한 재료의 유통기한(l)이 10^9일때
 * 1×(x−10^9)≤10^9⇒x−10^9≤10^9⇒x≤2×10^9
 */

public class Main {
	// 세균 수 구하는 식
	static long bacteriaCalc(long s, long x, long l) {
		return s * Math.max(1, x-l);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int o_cnt = 0;
		
		long[] s = new long[n];
		long[] l = new long[n];
		int[] o = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			s[i] = Long.parseLong(st.nextToken());
			l[i] = Long.parseLong(st.nextToken());
			o[i] = Integer.parseInt(st.nextToken());
			if (o[i] == 1)	o_cnt++;
		}
		
		// 뺄 수 있는 최대 재료 개수 구하기
		if (o_cnt < k)
			k = o_cnt;
		//System.out.println(o_cnt + "," + k);
		
		// 일수 이분탐색
		long start = 1;
		long end = 2_000_000_000L;
		long answer = 0;
		
		while (start <= end) {
			long mid = (start + end) /2;
			
			// mid일자의 세균 수 구하기
			PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
			long bSum = 0;
			for(int i = 0; i < n; i++) {
				long b = bacteriaCalc(s[i], mid, l[i]);
				bSum += b;
				
				if (o[i] == 1)
					pq.add(b);
			}
			
			//System.out.println("before bSum:"+bSum);
			//System.out.println(pq.toString());
			
			// k개 만큼 bSum에서 빼기
			for (int i = 0; i < k; i++) {
				//System.out.println("peek:" + pq.peek());
				bSum -= pq.poll();
			}
			
			//System.out.println("after bSum:"+bSum);
			//System.out.println();
			
			// 이분탐색 조건
			if (g >= bSum) {
				answer = mid;
				start = mid +1;
			}
			else {
				end = mid -1;
			}
		}
		System.out.println(answer);
	}
}
