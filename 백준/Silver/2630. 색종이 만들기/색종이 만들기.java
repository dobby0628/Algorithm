/*
 * # 문제 이해
 * 정원 N*N 크기
 * 한 변의 길이가 1인 정사각형 타일이 바닥에 깔려 있음
 * 각 칸은 현재 정상(0) 손상 (1)
 * 
 * 일정한 규칙에 따라 나누어 수리하려고 한다
 * 1. 현재 확인한 정사각형의 공간이 모두 손상됐거나, 모두 정상인 상태가 아니라면 정확히 네 개의 같은 크기의 정사각형으로 나눈다.
 * 2. 나눈 영역을 확인하여 모두 정상이라면 -> 정상 영역으로 정한다
 * 3. 나눈 영역을 확인하여 모두 손상이라면 -> 손상 영역으로 정한다
 * 
 * 정상 영역의 개수와 손상 영역의 개수를 구하는 프로그램을 작성하라
 * 
 * # 입력
 * 첫째줄 N (2, 4, 8, 16, 32, 64, 128 중 하나)
 * 이어서 타일의 상태 공백 구분하여 주어짐
 * 
 * # 출력
 * 첫째 줄에 정상 영역의 개수 출력
 * 둘째 줄에 손상 영역의 개수 출력
 * 
 * # 문제 풀이
 * 이진 탐색
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static int[] cnt = new int[2];
	static int[] result = new int[2];

	static void calc(int x1, int y1, int x2, int y2) {
		int total = (x2 - x1 + 1) * (y2 - y1 + 1);
		int[] c = new int[2];
		for (int x = x1; x <= x2; x++) {
			for (int y = y1; y <= y2; y++) {
				c[map[x][y]]++;
				if (c[0] > 0 && c[1] > 0) {
					check(x1, y1, x2, y2);
					return;
				}
			}
		}
		
		if (c[0] == total)  {
			result[0]++;
			cnt[0] -= total;
		}
		else if (c[1] == total) {
			result[1]++;
			cnt[1] -= total;
		}
	}
	
	static void check(int sx, int sy, int ex, int ey) {
		// 1번째 박스
		calc(sx, sy, sx + (ex - sx)/2, sy + (ey - sy)/2);
		if (cnt[0] == 0 && cnt[1] == 0)
			return;
		// 2번째 박스
		calc(sx, sy + (ey - sy)/2 +1, sx + (ex - sx)/2, ey);
		if (cnt[0] == 0 && cnt[1] == 0)
			return;
		// 3번째 박스
		calc(sx + (ex - sx)/2 +1, sy, ex, sy + (ey - sy)/2);
		if (cnt[0] == 0 && cnt[1] == 0)
			return;
		// 4번째 박스
		calc(sx + (ex - sx)/2 +1, sy + (ey - sy)/2 +1, ex, ey);
		if (cnt[0] == 0 && cnt[1] == 0)
			return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cnt[map[i][j]]++;
			}
		}
		
		// 전체가 0 또는 1이라면
		if (cnt[0] == n*n) {
			result[0] = 1;
			result[1] = 0;
		}
		else if (cnt[1] == n*n) {
			result[0] = 0;
			result[1] = 1;
		}
		// 손상된 타일이 1개라도 있으면 일단 4개로 쪼개기
		else if (cnt[1] > 0) {
			check(1, 1, n, n);
		}

		sb.append(result[0]).append("\n").append(result[1]).append("\n");
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
