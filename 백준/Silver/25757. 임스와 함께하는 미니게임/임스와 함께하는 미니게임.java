import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		char game = input[1].charAt(0);
		
		HashSet<String> person = new HashSet<>();
		for (int i = 0; i < n; i++) {
		    person.add(br.readLine());
		}
		if (game == 'Y')
		    System.out.println(person.size() / 1);
		else if (game == 'F')
		    System.out.println(person.size() / 2);
		else if (game == 'O')
		    System.out.println(person.size() / 3);
	}
}