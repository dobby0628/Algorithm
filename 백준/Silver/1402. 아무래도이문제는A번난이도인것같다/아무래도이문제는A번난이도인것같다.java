/*
 * [아무래도이문제는A번난이도인것같다]
 * 
 * # 문제 이해
 * 정수 A가 있으면 그 수를 A = a1 * a2 * a3 * ... * an으로 했을 때
 * A' = a1 + a2 + a3 + ... + an 이 성립하면 "A는 A'로 변할 수 있다.
 * 만약 A' 가 A"로 변할 수 있으면 "A는 A"로 변할 수 있다 라고 한다.
 * 이때 A와 B가 주어지면 A는 B로 변할 수 있는지 판별하시오.
 * 
 * # 문제 풀이
 * A를 소인수분해하기
 * 각각의 인수를 더한 값과 B를 비교했을 때 	같으면 print yes
 * 									다르면 print no
 * 
 * 왜 항상 가능할까? (짧은 증명)

A → 0이 가능

A를 다음처럼 인수분해합니다:
A = A × (−1) × (−1) × 1 × 1 × …

(−1)은 짝수 개 넣으면 곱은 그대로 A이고, 합은
A + (1의 개수) − (−1의 개수)
입니다. (−1)의 개수를 짝수로 크게 잡고, 1의 개수를 적당히 맞추면 합을 0으로 만들 수 있습니다.
즉, A는 0으로 변할 수 있어요.

0 → B가 가능

0 = 0 × B × 1 × 1 × … 로 두면 합은 B가 됩니다.
따라서 0은 임의의 정수 B로 변할 수 있어요.

결론적으로 A → 0 → B 경로가 항상 있으므로, 모든 (A, B)에 대해 정답은 yes입니다.

포인트: ai가 정수 전체라서 1, −1, 0을 활용해 합을 마음대로 만들 수 있다는 게 함정이에요. 그래서 소인수분해나 조합 탐색은 전부 불필요! (문제 제목 그대로 A번 난이도 느낌 😄)
 * 
 * # 예외 사항
 * 소수들의 곱으로만 이루이지지 않고
 * 4 6 등 다양한 숫자의 곱으로 이루어져 그들의 합이 정답이 될 수도 있음
 * 
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			sb.append("yes\n");
			br.readLine();
//			
//			
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			
//			
//			
//			boolean aIsMinus = false;
//			
//			// a의 음수 여부 판단
//			if (a < 0) {
//				aIsMinus = true;
//				a *= -1;
//			}
//			
//			System.out.println(aIsMinus);
//			
//			// A가 가진 소수의 개수파악을 위해 A크기의 배열 선언
//			HashMap<Integer, Integer> aPrime = new HashMap<>();
//			int tmpA = a;
//			int prime = 2;
//			int cnt = 0;
//			while (tmpA > 0) {
//				int quot = tmpA / prime;
//				int remain = tmpA % prime;
//				
//				if (remain == 0) {
//					cnt++;
//					tmpA = quot;
//					continue;
//				}
//				
//				if (cnt != 0) {
//					aPrime.put(prime, cnt);
//					cnt = 0;
//					prime++;
//				}
//				
//				if (tmpA == 1) break;
//			}
//			
//			System.out.println(aPrime);
			
			
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
