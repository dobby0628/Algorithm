// 문제를 잘못 이해해서 오래걸림 -> 문제 제대로 이해하고 풀기

// Double의 결과값이 나와야하므로 정수끼리 계산해서 소수값이 사라지지 않도록 유의해야함

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int max = 0;
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max)
				max = arr[i];
		}
		Double sum = 0.0;
		for (int i=0; i<N; i++)
			sum += (arr[i] * 1.0) / (max * 1.0) * 100.0;
		System.out.println(sum / N);
	}

}
