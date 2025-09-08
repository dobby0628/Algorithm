/*
 * 설탕 배달
 * # 문제 이해
 * 상근이는 설탕을 정확하게 n킬로그램 배달해야 함
 * 3키로 봉지와 5키로 봉지에 담겨있음
 * 
 * 최대한 적은 봉지를 들고 가려고 한다
 * 
 * 18키로그램 설탕을 배달해야 할 때
 * 1. 3키로 * 6 => 6
 * 2. 5키로 * 3 + 3키로 * 1 => 4 (정답)
 * 
 * 설탕 키로 수가 주어졌을 때, 최소 봉지 개수 구하는 프로그램
 * 
 * # 예외
 * 만약, 정확하게 N키로그램을 만들 수 없다면 -1 출력
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		int quot5 = n / 5;
		int remain5 = n % 5;
		
		// 5로 나누어 떨어지는 경우
		if (remain5 == 0) cnt = quot5;
		// 5로 나누어 떨어지지 않는 경우
		else {
			int quot3 = remain5 / 3;
			int remain3 = remain5 % 3;
			// remain%3 == 0인 경우
			if (remain3 == 0)
				cnt = quot5 + quot3;
			// remain%3 == 1인 경우
			else if (remain3 == 1) {
				// quot5 > 0 라면
				if (quot5 > 0)
					cnt = quot5 -1 + quot3 + 2;
				// quot5 > 0 아니라면 3의 배수도 안되므로 -1
				else
					cnt = -1;
			}
			// remain%3 == 2인 경우
			else if (remain3 == 2)
				// quot5 > 1 라면
				if (quot5 > 1)
					cnt = quot5 -2 + quot3 + 4;
				else
					cnt = -1;
		}
		System.out.println(cnt);
	}
}