/*
 * # 문제 이해
 * 토마토는 N*M 격자 상자에 보관됨
 * 
 * 보관 후 하루가 지나면, 익은 토마토의 상하좌우에 있는 익지 않은 토마토가 익음
 * 
 * 며칠이 지나야 다 익는지 최소 일수 구하기
 * 
 * 1 : 익은 토마토
 * 0 : 익지 않은 토마토
 * -1 : 토마토가 없는 칸
 * 
 * # 출력
 * 모두 익을 때까지의 최소 날짜 출력
 * 만약 저장될때부터 모든 토마토가 익어있다면 0 출력
 * 토마토가 모두 익지 못하는 상황이면 -1 출력
 * 
 * # 문제 풀이
 * 1. 토마토의 정보 배열에 받기
 * 
 * 2. BFS로 상하좌우 확인하면서 result+1
 * dx = { 0, 0, -1, +1 }
 * dy = { -1, +1, 0, 0 }
 * priority queue 사용하여 앞에서부터 시작지점의 상하좌우 먼저 탐색
 * 
 * 의문점 : 0이 없다는 사실을 어떻게 판단하는지
 * ㄴ 
 * 
 * 3. while 문으로 0이 없어질 때까지 진행하기
 * 
 * ************************************** 문제 풀이 봄
 * 
 */

import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int M;
	static int[][] box;
	
	public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    
    public static Queue<tomato> queue = new LinkedList<tomato>();
    
	static class tomato {
		int x;
		int y;
		int day;
		
		public tomato(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.offer(new tomato(i,j,0));
                }
			}
		}
		bfs();
	}
	
	public static void bfs() {
		int day = 0;
		
		while (!queue.isEmpty()) {
			tomato t = queue.poll();
			day = t.day;
			
			for (int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (box[nx][ny] == 0) {
						box[nx][ny] = 1;
						queue.add(new tomato(nx, ny, day +1));
					}
				}
			}
		}
		
		if (checkTomato()) {
			System.out.println(day);
		}
		else {
			System.out.println(-1);
		}
	}
	
	static boolean checkTomato() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 0)
                    return false;
                // 덜 익은 토마토가 있다면
            }
        }
        return true;
    }
}
