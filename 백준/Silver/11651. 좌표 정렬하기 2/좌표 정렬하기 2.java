import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<Point> list = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }
        
        Collections.sort(list, (p1, p2) -> {
            if (p1.y == p2.y) return Integer.compare(p1.x, p2.x);
            return Integer.compare(p1.y, p2.y);
        });
        
        for (Point p : list) {
            System.out.println(p.x + " " + p.y);
        }
	}
}