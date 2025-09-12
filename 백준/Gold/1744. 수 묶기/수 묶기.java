/*
 * [수 묶기]
 * 
 * # 문제 이해
 * 길이가 n인 수열 주어졌을 때, 그 수열의 합을 구하려고 함
 * 하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아닌
 * 수열의 두 수를 묶으려고 한다.
 * 
 * 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다.
 * 하지만, 같은 위치에 있는 수(자기 자신)을 묶는 것은 불가능
 * 
 * 그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
 * 
 * 예를 들어 {0,1,2,4,3,5}
 * 그냥 수열의 합 = 15
 * 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0 + 1 + (2*3) + (4*5) = 27이 최대
 * 수열의 모든 수는 단 한번만 묶거나, 묶지 않아야한다.
 * 수열이 주어지고, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.
 * 
 * # 문제 풀이
 * 수열이 주어졌을 때, 음수 배열, 양수 배열, 0의 개수 따로따로 저장하기
 * 1. 양수 배열 큰 수들부터 2개씩 묶어서 곱하기
 * 	단, 두 수가 1, 1이라면 곱하지 말고 더하기
 * 2. 음수 배열 작은 수들부터 2개씩 묶어서 곱하기
 * 3. 남는 수 
 * - 음수 배열의 제일 큰 수
 * - 양수 배열의 제일 작은 수
 * - 0
 * 
 * 0의 개수만큼 음수와 곱하기
 * 양수 배열의 제일 작은 수는 그냥 더하기
 * 
 * # 틀린이유
 * 1 1 일 경우 묶어서 더해야하는데
 * 2 1 1 일 경우 2 1 을 먼저 구해버려서 1 1 이 아니게 되어 버림
 * 
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
		
		List<Integer> positiveN = new ArrayList<>();
		List<Integer> negativeN = new ArrayList<>();
		boolean zero = false;
		
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (input > 0) positiveN.add(input);
			else if (input < 0) negativeN.add(input);
			else zero = true;
		}
		Collections.sort(positiveN, Comparator.reverseOrder());
		Collections.sort(negativeN);
		//System.out.println(positiveN);
		//System.out.println(negativeN);
		
		int sum = 0;
		
		// 양수 배열 합산
		int i = 0;
		int pArrSize = positiveN.size();
		while (pArrSize - 2*i > 1) {
			int a = positiveN.get(2*i);
			int b = positiveN.get(2*i+1);
			
			if (a == 1 || b == 1) {
				sum += a+b;
			}
			else {
				sum += a*b;
			}
			i++;
		}
		//System.out.println(sum);
		if (pArrSize % 2 == 1)
			sum += positiveN.get(2*i);
		//System.out.println(sum);
		
		// 음수 배열 합산
		i = 0;
		int nArrSize = negativeN.size();
		while (nArrSize - 2*i > 1) {
			int a = negativeN.get(2*i);
			int b = negativeN.get(2*i+1);
			
			sum += a*b;
			i++;
		}
		//System.out.println(sum);
		if (nArrSize % 2 == 1) {
			if (!zero)
				sum += negativeN.get(2*i);
		}
		System.out.println(sum);
	}
}
