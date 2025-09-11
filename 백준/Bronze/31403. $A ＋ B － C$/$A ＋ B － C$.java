import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sa = sc.nextLine();
		int a = Integer.parseInt(sa);
		String sb = sc.nextLine();
		int b = Integer.parseInt(sb);
		int c = Integer.parseInt(sc.nextLine());
		System.out.println(a+b-c);
		int ab = Integer.parseInt(sa+sb);
		System.out.println(ab - c);
	}
}
