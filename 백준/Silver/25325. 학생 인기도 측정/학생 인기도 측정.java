import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] A = br.readLine().split(" ");
		HashMap<String, Integer> st = new HashMap<String, Integer>();
		for (String s : A)
		    st.put(s, 0);
		for (int i = 0; i < n; i++) {
		    String[] tmp = br.readLine().split(" ");
		    for (int j = 0; j < tmp.length; j++)
		        st.put(tmp[j], st.get(tmp[j]) +1);
		}
		List<String> keySet = new ArrayList<>(st.keySet());
        keySet.sort((o1, o2) -> { // 정렬
            if(st.get(o1) - st.get(o2) == 0)
                return o1.compareTo(o2);
            else
                return st.get(o2) - st.get(o1);
        });
		for (String key : keySet)
		    System.out.println(key + " " + st.get(key));
	}
}