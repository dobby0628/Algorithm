import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double[] c = new double[6];
		
		c[0] = 85.6;
		c[1] = 79.5;
		c[2] = 83.1;
		c[3] = 80.0;
		c[4] = 78.2;
		c[5] = 75.0;
		
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		
		double result = c[c1-1] + c[c2-1];
		System.out.println(result);
	}

}
