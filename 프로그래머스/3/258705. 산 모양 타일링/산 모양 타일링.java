import java.util.*;

class Solution {
    static final int MOD = 10007;

    public int solution(int n, int[] tops) {
        int a = 0; // a[0]
        int b = 1; // b[0]
        for (int i = 1; i <= n; i++) {
            int prevA = a, prevB = b;
            int hasTop = tops[i - 1];

            // a[i] = a[i-1] + b[i-1]
            a = (prevA + prevB) % MOD;

            if (hasTop == 0) {
                // b[i] = a[i-1] + 2*b[i-1]
                b = (prevA + (2 * prevB) % MOD) % MOD;
            } else {
                // b[i] = 2*a[i-1] + 3*b[i-1]
                b = ((2 * prevA) % MOD + (3 * prevB) % MOD) % MOD;
            }
        }
        return (a + b) % MOD;
    }
}
