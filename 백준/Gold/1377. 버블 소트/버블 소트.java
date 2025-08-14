/*
 * # 문제 이해
 * c++로 버블 소트 알고리즘을 아래와 같이 작성하였을 때
 * 어떤 값이 출력되는지 구해보자
 * 
 * bool changed = false;
   for (int i=1; i<=N+1; i++) {
    changed = false;
    for (int j=1; j<=N-i; j++) {
        if (A[j] > A[j+1]) {
            changed = true;
            swap(A[j], A[j+1]);
        }
    }
    if (changed == false) {
        cout << i << '\n';
        break;
    }
   }
 * N 배열의 크기
 * A 정렬해야하는 배열
 * 배열은 A[1]부터 사용함
 * 
 * # 입력
 * 1 <=N <= 500000
 * 자연수 : 1부터 시작하는 양의 정수
 * 
 * # 풀이
 * c++ 소스코드 java로 바꿔서 실행시켜보기 -> 시간초과
 * 
 * i를 반복할 때 이미 정렬이 된 i를 찾아서 출력하는 문제 but 버블정렬을 사용하면 시간초과나서 다른 방법을 찾아야함
 * 
 * 정렬 전 인덱스 값 - 정렬 후 인덱스 값 중 최대값 +1
 * 
 * # 시간복잡도 O(nlogn)
 * sort() : O(nlogn)
 * 인덱스 계산 O(n)
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		mData[] data = new mData[n];
		for (int i = 0; i < n; i++) {
			data[i] = new mData(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(data);
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int between = data[i].index - i;
			if (between > max)
				max = between;
		}
		
		System.out.println(max+1);
	}
}

class mData implements Comparable<mData> {
	int value;
	int index;
	public mData(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	@Override
	public int compareTo(mData o) {
		return Integer.compare(this.value, o.value);
	}
}
