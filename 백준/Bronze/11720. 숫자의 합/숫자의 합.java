// 문자를 입력받으므로 숫자로 변환했을 때 자료형의 범위를 벗어나는지 생각해야함
// char -> int : - '0' or Charater.getNumericValue()  사용 가능

import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String num = br.readLine();
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += num.charAt(i) - '0';
		}
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}

