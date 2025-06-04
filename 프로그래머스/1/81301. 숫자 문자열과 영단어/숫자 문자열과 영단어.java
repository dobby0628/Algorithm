import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, Integer> number = new HashMap<>();
        number.put("zero", 0);
        number.put("one", 1);
        number.put("two", 2);
        number.put("three", 3);
        number.put("four", 4);
        number.put("five", 5);
        number.put("six", 6);
        number.put("seven", 7);
        number.put("eight", 8);
        number.put("nine", 9);
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                answer = answer * 10 + (s.charAt(i) - '0');
                i++;
            }
            else {
                int start = i;
                while (!number.containsKey(s.substring(start, i)))
                    i++;
                answer = answer * 10 + number.get(s.substring(start, i));
            }
        }
        return answer;
    }
}