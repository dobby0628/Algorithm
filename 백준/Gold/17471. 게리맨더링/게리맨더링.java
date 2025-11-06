import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] pop;
    static List<Integer>[] adj;
    static int total;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        pop = new int[N];
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pop[i] = Integer.parseInt(st.nextToken());
            total += pop[i];
        }

        // 입력: i번째 줄 = 연결 개수 k, 이어서 k개의 구역 번호(1-indexed)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int v = Integer.parseInt(st.nextToken()) - 1;
                // 무향 그래프
                adj[i].add(v);
                adj[v].add(i);
            }
        }

        int ALL = (1 << N) - 1;
        int ans = Integer.MAX_VALUE;

        for (int mask = 1; mask < ALL; mask++) {
            int comp = ALL ^ mask;

            // 보완집합과의 중복 절반 컷
            if (mask > comp) continue;

            if (!isConnected(mask)) continue;
            if (!isConnected(comp)) continue;

            int sumA = 0;
            for (int i = 0; i < N; i++) if ((mask & (1 << i)) != 0) sumA += pop[i];

            int diff = Math.abs(total - 2 * sumA);
            if (diff < ans) ans = diff;
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    // mask에 포함된 정점들만으로 연결인지 검사
    static boolean isConnected(int mask) {
        int need = Integer.bitCount(mask);
        if (need == 0) return false;

        // 시작 노드 선택
        int start = -1;
        for (int i = 0; i < N; i++)
            if ((mask & (1 << i)) != 0) { start = i; break; }

        boolean[] vis = new boolean[N];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        vis[start] = true;
        q.add(start);
        int cnt = 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if ((mask & (1 << v)) == 0) continue; // 그룹 외로 이동 금지
                if (vis[v]) continue;
                vis[v] = true;
                q.add(v);
                cnt++;
            }
        }
        return cnt == need;
    }
}
