/*
# 문제 : N과 M(2)
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
- 고른 수열은 오름차순

# 풀이 방법
DFS
*/

import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(0,1);
		
		System.out.print(sb);
	}
}