import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 동전 0
 * # 문제 이해
 * 동전은 총 n 종류, 각각의 동전을 매우 많이 가지고 있음
 * 동전을 적절히 사용해서 그 가치의 합을 k로 만드려고 한다.
 * 이때 필요한 동전 개수의 최솟값을 구하는 프로그램
 * 
 * Ai는 Ai-1의 배수 -> 해당 조건이 있기 때문에 그리디로 풀이 가능
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			dq.addFirst(Integer.parseInt(br.readLine()));
		}
		
		int cnt = 0;
		for (int coin : dq) {
			if (k >= coin) {
				cnt += k / coin;
				k = k % coin;
			}
		}
		System.out.println(cnt);
	}
}
