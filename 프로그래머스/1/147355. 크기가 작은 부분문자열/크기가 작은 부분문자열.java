class Solution {
    public int solution(String t, String p) {
        int t_len = t.length();
        int p_len = p.length();
        int answer = 0;
        Long p_num = Long.parseLong(p);
        
        for (int i = 0; i <= t_len - p_len; i++)
        {
            if (Long.parseLong(t.substring(i, i + p_len)) <= p_num)
                answer++;
        }
        return (answer);
    }
}