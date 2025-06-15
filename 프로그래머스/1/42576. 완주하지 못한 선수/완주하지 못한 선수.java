import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> c = new HashMap<>();
        for (String com : completion) {
            if (c.containsKey(com))
                c.put(com, c.get(com) +1);
            else
                c.put(com, 1);
        }
        for (String p : participant) {
            if (!c.containsKey(p)) {
                answer = p;
                break;
            }
            else
                c.put(p, c.get(p) -1);
        }
        if (answer.equals("")) {
            for (String s : c.keySet()) {
                if (c.get(s) != 0)
                    answer = s;
            }
        }
        return answer;
    }
}