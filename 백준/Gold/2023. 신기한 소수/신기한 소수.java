import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 
 * # 문제 이해
 * N 자리수가 주어질 때
 * N 자리의 숫자 중 신기한 소수인 숫자를 모두 출력하기
 * 
 * - 신기한 소수
 * 7331
 * 733 도 소수
 * 73 도 소수
 * 7도 소수
 * 
 * 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수인 수 : 신기한 소수
 * 
 * # 문제 풀이
 * dfs로 자리수가 올라갈때마다 재귀로 돌림
 */
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	static boolean primeCheck(int num) {
		int cnt = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) cnt++;
			if (cnt >= 3) return false;
		}
		if (cnt == 2) return true;
		else return false;
	}
	
	static void dfs(int index, int before) {
		if (index > N)  {
			sb.append(before).append("\n");
			return;
		}
		for (int i = 1; i <= 9; i++) {
			int num = before * 10 + i;
			if (primeCheck(num)) {
				dfs(index +1, num);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		dfs(1, 0);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
