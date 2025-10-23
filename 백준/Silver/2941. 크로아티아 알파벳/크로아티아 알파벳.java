/*
 * [크로아티아 알파벳]
 * 
 * # 문제 이해
 * 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)
 * 
 * # 문제 풀이
 * 
 */

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		
		Pattern p = Pattern.compile("dz=|c=|c-|d-|lj|nj|s=|z=");
		Matcher m = p.matcher(word);
		
		String replaced = m.replaceAll("*");
		
		System.out.println(replaced.length());
	}
}
