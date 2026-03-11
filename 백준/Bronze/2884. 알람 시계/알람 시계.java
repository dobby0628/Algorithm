/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
/*
# 문제 : 알람 시계
시와 분이 주어질 떄 45분 이전 시간을 출력하라

# 풀이

*/
import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if (m >= 45) {
		    m = m - 45;
		}
		else {
		    h = h -1;
		    if (h < 0) h = 23;
		    m = 60 - (45 - m);
		}
		System.out.println(h + " " + m);
	}
}