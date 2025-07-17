import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int result = 0;
		Stack<Character> stackL = new Stack<>();
		Stack<Character> stackS = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			
			if (Character.isDigit(c))
				result++;
			else if (c == 'L')
				stackL.push(c);
			else if (c == 'S')
				stackS.push(c);
			else if (c == 'R') {
				if (!stackL.isEmpty()) {
					stackL.pop();
					result++;
				}
				else
					break;
			}
			else if (c == 'K') {
				if (!stackS.isEmpty()) {
					stackS.pop();
					result++;
				}
				else
					break;
			}
		}
		System.out.println(result);
	}
}
