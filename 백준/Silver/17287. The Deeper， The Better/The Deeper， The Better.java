// 아이디어 :   괄호는 무조건 올바르게 들어오는 것이 키포인트
//            여는 괄호를 스택에 저장하면서 점수를 더하고
//            괄호 이외의 것이 들어오면(default) 숫자가 나온 것이므로 최종결과와 비교하여 최대값을 남김
//            닫는 괄호는 스택의 것과 짝이 맞는지 확인 후 삭제하면서 점수 빼기
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Stack<Character> s = new Stack<>();
		int cnt = 0, result = 0;;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			switch (c) {
			case '[':
				cnt += 3; s.push(c); break;
			case '{':
				cnt += 2; s.push(c); break;
			case '(':
				cnt += 1; s.push(c); break;
			case ']':
				if (s.peek() == '[') {
					s.pop();
					cnt-=3;
				}
				break;
			case '}':
				if (s.peek() == '{') {
					s.pop();
					cnt-=2;
				}
				break;
			case ')':
				if (s.peek() == '(') {
					s.pop();
					cnt-=1;
				}
				break;
			default:
				if (cnt != 0 && cnt > result) {
					result = cnt;
				}
			}
		}
		System.out.println(result);
	}
}
