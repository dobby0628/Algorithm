/*
 * - 1번째 다시 품
 * # 문제 이해
 * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조
 * 1. 배열에 정수 x( x != 0)를 넣는다
 * 2. 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
 * ㄴ 절댓값이 가장 작은 값이 여러개일때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 * 
 * 처음에는 비어있는 배열에서 시작함
 * 
 * # 입력
 * 첫째 줄에 연산의 개수 N이 주어짐
 * 이후 N 줄에 연산에 대한 정보를 나타내는 정수 x가 주어짐
 * - x != 0 : 배열에 x를 추가하는 연산
 * - x == 0 : 배열에서 절댓값이 가장 작은 값 출력하고 그 값을 배열에서 제거하는 경우
 * 
 * # 시간제한 2초
 * 1≤N≤100,000
 * n^2 가능
 * 
 * # 문제 풀이
 * 클래스를 만들어 절댓값과 원래값을 저장함
 * priorityQueue를 사용하여 저장하면서 정렬함
 */

import java.io.*;
import java.util.*;

class numberInfo implements Comparable<numberInfo>{
	int absoluteValue;
	int inputValue;
	public numberInfo(int inputValue) {
		super();
		this.absoluteValue = Math.abs(inputValue);
		this.inputValue = inputValue;
	}
	@Override
	public String toString() {
		return "numberInfo [absoluteValue=" + absoluteValue + ", inputValue=" + inputValue + "]";
	}
	@Override
	public int compareTo(numberInfo o) {
		if (this.absoluteValue == o.absoluteValue)
			return Integer.compare(this.inputValue, o.inputValue);
		return Integer.compare(this.absoluteValue, o.absoluteValue);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 명령어 개수 입력받기
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<numberInfo> pq = new PriorityQueue<>();
		
		// 명령어 입력받기
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			// 명령어가 0일 때
			// ㄴ 비어있으면 return 0;
			// ㄴ 비어있지 않으면 절댓값이 가장 작은 수 중 가장 작은 수 출력 후 제거
			if (input == 0) {
				if (pq.isEmpty())
					sb.append(0).append("\n");
				else {
					numberInfo small = pq.poll();
					sb.append(small.inputValue).append("\n");
				}
			}
			else {
				pq.offer(new numberInfo(input));
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
