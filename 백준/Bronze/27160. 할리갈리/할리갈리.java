import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HashMap<String, Integer> S = new HashMap<String, Integer>();
		S.put("STRAWBERRY", 0);
		S.put("BANANA", 0);
		S.put("LIME", 0);
		S.put("PLUM", 0);
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<n; i++) {
			String[] fruit = sc.nextLine().split(" ");
			if (S.containsKey(fruit[0]))
				S.replace(fruit[0], S.get(fruit[0]) + Integer.parseInt(fruit[1]));
		}
		if (S.containsValue(5))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
