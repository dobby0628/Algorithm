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