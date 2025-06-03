class Solution {
    public int solution(String s) {
        int answer = 0;
        int i = 0;
        
        while (i < s.length()) {
            char x = s.charAt(i);
            int count = 1;
            i++;
            while (i < s.length() && count != 0) {
                if (s.charAt(i) == x)
                    count++;
                else
                    count--;
                i++;
            }
            answer++;
        }
        return answer;
    }
}