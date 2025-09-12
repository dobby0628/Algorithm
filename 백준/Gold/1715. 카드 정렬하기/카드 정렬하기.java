/*
 * [카드 정렬하기]
 * 
 * # 문제 이해
 * 정렬된 두 묶음의 숫자 카드
 * 각 묶음의 카드의 수를 a, b라 하면
 * 보통 두 묶음을 합쳐서 하나로 만드는 데에는 a+b 번의 비교를 해야 한다.
 * 
 * 매우 많은 숫자 카드 묶음이 있음
 * 이들을 두 묶음씩 골라 서로 합쳐나간다면,
 * 고르는 순서에 따라서 비교 횟수가 매우 달라진다.
 * 예를 들어 10, 20, 40장의 묶음이 있을 때
 * 10 + 20 -> 30 / 30 + 40 -> 70 / 30 + 70 총 100번의 비교
 * 10 + 40 -> 50 / 50 + 20 -> 70 / 50 + 70 총 120번의 비교
 * 
 * n 개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지 구하는 프로그램
 * 
 * # 문제 풀이
 * 그리디
 * 숫자 묶음 중 가장 작은 수부터 더하기
 * 
 * 유의할 점 : 전의 비교한 수를 누적해서 더해야한다.
 * 
 * 모두 더했을 때 정수형을 넘어갈 수도 있어서 long으로 바꿔봤는데 틀림;;
 * 
 * 처음에 들어온 카드 수를 정렬하였더라도
 * 중간에 합쳐진 수가 더 크면 뒤에서 연산되어져야함
 * 따라서, 계속해서 만들어진 카드더미를 pq에 넣어서 정렬한 후 제일 작은 두 수를 비교해야함
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> card = new PriorityQueue<>();
		for (int i = 0; i < n; i++)
			card.add(Long.parseLong(br.readLine()));
		
		long sum = 0;
		
		if (n > 1) {
			while (card.size() >= 2) {
				long a = card.poll();
				long b = card.poll();
				
				sum += a+b;
				if (card.isEmpty()) break;
				card.add(a+b);
			}
		}
		System.out.println(sum);
	}
}
