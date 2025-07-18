import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int[] boxArr = new int[100];
			int dumpCount = sc.nextInt();
			
			for (int i = 0; i < 100; i++)
				boxArr[i] = sc.nextInt();
			
			for (int i = 0; i < dumpCount; i++) {
				Arrays.sort(boxArr);
				int start = 0;
				int end = 99;
				
				boxArr[99]--;
				boxArr[0]++;
			}
			Arrays.sort(boxArr);
			
			System.out.println("#" + test_case + " " + (boxArr[99] - boxArr[0]));
		}
	}

}
