/*
# 문제 : 단어의 개수
영어 대소문자와 공백으로 이루어진 문자열이 주어짐
이 문자열에는 몇 개의 단어가 있는지 구하는 프로그램
단, 한 단어가 여러 번 등장하면 횟수만큼 세어야함
*/

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		String[] arr = line.split("\\s+");
		
		if(line.isEmpty()) System.out.println(0);
        else System.out.println(arr.length);
	}
}