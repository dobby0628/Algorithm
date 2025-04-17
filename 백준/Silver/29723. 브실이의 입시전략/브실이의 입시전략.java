import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] subject = br.readLine().split(" ");
		int n = Integer.parseInt(subject[0]);
		int m = Integer.parseInt(subject[1]);
		int k = Integer.parseInt(subject[2]);
		
		HashMap<String, Integer> n_sub = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
		    String[] tmp = br.readLine().split(" ");
		    n_sub.put(tmp[0], Integer.parseInt(tmp[1]));
		}
		int sum = 0;
		for (int i = 0; i < k; i++) {
		    String  k_sub = br.readLine();
		    if (n_sub.containsKey(k_sub)) {
		        sum += n_sub.get(k_sub);
		        n_sub.remove(k_sub);
		    }
		}
		Collection<Integer> values = n_sub.values();
		List<Integer> list = new ArrayList<>(values);
		Collections.sort(list);
		int min = sum;
		int max = sum;
		for (int i = 0; i < m - k; i++) {
		    min += list.get(i);
		    max += list.get(list.size() -1 -i);
		}
		System.out.println(min + " " + max);
	}
}