/*
 *  # 문제 이해
 *  N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타내면 -> 좋다
 *  
 *  N개의 수가 주어질 때 그 중에서 좋은 수의 개수는 몇개인지 출력하라
 *  
 *  수의 위치가 다르면 값이 같아도 다른 수이다.
 *  
 *  # 문제 풀이
 *  투포인트
 *  정렬 후 앞에서부터 비교
 *  
 *  # 유의사항
 *  어떤 수가 2개일 때 자리가 다르면 다른 수로 인식함
 *  두 수를 구할 때 본인은 포함이 되면 안됨!!
 *  Q) 두 수의 합이므로 start가 standard_i를 넘을 수 없지 않나??
 *   -> 음수와 0도 들어올 수 있기 때문에 start < standard_i 로 끝내면 안됨!!
 *  
 *  # 시간복잡도 O(N²)
 *  정렬: Arrays.sort → O(N log N)
 *  바깥 for문: 기준 인덱스 standard_i를 N번 순회 → N
 *  안쪽 투포인터 while문: 매 반복에서 start++ 또는 end-- 중 하나만 일어나서, 각 i에 대해 최대 N번 움직임 → O(N)
 *  전체는 O(N log N + N * N) = O(N²).
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long[] numbers = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(numbers);

		int result = 0;
		
		// 0번  숫자는 찾지 않음 -> 두 수의 합으로 나올 수 없음
		for (int standard_i = 0; standard_i < N; standard_i++) {
			long standard_n = numbers[standard_i];
			int start = 0, end = N-1;
			while (start < end) {
				if (start == standard_i) {
					start++;
					continue;
				}
				if (end == standard_i) {
					end--;
					continue;
				}
				long sum = numbers[start] + numbers[end];
				
				if (sum == standard_n) {
					result++;
					break;
				}
				else if (sum > standard_n) {
					end--;
				}
				else if (sum < standard_n) {
					start++;
				}
			}
		}
		bw.write(Integer.toString(result));
		bw.flush();
		br.close();
		bw.close();
	}
}

