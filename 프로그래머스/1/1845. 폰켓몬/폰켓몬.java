import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> poke = new HashMap<>();
        
        for (int num : nums) {
            if (poke.containsKey(num))
                poke.put(num, poke.get(num) +1);
            else
                poke.put(num, 1);
        }
        int nums_size = nums.length;
        if (nums_size / 2 < poke.size())
            answer = nums_size / 2;
        else
            answer = poke.size();
        return answer;
    }
}