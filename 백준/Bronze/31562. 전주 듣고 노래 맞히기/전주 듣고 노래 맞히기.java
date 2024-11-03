import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// n(정환이 아는 노래 개수) m(맞출 노래 개수) 입력
		String[] s = br.readLine().split(" ");
		int	n = Integer.parseInt(s[0]);
		int	m = Integer.parseInt(s[1]);

		// 정환이 아는 노래 입력
		String[] sing_len = new String[n];
		String[] sing_name = new String[n];
		String[] sing = new String[n];
		
		for (int i=0; i<n; i++) {
			s = br.readLine().split(" ", 3);
			sing_len[i] = s[0];
			sing_name[i] = s[1];
			sing[i] = s[2].substring(0, 5);
		}
		
		// 노래 입력
		for (int i=0; i<m; i++) {
			int	count = 0;
			int	place = 0;
			String tmp = br.readLine();
			// 노래와 정환이가 아는 노래가 있는지 확인
			for (int j=0; j<n; j++) {
				if (tmp.equals(sing[j])) {
					count++;
					place = j;
				}
			}
			// 결과값 출력
			if (count == 0)
				bw.write("!\n");
			else if (count == 1)
				bw.write(sing_name[place] + "\n");
			else if (count > 1)
				bw.write("?\n");
		}
		bw.flush();
		bw.close();
	}

}
