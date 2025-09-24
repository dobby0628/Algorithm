import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] color = new int[m];
        int total = 0;
        for (int i = 0; i < m; i++) {
            color[i] = Integer.parseInt(st.nextToken());
            total += color[i];
        }
        int k = Integer.parseInt(br.readLine().trim());

        double ans = 0.0;
        for (int a : color) {
            if (a < k) continue;
            double p = 1.0;
            for (int t = 0; t < k; t++) {
                p *= (double)(a - t) / (double)(total - t);
            }
            ans += p;
        }

        // 출력 형식은 보통 충분한 소수점 자리수면 통과됩니다.
        System.out.printf("%.9f%n", ans);
    }
}
