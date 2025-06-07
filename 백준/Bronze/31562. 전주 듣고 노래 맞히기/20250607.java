import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int M = sc.nextInt();
	    sc.nextLine();
	    
	    HashMap<String, String> songs = new HashMap<>();
	    for (int i = 0; i < N; i++) {
	        int T = sc.nextInt();
	        String songName = sc.next();
	        String song = sc.nextLine();
	        if (!songs.containsKey(song))
	            songs.put(songName, song.substring(1, 6));
	    }
	    for (int i = 0; i < M; i++) {
	        String input = sc.nextLine();
	        if (songs.containsValue(input)) {
	            int count = 0;
	            String answer = "";
	            for (String s : songs.keySet())
	                if (songs.get(s).equals(input)) {
                        count++;
                        answer = s;
	                }
	            if (count > 1)
	                System.out.println("?");
	            else
	                System.out.println(answer);
	        }
	        else
	            System.out.println("!");
	    }
	}
}
