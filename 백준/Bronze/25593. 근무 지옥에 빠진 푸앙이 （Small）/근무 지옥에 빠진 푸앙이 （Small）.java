import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		// 주의 개수 n 입력 (1~50 사이의 수 가능)
		int week = Integer.parseInt(br.readLine());
		
		// <근무자, 근무시간> 저장할 해시 선언
		HashMap<String, Integer> work = new HashMap<String, Integer>(); 
		int[] w_time = {4, 6, 4, 10};
		StringTokenizer st;
		
		// 주차별 근무표 입력
		for (int i=0; i<week; i++) {
			// 4개의 시간대 근무자 입력받기
			for (int j=0; j<4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k=0; k<7; k++) {
					String name = st.nextToken();
					
					// 근무자가 없을 경우
					if (name.equals("-"))
						continue;
					// 근무자가 있지만 처음일 경우 생성
					if (!work.containsKey(name))
						work.put(name, 0);
					// 근무 시간 추가
					work.put(name, work.get(name) + w_time[j]);
				}
			}
		}
		
		// 근무자가 1명도 없었다면
		if (work.size() == 0)
			sb.append("Yes");
		else {
			// 입력받은 값으로 근무표 공평 여부 체크하기
			List<Integer> e_time = new ArrayList<>(work.values());
			Collections.sort(e_time);
			if (e_time.get(e_time.size()-1) - e_time.get(0) <= 12)
				sb.append("Yes");
			else
				sb.append("No");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
