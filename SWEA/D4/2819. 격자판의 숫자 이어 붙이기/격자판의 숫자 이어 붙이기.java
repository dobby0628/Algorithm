/*
 * 격자판의 숫자 이어 붙이기
 * # 문제 이해
 * 4*4 크기의 격자판
 * 각 칸에는 0~9 사이의 숫자가 적혀 있다
 * 
 * 임의의 위치에서 시작해서, 상하좌우 네방향으로 인접한 격자로 총 여섯 번 이동하면서,
 * 각 칸에 적혀있는 숫자를 차례대로 이어붙이면 7자리의 수가 된다
 * 이동을 할 때에는 한 번 거쳤던 격자칸을 다시 거쳐도 되며, 0으로 시작하는 0102001과 같은 수를 만들 수도 있음
 * 
 * 격자판을 벗어나는 이동은 가능하지 않음
 * 
 * 격자판이 주어졌을 때, 만들 수 있는 서로 다른 일곱 자리 수들의 개수를 구하는 프로그램 작성하기
 * 
 * # 문제 풀이
 * dfs로 모든 경로 탐색하면서 7자리 숫자가 완성되면 set에 저장하여 중복 없애기

 문제 제대로 읽기
 - 이동할때 한 번 거쳤던 칸도 다시 가도 됨
 - 7자리를 만들기 위해 0부터 시작하므로 len==6일때 7자리가 됨
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static Set<Integer> result;
	
	static int[] dx = {-1, +1, 0, 0};
	static int[] dy = {0, 0, -1, +1};
	
	static void dfs(int x, int y, int num, int len) {
		if (len == 6) {
			result.add(num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			// 경계를 벗어나면 넘어가기
			if (cx<0 || cy<0 || cx>=4 || cy>=4) continue;
			dfs(cx, cy, num*10+map[cx][cy], len+1);

		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			// map, visited 선언하기
			map = new int[4][4];
			
			// map 정보 입력받기
			for (int i = 0; i < 4; i++) {
				 st = new StringTokenizer(br.readLine());
				 for (int j = 0; j < 4; j++) {
					 map[i][j] = Integer.parseInt(st.nextToken());
				 }
			}
			
			// 완성된 숫자 저장할 set 선언
			result = new HashSet<>();
			
			// dfs 실행하기 16개의 점이 시작점이 되도록 반복문
			for (int i = 0; i < 4; i++) {
				 for (int j = 0; j < 4; j++) {
					 dfs(i, j, map[i][j], 0);
				 }
			}
			
			System.out.println("#" + tc + " " + result.size());
		}
	}
}
