import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int repeat = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			String line = null;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				for (int j = 0; j < repeat; j++) {
					sb.append(c);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
