import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int end;
    int weight;
    public Edge(int end, int weight) {
        super();
        this.end = end;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Edge [end=" + end + ", weight=" + weight + "]";
    }
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class Main {
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dist;
	
	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			int now = current.end;
			int weight = current.weight;
			
			if (dist[now] < weight) continue;
			
			for (Edge next : graph.get(now)) {
				int cost = dist[now] + next.weight;
				
				if (cost < dist[next.end]) {
					dist[next.end] = cost;
					pq.offer(new Edge(next.end, cost));
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int D = Integer.parseInt(st.nextToken());
	    graph = new ArrayList<>();
	    dist = new int[D + 1];
	    
	    // 초기화
	    for (int i = 0; i <= D; i++) {
	        graph.add(new ArrayList<Edge>());
	        if (i < D)
	        	graph.get(i).add(new Edge(i + 1, 1));
	    }
	    Arrays.fill(dist, Integer.MAX_VALUE);

	    // 그래프 값 넣기
	    for (int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        int start = Integer.parseInt(st.nextToken());
	        int end = Integer.parseInt(st.nextToken());
	        int weight = Integer.parseInt(st.nextToken());
	        
	        if (start <= D && end <= D && end > start)
	        	graph.get(start).add(new Edge(end, weight));
	    }
	    
	    // dijkstra 실행
	    dijkstra(0);
	    System.out.println(dist[D]);
	}
}