import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //버스 개수
		int t = Integer.parseInt(st.nextToken()); //도착 시간
		
		int r = -1;
		for (int k = 0; k < n; k++) {
		    st = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(st.nextToken()); //버스 시작 시간
		    int i = Integer.parseInt(st.nextToken()); //간격
		    int c = Integer.parseInt(st.nextToken()); //대수
		    
		    for (int j = 0; j < c; j++) {
		        int bus_time = s + i * j;
		        if (t <= bus_time) {
		            if (r == -1 || r > bus_time - t)
		                r = bus_time - t;
		            break;
		        }
		    }
		}
		System.out.println(r);
	}
}