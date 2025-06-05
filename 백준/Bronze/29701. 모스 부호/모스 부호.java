import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	private static void print_mose(int n, String str) {
		String[] list = str.split(" ", n);

		HashMap<String, Character> mose = new HashMap<String, Character>();
		mose.put(".-", 'A');
		mose.put("-...", 'B');
		mose.put("-.-.", 'C');
		mose.put("-..", 'D');
		mose.put(".", 'E');
		mose.put("..-.", 'F');
		mose.put("--.", 'G');
		mose.put("....", 'H');
		mose.put("..", 'I');
		mose.put(".---", 'J');
		mose.put("-.-", 'K');
		mose.put(".-..", 'L');
		mose.put("--", 'M');
		mose.put("-.", 'N');
		mose.put("---", 'O');
		mose.put(".--.", 'P');
		mose.put("--.-", 'Q');
		mose.put(".-.", 'R');
		mose.put("...", 'S');
		mose.put("-", 'T');
		mose.put("..-", 'U');
		mose.put("...-", 'V');
		mose.put(".--", 'W');
		mose.put("-..-", 'X');
		mose.put("-.--", 'Y');
		mose.put("--..", 'Z');
		mose.put(".----", '1');
		mose.put("..---", '2');
		mose.put("...--", '3');
		mose.put("....-", '4');
		mose.put(".....", '5');
		mose.put("-....", '6');
		mose.put("--...", '7');
		mose.put("---..", '8');
		mose.put("----.", '9');
		mose.put("-----", '0');
		mose.put("--..--", ',');
		mose.put(".-.-.-", '.');
		mose.put("..--..", '?');
		mose.put("---...", ':');
		mose.put("-....-", '-');
		mose.put(".--.-.", '@');
		
		for(int i=0; i<n; i++) {
			Character value = mose.get(list[i]);
			System.out.print(value);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int	n;
		String str;
		
		n = Integer.parseInt(sc.nextLine());
		str = sc.nextLine();
		print_mose(n, str);
	}

}
