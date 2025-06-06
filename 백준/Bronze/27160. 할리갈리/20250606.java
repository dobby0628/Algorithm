import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		HashMap<String, Integer> fruits = new HashMap<>();
		for (int i = 0; i < N; i++) {
		    String[] str = sc.nextLine().split(" ");
		    String fruitName = str[0];
		    int X = Integer.parseInt(str[1]);
		    if (!fruits.containsKey(fruitName))
		        fruits.put(fruitName, X);
		    else
		        fruits.put(fruitName, fruits.get(fruitName) + X);
		}
		if (fruits.containsValue(5))
		    System.out.println("YES");
		else
		    System.out.println("NO");
	}
}
