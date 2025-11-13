/*
 * [가희와 비행기]
 * 
 * # 문제 이해
 * 
 * 
 * # 문제 풀이
 * dp 근데 점화식을 못찾겠음 ㅜㅜ
 * gpt 도움 받았지만 이해는 함
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken()); // 수평 거리
        int m = Integer.parseInt(st.nextToken()); // mod 값
        
        // dp[x][h] = x만큼 이동했을 때 고도 h에 도달하는 경우의 수
        // 고도는 최대 d까지만 의미가 있으므로 d+1 크기로 잡아도 됨
        long[][] dp = new long[d + 1][d + 1];

        dp[0][0] = 1; // 시작: 거리 0, 고도 0

        for (int x = 0; x < d; x++) {
            for (int h = 0; h <= d; h++) {
            	
                if (dp[x][h] == 0) continue;
                //System.out.printf("x:%d, h:%d, value:%d\n", x, h, dp[x][h]);
                long cur = dp[x][h];

                // 위로 올라가기: h -> h+1
                if (h + 1 <= d) {
                    dp[x + 1][h + 1] = (dp[x + 1][h + 1] + cur) % m;
                    
                }

                // 아래로 내려가기: h -> h-1 (단, 음수는 안 됨)
                if (h - 1 >= 0) {
                	if (x + 1 != d && h - 1 == 0) continue;
                    dp[x + 1][h - 1] = (dp[x + 1][h - 1] + cur) % m;
                }
            }
        }
        
//        for (int i = 0; i <= d; i++) {
//        	for (int j = 0; j <= d; j++) {
//        		System.out.printf("(%d, %d)=%d ", i, j, dp[i][j]);
//        	}
//        	System.out.println();
//        }

        // 도착 지점에서 고도 0
        System.out.println(dp[d][0] % m);
	}
}
