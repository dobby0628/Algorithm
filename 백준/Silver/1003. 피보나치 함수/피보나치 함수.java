import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		int[] arr = new int[test_case];
		int max_num = 0;
		
		for (int i = 0; i < test_case; i++) {
		    int n = Integer.parseInt(br.readLine());
		    
		    arr[i] = n;
		    max_num = Math.max(max_num, arr[i]);
		}
		
		int[] zero = new int[41];
		int[] one = new int[41];
		
		// f(0)
		zero[0] = 1;
		one[0] = 0;
		
		// f(1)
		zero[1] = 0;
		one[1] = 1;
		
		// max_num까지 반복
		for (int i = 2; i <= max_num; i++) {
		    zero[i] = zero[i-2] + zero[i-1];
		    one[i] = one[i-2] + one[i-1];
		}
		
		for (int i = 0; i < test_case; i++) {
		    int n = arr[i];
		    sb.append(zero[n]).append(" ").append(one[n]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}