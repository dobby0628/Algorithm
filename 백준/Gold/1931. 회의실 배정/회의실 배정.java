/*
 * 회의실 배정
 * # 문제 이해
 * 1 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의에 대하여 회의실 사용표 만들기
 * 
 * 각 회의 I에 대해 시작시간과 끝나는 시간 주어짐
 * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자
 * 
 * 단, 회의는 한 번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의 진행 가능
 * 회의의 시작시간과 끝시간이 같을수도 있다.
 * ㄴ 이 경우는 시작하자마자 끝나는 것으로 생각하면 된다.
 * 
 * # 문제 풀이
 * 끝나는 시간이 빠른 것을 먼저 골라야, 뒤에 더 많은 회의를 배치할 수 있음
 * 
 * 1. 종료 시간 오름차순으로 정렬
 * 2. 종료 시간이 같을 경우 -> 시작 시간 오름차순 정렬
 * 3. 왼쪽부터 직전에 선택한 회의의 종료 시각 <= 이번 회의의 시작시각 이면 선택
 * 
 * # 실패사유
 * 1. TreeSet에 담으면서 중복인 회의가 사라짐 -> 배열에 넣고 정렬해야함
 */

import java.io.*;
import java.util.*;

class Time implements Comparable<Time> {
	int start;
	int end;
	public Time(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "Time [start=" + start + ", end=" + end + "]";
	}

	@Override
	public int compareTo(Time o) {
		if (this.end == o.end)
			return Integer.compare(this.start, o.start);
		return Integer.compare(this.end, o.end);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		List<Time> times = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			times.add(new Time(s, e));
		}
		
		Collections.sort(times);
		
		Time before = times.get(0);
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			Time present = times.get(i);
			if (before.end <= present.start) {
				before = present;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
