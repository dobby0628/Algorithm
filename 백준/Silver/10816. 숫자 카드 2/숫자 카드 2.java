import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      int n = Integer.parseInt(br.readLine());
      
      HashMap<Integer, Integer> map = new HashMap<>();
      
      int[] arr = Arrays.stream(br.readLine().split(" "))
                  .mapToInt(Integer::parseInt)
                  .toArray();
      
      for (int num : arr) {
        if (map.containsKey(num))
          map.replace(num, map.get(num) +1);
        else
          map.put(num, 1);
      }
      
      int m = Integer.parseInt(br.readLine());
      
      int[] arrM = Arrays.stream(br.readLine().split(" "))
                  .mapToInt(Integer::parseInt)
                  .toArray();
                  
      for (int num : arrM) {
        if (map.containsKey(num))
          sb.append(map.get(num)).append(" ");
        else
          sb.append("0 ");
      }
      
      System.out.println(sb.toString());
    }
}