/*
 * [두 스택]
 * 
 * # 문제 이해
 * 두 개의 배낭
 * 각 배낭에는 n개의 물건이 들어있음
 * 
 * 첫 번쨰 배낭에는 a1, a2, a3..an의 무게를 가진 물건들이 아래에서 위로 순서대로 쌓여있음
 * an이 맨 위에 있는 물건의 무게
 * 두 번째 배낭도 동일함
 * 
 * 배낭의 무게는 배낭 안에 남은 물건들의 무게의 합으로 정의됨
 * 
 * 원빈이는 최대 k번 두 배낭 중 하나를 선택하여 맨 위에 있는 물건을 없앨 수 있음
 * 물건을 없애면 선택한 배낭의 무게는 없앤 물건의 무게만큼 줄어들며 
 * 선택한 배낭에 물건이 하나도 없으면 아무런 일도 일어나지 않음
 * 
 * 원빈의 행동이 끝난 후, 승형이는 자신이 멜 가방을 결정한다.
 * 승형이는 약삭빠르기 때문에 항상 두 배낭 중 더 가벼운 배낭을 메고 다닌다.
 * 만약 두 배낭의 무게가 같다면 둘 중 아무 배낭이나 메고 다닌다.
 * 원빈이가 들어야 하는 배낭은 승형이가 선택하지 않은 배낭이다
 * 
 * 원빈이가 들어야 하는 배낭의 무게의 최솟값을 구해보자
 * 
 * ## 입력
 * n : 배낭에 들은 물건의 개수
 * k : 물건을 빼는 횟수
 * a 배낭의 물건의 무게
 * b 배낭의 물건의 무게
 * 
 * # 문제 풀이
 * 원빈이는 두 배낭 중 더 무거운 배낭을 들어야 함
 * 근데 그 배낭의 무게의 최솟값을 구해야함
 * 
 * 핵심 풀이 : 어떻게?
 * 1. 그리디 : 국소적으로 최선의 선택이 전체 최적해를 보장하지 않기 때문에 불가능
 * 2. 완탐
 * ㄴ k=3일때
 * a	b
 * 0	3
 * 1	2
 * 2	1
 * 3	0
 * 으로 물건을 뺏을 때 각 배낭의 합을 구하고
 * 해당 합 중 더 높은 무게와 이전의 최솟값을 비교하여 결과 도출하기
 * 
 * 합을 계속 구하지 않도록 누적합으로 구해두고 바로바로 비교하기
 * 
 * 예외1) 만약 n=3 인데 k=10인 경우??
 * ㄴ 2n <= k -> 무조건 배낭의 물건이 모두 사라지므로 결과값은 0
 * 
 * 예외2) n=3 k=5
 * 배낭에서 꺼낼 수 있는 최대는 3인데
 * 제한을 두지 않아 n-a or n-b가 음수가 되면서 ArrayIndexOutOfBounds가 발생
 * ㄴ n-a or n-b가 음수일 경우 continue
 * 
 * 예외3) 누적합이 정수 오버플로우가 나는 경우
 * 3 2
 * 1000000000 1000000000 1000000000
 * 1000000000 1000000000 1000000000
 * 
 * 변수형을 long으로 바꾸기!!
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		
		long[] aSum = new long[(int)n+1];
		long[] bSum = new long[(int)n+1];
		
		// a 배낭의 물건 누적합 구하기
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			aSum[i] = aSum[i-1] + Long.parseLong(st.nextToken());
		}
		// b 배낭의 물건 누적합 구하기
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			bSum[i] = bSum[i-1] + Long.parseLong(st.nextToken());
		}
		
		long result = Long.MAX_VALUE;
		
		// 예외 처리하기 2n <= k
		if (2*n <= k) {
			result = 0;
		}
		else {
			for (long a = 0; a <= k; a++) {
				long b = k-a;
				//System.out.printf("a:%d,b:%d\n", a, b);
				
				if (n-a < 0 || n-b < 0) continue;
				
				long maxValue = Math.max(aSum[(int)(n-a)], bSum[(int)(n-b)]);
				
				result = Math.min(result, maxValue);
				//System.out.println("result:"+result);
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}
