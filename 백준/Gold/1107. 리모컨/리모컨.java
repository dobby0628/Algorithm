import java.io.*;
import java.util.*;

public class Main {

    // 숫자 버튼으로 해당 채널을 누를 수 있는지 검사하고,
    // 가능하다면 누르는 데 필요한 버튼 수(자릿수)를 리턴
    // 불가능하면 0 리턴
    private static int canPress(int channel, boolean[] broken) {
        if (channel == 0) {
            if (broken[0]) return 0;
            return 1; // 0 한 번 누르면 됨
        }

        int len = 0;
        while (channel > 0) {
            int d = channel % 10;
            if (broken[d]) return 0; // 이 숫자 못 씀
            len++;
            channel /= 10;
        }
        return len; // 사용한 자릿수
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int b = Integer.parseInt(st.nextToken());
                broken[b] = true;
            }
        }

        // 1. +, - 만 사용하는 경우
        int answer = Math.abs(target - 100);

        // 2. 숫자 버튼으로 가능한 모든 채널을 다 눌러보기 (0 ~ 999999)
        for (int ch = 0; ch <= 999999; ch++) {
            int len = canPress(ch, broken);  // 이 채널을 숫자로 누르는 데 필요한 버튼 수
            if (len > 0) { // 누를 수 있는 채널만
                int pressCount = len + Math.abs(ch - target); // 숫자 + +/- 이동
                if (pressCount < answer) {
                    answer = pressCount;
                }
            }
        }

        System.out.println(answer);
    }
}
