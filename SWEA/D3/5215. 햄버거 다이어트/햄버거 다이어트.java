import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ingredientN = Integer.parseInt(st.nextToken());
			int maxKcal = Integer.parseInt(st.nextToken());
			
			int[] ingredientScore = new int[ingredientN+1];
			int[] ingredientKcal = new int[ingredientN+1];
			
			for (int i = 1; i <= ingredientN; i++) {
				st = new StringTokenizer(br.readLine());
				ingredientScore[i] = Integer.parseInt(st.nextToken());
				ingredientKcal[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[ingredientN+1][maxKcal+1];
			for (int i = 1; i <= ingredientN; i++) {
				int pScore = ingredientScore[i], pKcal = ingredientKcal[i];
				
				for (int kcal = 0; kcal <= maxKcal; kcal++) {
					// kcal 값 중 현재 재료를 안더했을 때 최대값
					dp[i][kcal] = dp[i-1][kcal];
					
					// 지금 kcal가 현재 재료의 칼로리보다 크면(-> 작으면 내 재료를 넣을 수 없음)
					if (kcal >= pKcal) {
						// 내 재료를 안더한 것의 최대값과 내 재료를 더했을 때의 최대값을 비교하여 큰 값 넣기
						dp[i][kcal] = Math.max(dp[i][kcal], dp[i-1][kcal-pKcal] + pScore);
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[ingredientN][maxKcal]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}