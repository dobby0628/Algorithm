/*
 * 대회 or 인턴
 * # 문제 이해
 * 2명의 여, 1명의 남 팀 결성 원칙
 * 
 * n명의 여학생, m명의 남학생이 팀원 찾고 있음
 * k명은 인턴쉽 프로그램 참여해야 함
 * 인턴쉽 o -> 대회 x
 * 
 * n,m,k가 주어질 때 만들 수 있는 최대 팀 수 구하기!!
 * 
 * # 문제 풀이
 * 여/2 > 남 -> 여 - 남*2 = 남은 수 중 k 제외
 * ㄴ k가 없어진다면 남자수만큼 조편성 가능
 * ㄴ k가 남아있다면 남자수만큼의 조 숫자에서 k의 3배수만큼 제외
 * 
 * 여/2 < 남 -> 남 - 여/2 = 남은 수 중 k 제외
 * ㄴ k가 없어진다면 여/2만큼 조편성 가능
 * ㄴ k가 남아있다면 여/2만큼의 조 숫자에서 k의 3배수만큼 제외
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int teamCnt = 0;
		
		if (n/2 >= m) {
			teamCnt = m;
			int girlRemain = n - 2*m;
			
			if (girlRemain < k) {
				int kRemain = k - girlRemain;
				int quot 	= kRemain / 3;
				int remain 	= kRemain % 3;
				
				if (remain == 0)	teamCnt -= quot;
				else				teamCnt -= (quot + 1);
			}
		}
		else {
			teamCnt = n / 2;
			
			int girlRemain = n % 2;
			int boyRemain = m - teamCnt;

			if (girlRemain+boyRemain < k) {
				int kRemain = k - girlRemain - boyRemain;
				int quot 	= kRemain / 3;
				int remain 	= kRemain % 3;
				
				if (remain == 0)	teamCnt -= quot;
				else				teamCnt -= (quot + 1);
			}
		}
		System.out.println(teamCnt);
	}
}
		