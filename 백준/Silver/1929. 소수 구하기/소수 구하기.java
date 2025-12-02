import java.util.*;
import java.io.*;
/*
 * [소수 구하기]
 * m이상 n 이하의 소수를 모두 출력하는 프로그램 작성하기
 * 
 * # 풀이 방법
 * 1. m부터 시작해서 1과 자기 자신을 제외한 숫자로 나눠질 경우 넘기고
 * 아닌 경우 출력하기
 * 
 * 2. 에라토스테네스의 체
 * 
 * # 틀린 이유
 * 1. 시간 초과 
 * n^2으로 2초 넘어감
 * 
 */

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int p = 2; p * p <= n; p++) {
        	if (isPrime[p]) {
        		for (int multiple = p * p; multiple <= n; multiple += p) {
        		    isPrime[multiple] = false;
        		}
        	}
        }
        
        for (int i = m; i <= n; i++) {
        	if (isPrime[i])
        		sb.append(i).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}