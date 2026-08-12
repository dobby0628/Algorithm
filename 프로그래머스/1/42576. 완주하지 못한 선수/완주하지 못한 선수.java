import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer += key;
            }
        }
        
        return answer;
    }
}