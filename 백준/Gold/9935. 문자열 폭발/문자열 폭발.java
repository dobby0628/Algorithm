/*
# 문제 : 문자열 폭발
문자열에 폭발 문자열을 심어 놓음
폭발 문자열이 폭발하면 그 문자는 사라지고, 남은 문자열은 합쳐지게 됨
단, 남아있는 문자가 없는 경우 "FRULA"를 출력한다

# 풀이 방법
스택에 넣으면서 마지막 폭발 문자열의 길이만큼 계속해서 비교하여
일치하면 빼는 형식으로 진행
*/

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
	    String bomb = br.readLine();
	    
	    StringBuilder sb = new StringBuilder();
		
		for (char c : str.toCharArray()) {
		    sb.append(c);
		    if (sb.length() >= bomb.length()) {
		        if (sb.substring(sb.length() - bomb.length()).equals(bomb)) {
		            sb.delete(sb.length() - bomb.length(), sb.length()); // pop
		        }
		    }
		}
		if (sb.length() == 0) {
		    System.out.println("FRULA");
		}
		else {
		    System.out.println(sb);
		}
	}
}