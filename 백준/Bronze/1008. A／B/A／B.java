import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double A = Integer.parseInt(st.nextToken()) * 1.0;
		double B = Integer.parseInt(st.nextToken()) * 1.0;

		System.out.println(A / B);
	}
}
