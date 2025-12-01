import java.util.*;
import java.io.*;
/*
 * [셀프 넘버]
 * 양의 정수 n에 대해서 d(n) = n + n의 각 자리수 더하는 함수
 * ex) d(75) = 75+7+5 = 87
 * 
 * 양의 정수 n이 주어졌을 때 이수를 시작해서 n, d(n), d(d(n))... 무한 수열을 만들 수 있다
 * 33은 39의 생성자 33+3+3=39
 * 생성자가 없는 숫자를 셀프 넘버라고 한다
 * 10000보다 작거나 같은 셀프 넘버를 한줄에 하나씩 출력하는 프로그램
 * 
 * # 문제 풀이
 * 10000 배열을 만들어서
 * 1부터 시작하여 무한 수열 진행
 * 1은 처음 시작했으니까 셀프 넘버로 출력
 * 1 이후 숫자 중 배열의 값이 0인 값은 출력 후 무한 수열 진행
 * 하여 10000까지 진행하면 됨
 * 
 * - 시간복잡도 못구하겠음
 * 일단 풀어보고  gpt한테 물어보기
 */

public class Main {
	
	static int dFunc(int n) {
		int sum = n;
		String s = String.valueOf(n);
		
		for (char c : s.toCharArray()) {
			sum += c - '0';
		}
		
		return sum;
	}
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int[] selfNCheck = new int[10001];
        
        // 셀프 넘버 후보군 반복문
        for (int i = 1; i <= 10000; i++) {
        	if (selfNCheck[i] == 0) {
        		sb.append(i).append("\n");
        		
        		// d(n)공식에 따라 무한 수열 돌리면서 해당 값의 배열값 변경하기
        		int n = i;
        		while (n <= 10000) {
        			n = dFunc(n);
        			if (n <= 10000)
        				selfNCheck[n] = 1;
        		}
        	}
        }
        
        // 셀프 넘버 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}