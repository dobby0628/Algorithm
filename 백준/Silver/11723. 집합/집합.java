import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String func = st.nextToken();

            switch (func) {
                case "add": {
                    int num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                }
                case "remove": {
                    int num = Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                }
                case "check": {
                    int num = Integer.parseInt(st.nextToken());
                    sb.append(set.contains(num) ? "1\n" : "0\n");
                    break;
                }
                case "toggle": {
                    int num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                }
                case "all":
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        System.out.print(sb);
    }
}