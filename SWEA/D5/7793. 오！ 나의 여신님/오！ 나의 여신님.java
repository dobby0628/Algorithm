/*
 * 오 나의 여신님
 * # 문제 이해
 * 악마 기술 - 악마의 손아귀 : 매초마다 상하좌우 영역 부식시키며 확장해감
 * 
 * n행 m열 로 이루어진 지도 내에서 수연이는 말을 타고 1초에 상하좌우 인접한 칸으로 이동가능
 * 
 * 수연이는 돌  위치 x
 * 악마 돌 위치 x
 * 
 * 수연이는 악마를 피해서 여신이 있는 공간에 도달하고 싶음
 * 
 * 현재 지도가 주어졌을 때, 수연이는 여신님께 최소 시간으로 이동하고 싶음
 * ㄴ 이동 과정에서 악마영역을 가면 안됨
 * 
 * # 입력
 * T : tc 
 * n,m : 행 열
 * 수연이 위치 : s
 * 여신 공간  : d
 * 돌 위치 : x
 * 악마 : *
 * . : 평범한 지역
 * 
 * # 문제 풀이
 * 이차원 배열 + bfs
 */

import java.util.*;
import java.awt.Point;
import java.io.*;

public class Solution {
	// 상하좌우
	static int[] dx = {0, 0, -1, +1};
	static int[] dy = {-1, +1, 0, 0};
	
	static int INF = 1000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			Point d = null;
			// 수연이 큐
			ArrayDeque<Integer> syQ = new ArrayDeque<>();
			ArrayDeque<Integer> sxQ = new ArrayDeque<>();
			
			int[][] suTime = new int[y][x];
			for (int i = 0; i < y; i++)
				Arrays.fill(suTime[i], -1);
			
			// 악마의 영역전개 구하기
			ArrayDeque<Integer> dyQ = new ArrayDeque<>();
			ArrayDeque<Integer> dxQ = new ArrayDeque<>();
			
			int[][] devilArea = new int[y][x];
			for (int i = 0; i < y; i++)
				Arrays.fill(devilArea[i], INF);
			
			char[][] map = new char[y][x];
			for (int yi = 0; yi < y; yi++) {
				String info = br.readLine();
				for (int xi = 0; xi < x; xi++) {
					char c = info.charAt(xi);
					map[yi][xi] = c;
					if (c == 'S') {
						suTime[yi][xi] = 0;
						syQ.addLast(yi); sxQ.addLast(xi);
					}
					else if (c == 'D')
						d = new Point(xi, yi);
					else if (c == '*') {
						devilArea[yi][xi] = 0;
						dyQ.addLast(yi); dxQ.addLast(xi);
					}
						
				}
			}
			
			// bfs를 이용하여 악마 영역전개 시간 구하기
			while (!dyQ.isEmpty() && !dxQ.isEmpty()) {
				int py = dyQ.poll();
				int px = dxQ.poll();
				int time = devilArea[py][px];
				
				// 상하좌우 악마가 번질 수 있는 위치 확인
				for (int i = 0; i < 4; i++) {
					int cx = px + dx[i];
					int cy = py + dy[i];
					
					// map을 나가지 않는다면
					if (cx>=0 && cx<x && cy>=0 && cy<y
							&& devilArea[cy][cx] == INF) {
						char present_c = map[cy][cx];
						// 해당 위치가 d, X가 아니면
						if (present_c != 'D' && present_c != 'X') {
							devilArea[cy][cx] = time+1;
							dyQ.addLast(cy); dxQ.addLast(cx);
						}
					}
				}
			}

			// 수연이의 이동경로 bfs
			int result = -1;
		
			while (!syQ.isEmpty() && !sxQ.isEmpty()) {
				int py = syQ.poll();
				int px = sxQ.poll();

				int su_time = suTime[py][px];
				
				// 상하좌우 수연이가 갈 수 있는 위치 확인
				for (int i = 0; i < 4; i++) {
					int cx = px + dx[i];
					int cy = py + dy[i];
					
					// map 이외 점이라면 넘어가기
					if (cx<0 || cx>=x || cy<0 || cy>=y) continue;
					// 이미 방문한 곳이라면 넘어가기
					if (suTime[cy][cx] > -1) continue;
					// 여신에게 도착했다면 result에 값 저장 후 반복문 끝내기
					
					char pchar = map[cy][cx];
					if (pchar == 'D') {
						result = su_time +1;
						break;
					}
					if (pchar == 'X' || pchar == '*') continue;
					if (devilArea[cy][cx] <= su_time +1) continue;
					syQ.addLast(cy); sxQ.addLast(cx);
					suTime[cy][cx] = su_time +1;
				}
				if (result > -1) break;
			}
			if (result == -1) sb.append("GAME OVER\n");
			else sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
