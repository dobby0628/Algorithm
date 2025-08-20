/*
 * # 문제 이해
 * N 길이인 정사각형 모양의 치즈가 있음
 * N*N 칸의 맛있는 정도가 다름
 * 맛있는 정도 1<=taste<=100
 * 
 * 요정은 100일 동안 치즈를 갉아먹음
 * X번째 날에는 맛있는 정도가 X인 칸을 먹음
 * 
 * 치즈 덩어리 : 상하좌우로 인접한 칸들을 하나로 묶어놓은 것을 의미함
 * 
 * 100일 중에서 치즈 덩어리가 가장 많을 때의 덩어리 개수를 구하는 프로그램을 작성하라
 * 
 * # 문제 풀이
 * 칸들에 대한 taste의 값을 받으면서 가장 최대값을 구하기
 * 
 * 1일부터 max일까지 지나면서 해당 일자의 칸은 true로 변경 후
 * 남아 있는 칸들에 대해 bfs로 덩어리 개수 구하기
 * 구한 개수 중 가장 덩어리의 개수가 큰 것 출력하기
 */
import java.io.*;
import java.util.*;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "point [x=" + x + ", y=" + y + "]";
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] taste = new int[N][N];
			int max_day = 0;
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					taste[y][x] = Integer.parseInt(st.nextToken());
					if (max_day < taste[y][x])
						max_day = taste[y][x];
				}
			}

			boolean[][] visited = new boolean[N][N];
			
			// 상하좌우 순서로 진행
			int[] dx = {0, 0, -1, +1};
			int[] dy = {-1, +1, 0, 0};
			
			int answer = 0;
				
			for (int day = 0; day <= max_day; day++) {
				visited = new boolean[N][N];
				
				// 일수에 따라 visited true로 바꾸기
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						if (taste[y][x] <= day)
							visited[y][x] = true;
					}
				}

				int sum = 0;
				// visited 0, 0부터 돌면서 false인 경우 bfs 탐색하여 덩어리 찾아내기
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						if (visited[y][x]) continue;
						else {
							visited[y][x] = true;
							sum++;
							Queue<Point> q = new LinkedList<>();
							q.offer(new Point(x, y));
							
							while (!q.isEmpty()) {
								Point present = q.poll();
								for (int i = 0; i < 4; i++) {
									int cx = present.x+dx[i];
									int cy = present.y+dy[i];
									if (cx>=0 && cx<N
										&& cy>=0 && cy<N) {
										if (!visited[cy][cx]) {
											q.offer(new Point(cx, cy));
											visited[cy][cx] = true;
										}
									}
								}
							}
						}
					}
				}
				if (answer < sum)
					answer = sum;
			}
			sb.append("#");
			sb.append(testcase);
			sb.append(" ");
			sb.append(answer);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
