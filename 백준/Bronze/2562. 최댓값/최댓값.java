import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] ori = new int[9];
		int[] sort = new int[9];
		
		for (int i = 0; i < 9; i++) {
			int n = Integer.parseInt(br.readLine());
			ori[i] = sort[i] = n;
		}
		
		Arrays.sort(sort);
		
		int max = sort[8];
		System.out.println(max);
		for (int i = 0; i < 9; i++) {
			if (ori[i] == max) {
				System.out.println(i+1);
				break;
			}
		}
		
	}
	
}
