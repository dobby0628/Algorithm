import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 단어 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		// 단어 입력
		HashMap<String, String> password = new HashMap<String, String>();
		for (int i=0; i<N; i++) {
			String p = br.readLine();
			StringBuffer rp = new StringBuffer(p);
			password.put(p, rp.reverse().toString());
		}
		
		// 비교
		List<String> reverse = new ArrayList<>(password.values());
		for (String s : reverse) {
			if (password.containsKey(s)) {
				int len = s.length();
				char mid = s.charAt(len / 2);
				sb.append(len).append(" ").append(mid);
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
