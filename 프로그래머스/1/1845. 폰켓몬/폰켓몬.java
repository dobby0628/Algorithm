import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        // 해시에 포켓몬 종류별로 넣기
        HashMap<Integer, Integer> poke = new HashMap<Integer, Integer>();
        for (int i : nums) {
        	if (!poke.containsKey(i))
        		poke.put(i, 0);
        	poke.replace(i, poke.get(i) + 1);
        }
        
        // 포켓몬 종류 개수의 최댓값 구하기
        if (nums.length/2 > poke.size())
        	return (poke.size());
        else
        	return (nums.length/2);
    }
}