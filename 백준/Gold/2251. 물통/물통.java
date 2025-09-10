import java.io.*;
import java.util.*;

public class Main {
	static class abc {
		int a;
		int b;
		int c;
		public abc(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int aFull = Integer.parseInt(st.nextToken());
		int bFull = Integer.parseInt(st.nextToken());
		int cFull = Integer.parseInt(st.nextToken());
		
		// a,b,c 방문 여부 확인
		boolean[][][] visited = new boolean[201][201][201];
		TreeSet<Integer> answerList = new TreeSet<>();
		
		Queue<abc> q = new LinkedList<>();
		q.add(new abc(0, 0, cFull));
		
		while (!q.isEmpty()) {
			abc now = q.poll();
			int a = now.a;
			int b = now.b;
			int c = now.c;
			
			if (visited[a][b][c]) continue;
			
			visited[a][b][c] = true;
			
			if (a == 0) answerList.add(c);
			
			// 물 옮기기
			// a -> b
			// b의 물이 넘치면 -> 넣을 수 있는 만큼만 옮기기
			if (a + b >= bFull)
				q.add(new abc(a - (bFull - b), bFull, c));
			else
				q.add(new abc(0, a+b, c));
			// a -> c
			if (a + c >= cFull)
				q.add(new abc(a - (cFull - c), b, cFull));
			else
				q.add(new abc(0, b, a+c));
			// b -> a
			if (a + b >= aFull)
				q.add(new abc(aFull, b - (aFull - a), c));
			else
				q.add(new abc(a+b, 0, c));
			// b -> c
			if (b + c >= cFull)
				q.add(new abc(a, b - (cFull - c), cFull));
			else
				q.add(new abc(a, 0, b+c));
			// c -> a
			if (c + a >= aFull)
				q.add(new abc(aFull, b, c - (aFull - a)));
			else
				q.add(new abc(a+c, b, 0));
			// c -> b
			if (c + b >= bFull)
				q.add(new abc(a, bFull, c - (bFull - b)));
			else
				q.add(new abc(a, b + c, 0));
		}
		
		for (int i : answerList)
			sb.append(i).append(" ");
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
