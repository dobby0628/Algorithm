import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= N; i++)
		    q1.add(i);
		while (q1.size() != 1) {
		    q2.add(q1.remove());
		    q1.add(q1.remove());
		}
		while (q2.size() != 0)
		    System.out.print(q2.remove() + " ");
		System.out.print(q1.remove());
	}
}