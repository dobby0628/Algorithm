/*
 * # 문제 해석
 * 햄버거 재료 조합하여 칼로리의 제한을 넘지않는 조합 중 가장 높은 점수 합 구하기
 * 
 * # 문제 풀이
 * dfs 백트래킹 사용
 * 
 * # 특이 사항
 * 없음
 * 
 * 
 */
import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int L;
	static int[] point;
	static int[] kcal;
	static boolean[] visited;
	
	static int p_max;
	
	static void dfs(int node) {
		if (node > N) {
			int p_sum = 0, k_sum = 0;
			for (int i = 1; i <= N; i++) {
				if (visited[i]) {
					p_sum += point[i];
					k_sum += kcal[i];
					if (k_sum > L) return;
				}
			}
			p_max = p_sum > p_max? p_sum : p_max;
			return ;
		}
		
		visited[node] = true;
		dfs(node+1);
		
		visited[node] = false;
		dfs(node+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			point = new int[1+N];
			kcal = new int[1+N];
			visited = new boolean[1+N];
			p_max = 0;
			
			for (int m = 1; m <= N; m++) {
				st = new StringTokenizer(br.readLine());
				point[m] = Integer.parseInt(st.nextToken());
				kcal[m] = Integer.parseInt(st.nextToken());
			}
			
			dfs(1);
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			sb.append(p_max);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
