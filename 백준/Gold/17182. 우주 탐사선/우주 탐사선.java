import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 시작 행성 (0-index 가정)

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1) 모든 쌍 최단거리 (Floyd–Warshall)
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 2) 비트마스크 DP
        int FULL = (1 << N) - 1;
        int[][] dp = new int[1 << N][N];
        for (int m = 0; m < (1 << N); m++) Arrays.fill(dp[m], INF);

        int startMask = 1 << K;
        dp[startMask][K] = 0;

        for (int mask = 0; mask <= FULL; mask++) {
            for (int u = 0; u < N; u++) {
                if (dp[mask][u] == INF) continue;
                // 다음 방문할 v 선택
                for (int v = 0; v < N; v++) {
                    int bit = 1 << v;
                    if ((mask & bit) != 0) continue; // 이미 방문
                    int nmask = mask | bit;
                    int cand = dp[mask][u] + dist[u][v];
                    if (dp[nmask][v] > cand) {
                        dp[nmask][v] = cand;
                    }
                }
            }
        }

        int ans = INF;
        for (int u = 0; u < N; u++) {
            ans = Math.min(ans, dp[FULL][u]);
        }
        System.out.println(ans);
    }
}
