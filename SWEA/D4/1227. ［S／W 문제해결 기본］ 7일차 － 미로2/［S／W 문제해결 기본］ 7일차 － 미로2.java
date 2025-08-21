/*
 * # 문제 풀이
 * 100 * 100 행렬로 만들어진 미로가 있음
 * 흰색 바탕은 길, 노랑 바탕은 벽
 * 
 * 가장 최상단의 있는 칸은 0,0 기준으로 가로방향을 x, 세로방향을 y 라고 할 때
 * 미로의 시작점은 1,1이고 도착점은 13,13이다
 * 주어진 미로의 출발점에서 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램을 작성하라
 * 
 * 10개의 테스트케이스 주어짐
 * 
 * 1 : 벽
 * 0 : 길
 * 2 : 출발점
 * 3 : 도착점
 * 
 * # 출력
 * 도달 가능 여부
 * 1: 가능함
 * 0: 가능하지 않음
 * 
 * # 문제 풀이
 * dfs로 탐색하면서 도착점에 도달하면 종료
 * 도달하지 않으면 0 출력
 */

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static Point depart;
	static Point arrive;
	static boolean arriveCheck;
	
	// 상하좌우만 갈 수 있음
	static int[] dx = {0, 0, -1, +1};
	static int[] dy = {-1, +1, 0, 0};
	
	public static void dfs(int y, int x) {
		if (arriveCheck) return ;
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			if (cx>=0 && cx<100 && cy>=0 && cy<100) {
				// 도착지점이라면 끝내기
				if (cy == arrive.y && cx == arrive.x) {
					arriveCheck = true;
					return ;
				}
				// 아니라면 방문하지 않은 곳 방문하기
				if (!visited[cy][cx]) {
					dfs(cy, cx);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int T = 1; T <= 10; T++) {
			// 입력값 받기
			T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			visited = new boolean[100][100];
			arriveCheck = false;
			for (int y = 0; y < 100; y++) {
				String s = br.readLine();
				for (int x = 0; x < 100; x++) {
					map[y][x] = s.charAt(x) - '0';
					if (map[y][x] == 1)
						visited[y][x] = true;
					else if (map[y][x] == 2)
						depart = new Point(y, x);
					else if (map[y][x] == 3)
						arrive = new Point(y, x);
				}
			}
			
			// dfs 이용해서 도착지점 도달 가능 여부 판단하기
			dfs(depart.y, depart.x);
			
			bw.write("#");
			bw.write(Integer.toString(T));
			bw.write(" ");
			
			int result = 0;
			
			if (arriveCheck) result = 1;
			bw.write(Integer.toString(result));
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
