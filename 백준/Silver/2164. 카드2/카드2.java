import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 카드 개수 입력받기
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		
		// 카드 큐에 순서대로 집어넣기
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		// 카드 1장 버리고 그 다음카드 아래로 내리기 until 1장 남을 때까지
		// 1장 남은 카드 출력하기
		while (q.size() > 1) {
			q.poll();
			if (q.size() == 1)
				break;
			q.offer(q.poll());
		}
		System.out.println(q.poll());
	}
}
