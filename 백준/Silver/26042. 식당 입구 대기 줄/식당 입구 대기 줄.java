// 큐를 사용하여 줄을 세우고 앞에서부터 식당에 들어갈 수 있게 함
// 큐에 정보가 정리된 후 줄의 최대값과 마지막에 들어온 학생에 대해 비교하여 출력정보 찾을 수 있다

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Queue<Integer> line = new LinkedList<>();
		int max = 0;
		int last = 0;
		int student = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			switch(type) {
			case 1:
				student = Integer.parseInt(st.nextToken());
				line.offer(student);
				break;
			case 2:
				if (!line.isEmpty())
					line.poll();
				break;
			}
			
			// 줄이 최대가 되었던 순간의 학생 수와 이때 맨 뒤에 대기 중인 학생의 번호 출력하기
			// 최대인 경우가 여러번이라면 가장 작은 수 출력
			
			// 1. 줄이 최대가 되었던 순간 학생 수
			int size = line.size();
			if (max < size) {
				max = size;
				last = student;
			}
			else if (max == size) {
				if (last > student)
					last = student;
			}
		}
		System.out.println(max + " " + last);
	}
}

