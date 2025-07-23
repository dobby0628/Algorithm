import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (A[i] < X)
				bw.write(A[i] + " ");
		}
		bw.flush();
		bw.close();
		
	}

}
