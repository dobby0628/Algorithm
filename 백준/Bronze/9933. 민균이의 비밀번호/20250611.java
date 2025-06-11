import java.io.*;
import java.util.*;

public class Main
{
    public static String reverseString(String s) {
        String reverse = "";
        for (int i = s.length() -1; i >= 0; i--) {
            reverse = reverse + s.charAt(i);
        }
        return (reverse);
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = Integer.parseInt(sc.nextLine());
	    String[] pw = new String[N];
	    for (int i = 0; i < N; i++)
	        pw[i] = sc.nextLine();
	    for (int i = 0; i < N -1; i++) {
	        for (int j = i; j < N; j++) {
	            String reverse = reverseString(pw[j]);
	            if (pw[i].equals(reverse)) {
	                int len = pw[i].length();
	                System.out.println(len + " " + pw[i].charAt(len / 2));
	                return ;
	            }
	        }
	    }
	}
}
