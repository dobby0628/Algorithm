import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] stack = new int[N];
		int top = -1;
		Arrays.fill(stack, -1);
		for (int i = 0; i < N; i++) {
		    String[] command = sc.nextLine().split(" ");
		    if (command[0].equals("push")) {
		        top += 1;
		        stack[top] = Integer.parseInt(command[1]);
		    }
		    else if (command[0].equals("pop")) {
		        if (top == -1)
		            System.out.println("-1");
		        else {
		            System.out.println(stack[top]);
		            stack[top] = -1;
		            top -= 1;
		        }
		    }
		    else if (command[0].equals("size")) {
		        System.out.println(top +1);
		    }
		    else if (command[0].equals("empty")) {
		        if (top == -1)
		            System.out.println("1");
		        else
		            System.out.println("0");
		    }
		    else if (command[0].equals("top")) {
		        if (top == -1)
		            System.out.println("-1");
		        else
		            System.out.println(stack[top]);
		    }
		}
	}
}