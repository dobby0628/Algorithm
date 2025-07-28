import java.util.Scanner;
import java.util.Stack;

// 아이디어 : 높이를 스택에 넣어 높이 차이를 통해 건물의 개수 찾기
//			스택의 peek보다 낮은 수가 나올 때까지 push
//			낮은 수가 나오면 pop하면서 result++
//			y = 0일 경우 지금까지 스택에 있던 값 모두 pop하면서 result++

// 1try 틀림 : 높이가 0일 때 고려를 안한 것이 건물의 개수를 잘못 셈
// 2try 틀림 : 건물을 더하는 시점이 잘못됨
// 3try 틀림 : y = 0인 조건문을 제일 앞에 둬야함 그렇지 않으면 0이 연속으로 나올 때 push되어 잘못된 값 나옴

public class Main {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = Integer.parseInt(sc.nextLine());
	    Stack<Integer> h = new Stack<>();
	    int result = 0;
	    
	    for (int i = 0; i < n; i++) {
	        String[] tmp = sc.nextLine().split(" ");
	        int y = Integer.parseInt(tmp[1]);

	        //System.out.println("i:"+i+", y:"+y);
	        if (y == 0) {
	        	while (!h.isEmpty()) {
	        		h.pop();
	        		result++;
	        	}
	        }
	        else if (h.isEmpty())
	            h.push(y);
	        else if (h.peek() < y)
	        	h.push(y);
	        else {
	        	while (!h.isEmpty() && h.peek() > y) {
	        		h.pop(); result++;
	        	}
	        	if (h.isEmpty() || h.peek() < y)
	        		h.push(y);
	        }
	        //System.out.println("s:"+h+", result:"+result);
	    }
	    while (!h.isEmpty()) {
    		h.pop();
    		result++;
    	}
	    System.out.println(result);
	}
}
