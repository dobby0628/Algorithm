import java.util.Scanner;

/*
 * # 문제 정의
 * 정수 N은 몇 개의 "연속된" 정수의 합으로 나타낼 수 있다
 * 
 * 예) 15 : 15 | 7+8 | 4+5+6 | 1+2+3+4+5
 * 
 * # 문제 풀이
 * 같은 방향 투포인터
 * 
 * # 시간복잡도 O(N)
 * 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int start = 1, end = 1, result = 0;
		int sum = 1;
		while (start <= N && end <= N) {
			// 구간합이 목표와 같을 때 : start를 올려서 그 다음 구간합을 구할 수 있게 만든다
			if (sum == N) {
				//System.out.println(start + "," + end + " : " + sum);
				result++;
				sum -= start;
				start++;
			}
			// 구간합이 목표보다 작을 경우 : 합이 더 커져야하므로 end를 올린다.
			else if (sum < N) {
				end++;
				sum += end;
			}
			// 구간합이 목표보다 클 경우 : 합이 작아져야하므로 start를 올린다.
			else if (sum > N) {
				sum -= start;
				start++;
			}
		}

		System.out.println(result);
	}
}
