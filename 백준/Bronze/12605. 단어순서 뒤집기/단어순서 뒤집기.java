import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= N; i++) {
		    System.out.print("Case #" + i + ": ");
		    String[] command = sc.nextLine().split(" ");
		    for (int j = command.length -1; j >= 0; j--) {
		        System.out.print(command[j]);
		        if (j != 0)
		            System.out.print(" ");
		        else
		            System.out.println("");
		    }
		}
	}
}