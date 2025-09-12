/*
 * 준규가 가지고 있는 동전은 총 n종류
 * 가치의 합을 k로 만드려고 한다
 * 동전 개수의 최솟값을 구하는 프로그램
 * 
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int coinN = Integer.parseInt(st.nextToken());
		int coinSum = Integer.parseInt(st.nextToken());
		
		int[] coinKind = new int[coinN];
		
		for (int i = 0; i < coinN; i++)
			coinKind[i] = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = coinN-1; i >= 0; i--) {
			if (coinSum >= coinKind[i]) {
				cnt += coinSum / coinKind[i];
				coinSum = coinSum % coinKind[i];
			}
		}
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
