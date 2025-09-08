/*
 * ATM
 * # 문제 이해
 * ATM 1대 , n명의 사람들이 줄을 서있음
 * 사람은 1 ~ n까지 번호가 매겨져 있고 i번 사람의 소요 시간은 pi분
 * 사람들이 줄을 서는 순서에 따라, 돈을 인출하는 총 시간이 달라지게 된다.
 * 
 * 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램 만들기
 * 
 * # 문제 풀이
 * 앞의 사람의 시간이 짧을수록 뒷사람이 기다리는 시간이 줄어들음
 * 시간순으로 정렬하여 가장 짧은 사람부터 atm 사용하도록 만들기
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] time = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			time[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(time);

		int totalTime = 0;
		int beforeTime = 0;
		for (int i = 0; i < n; i++) {
			totalTime += beforeTime + time[i];
			beforeTime += time[i];
		}
		System.out.println(totalTime);
	}
}
