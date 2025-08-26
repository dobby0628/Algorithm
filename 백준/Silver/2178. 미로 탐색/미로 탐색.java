/*
 * # 문제 이해
 * n*m 크기의 배열로 표현되는 미로가 있다
 * 미로에서 1 : 이동할 수 있는 칸 / 0 : 이동할 수 없는 칸
 * 1,1에서 출발하여 n,m의 칸 수를 구하는 프로그램을 작성하시오
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동 가능
 * 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다!!
 * 
 * # 문제 풀이
 * bfs로 가까운 곳들을 방문하면서 depth를 기록 마지막 칸에 도달했을 때 depth 출력
 * 
 * # 메모리 초과 난 이유
 * 큐에 해당 점을 넣으면서 방문 표시를 해야하는데 큐에서 꺼낼 때 방문 표시를 하여 그 전에 계속해서 들어감
 */

import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int y;
		int x;
		int depth;
		public Point(int y, int x, int depth) {
			super();
			this.y = y;
			this.x = x;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + ", depth=" + depth + "]";
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[y+1][x+1];
		for (int i = 1; i <= y; i++) {
			String tmp = br.readLine();
			for (int j = 1; j <= x; j++) {
				map[i][j] = tmp.charAt(j-1) - '0';
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(1, 1, 1));
		
		// 상하좌우 기준
		int[] dy = {-1, +1, 0, 0};
		int[] dx = {0, 0, -1, +1};
		
		while (!q.isEmpty()) {
			Point present = q.poll();
			if (present.y == y && present.x == x) {
				System.out.println(present.depth);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int cy = present.y + dy[i];
				int cx = present.x + dx[i];
				
				if (cx > 0 && cx <= x && cy > 0 && cy <= y && map[cy][cx] == 1) {
					map[cy][cx] = 0;
					q.offer(new Point(cy, cx, present.depth +1));
				}
			}
		}
		
		br.close();
	}
}
