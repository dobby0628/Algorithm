import java.util.*;

class Solution {
    
    int[] parent;
    
    void init(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);
    
        if (a != b) {
            parent[b] = a;
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        init(n);
        
        for (int from = 0; from < n; from++) {
            for (int to = 0; to < n; to++) {
                if (from == to) continue;
                if (computers[from][to] == 1) {
                    union(from, to);
                }
            }
        }
        //System.out.println(Arrays.toString(parent));
        Set<Integer> network = new HashSet<>();
        for (int num : parent) {
            network.add(find(num));
        }
        
        return network.size();
    }
}