import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int tmp = sc.nextInt();
			sum += Math.pow(tmp, 2);
		}
			
		System.out.println(sum % 10);
	}
}
