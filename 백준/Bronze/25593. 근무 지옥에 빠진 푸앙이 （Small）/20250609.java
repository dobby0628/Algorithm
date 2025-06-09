import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		HashMap<String, Integer> work = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
		    String[] firstTime = sc.nextLine().split(" ");
		    String[] secondTime = sc.nextLine().split(" ");
		    String[] thirdTime = sc.nextLine().split(" ");
		    String[] fourthTime = sc.nextLine().split(" ");
		    
		    for (int j = 0; j < 7; j++) {
		        if (!firstTime[j].equals("-")) {
		            if (work.containsKey(firstTime[j]))
		                work.put(firstTime[j], work.get(firstTime[j]) + 4);
		            else
		                work.put(firstTime[j], 4);
		                
		            if (work.containsKey(secondTime[j]))
		                work.put(secondTime[j], work.get(secondTime[j]) + 6);
		            else
		                work.put(secondTime[j], 6);
		                
		            if (work.containsKey(thirdTime[j]))
		                work.put(thirdTime[j], work.get(thirdTime[j]) + 4);
		            else
		                work.put(thirdTime[j], 4);
		                
		            if (work.containsKey(fourthTime[j]))
		                work.put(fourthTime[j], work.get(fourthTime[j]) + 10);
		            else
		                work.put(fourthTime[j], 10);
		        }
		    }
		}

		for (String key1 : work.keySet()) {
		    for (String key2 : work.keySet()) {
		        if (Math.abs(work.get(key1) - work.get(key2)) > 12) {
		            System.out.println("No");
		            return ;
		        }
		    }
		}
		System.out.println("Yes");
		return ;
	}
}
