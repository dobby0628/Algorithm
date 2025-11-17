/*
 * [랜선 자르기]
 * 
 * # 문제 이해
 * 총 n개의 랜선 필요
 * 
 * 오영식은 k개의 랜선 보유, but 길이가 제각각
 * 
 * n개의 같은 길이의 랜선으로 만들고 싶음
 * 
 * k개의 랜선을 잘라서 만들어야 함
 * 
 * 300cm 랜선에서 140cm짜리 랜선을 두 개 잘라내면 20cm 버림
 * 
 * 자를 때 손실 길이 없음
 * 기존의 k개의 랜선으로 n개의 랜선을 만들 수 없는 경우는 없다고 가정하자
 * 자를 때는 cm 단위 정수로 자른다
 * 
 * n개보다 많이 만드는 것도 n개를 만드는 것에 포함됨
 * 
 * 이때, 만들 수 있는 최대 랜선의 길이를 구하는 프로그램
 * 
 * # 문제 풀이
 * 제일 짧은 길이의 랜선 길이 : 최댓값
 * 0 : 최소값으로 하여
 * 중간값 도출
 * 
 * 중간값으로 만든 랜선의 개수 : mid_count
 * 
 * if mid_count < k  => 중간값/2
 * else mid_count >= k => 중간값 + 중간값/2
 * 
 * 이진탐색으로 적정값 찾기
 *
 * # 틀린 이유
 * 1. 범위를 좁혀갈때 start = mid가 아닌 start = mid +1 / end = mid -1로 설정해야 반복문 탈출 가능
 * 2. 랜선 길이의 최대값을 구하는 거기 때문에 end값은 랜선들의 길이 중 max 값으로 정해야함
 * 3. answer 값은 k보다 큰 경우도 포함하여 비교해야함
 * 4. 오버플로우가 날 수 있으므로 long으로 받아야한다 (랜선의 길이는 2^31-1)
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long[] lines = new long[k];
		long start = 1;
		long end = 0;
		
		for (int i = 0; i < k; i++) {
			lines[i] = Long.parseLong(br.readLine());
			end = Math.max(end, lines[i]);
		}
		
		long mid = 0;
		long answer = 0;
		while (start <= end) {
			mid = (start + end) /2;
			
			//System.out.printf("start:%d, mid:%d, end:%d\n", start, mid, end);
			
			long cnt = 0;
			for (long line : lines) {
				cnt += line / mid;
			}
			
			if (cnt >= n) {
				answer = Math.max(answer, mid);
			}
			
			//System.out.printf("랜선의 길이:%d, 랜선의 개수:%d\n\n", mid, cnt);
			
			// 랜선의 개수가 모자랄 경우
			if (n > cnt) {
				end = mid -1;
			}
			else {
				start = mid +1;
			}
		}
		
		System.out.println(answer);
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
