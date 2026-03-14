/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int multiple = a*b*c;
		
		int[] num = new int[10];
		
		while (multiple > 0) {
		    num[multiple%10]++;
		    multiple /= 10;
		}
		
		for (int i = 0; i <= 9; i++) {
		    System.out.println(num[i]);
		}
	}
}