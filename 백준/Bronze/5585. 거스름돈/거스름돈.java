import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int price = Integer.parseInt(br.readLine());
		
		// 500, 100, 50, 10, 5, 1
		int rest = 1000 - price;
		int[] coin = {500, 100, 50, 10, 5, 1};
		
		int cnt = 0;
		for (int c : coin) {
			cnt += rest / c;
			rest = rest % c;
		}
		System.out.println(cnt);
	}
}
