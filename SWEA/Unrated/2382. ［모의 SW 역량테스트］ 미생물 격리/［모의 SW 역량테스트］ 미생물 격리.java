/*
 * 미생물 격리
 * # 문제 이해
 * 정사각형 안에 k개의 미생물 군집이 있음
 * n*n 크기
 * 테두리에 약품이 발라져 있음
 * 1시간마다 방향에 따라 다음 셀로 이동함
 * 
 * - 미생물의 숫자가 바뀌는 경우
 * 약품에 닿으면 -> 미생물의 절반이 죽고(소수점 이하 버림) 이동방향이 반대로 바뀜
 * 2개 이상의 미생물이 한 셀에 모이면 -> 미생물들의 수를 모두 합하고 제일 많은 미생물 수의 방향으로 합쳐짐
 * 
 * M 시간동안 군집을 격리하였을 때 남아있는 미생물 수의 총합을 구하여라
 * 
 * # 문제 풀이 - 구현
 * - 만들어야하는 함수
 * 1) 경계에 닿으면 미생물의 수를 반으로 줄이고 이동방향 바꾸는 함수
 * 2) 경계에 닿는게 아니라면 동일한 셀에 모였는지 확인하는 함수
 * 
 * - 생각해봐야하는 부분
 * 1) 어떻게 구현해야 동일한 셀에 모였는지 알 수 있을까?
 *  ㄴ 군집 클래스 배열에 저장
 *  ㄴ treemap을 이용해서 키가 이미 있다면 해당 값에 없데이트하기!!
 *  
 *  군집을 저장할때 treemap 이용
 *  키 : 위치, 값 : 미생물 수
 */

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
	static int[] dy = {0, -1, +1, 0, 0};
	static int[] dx = {0, 0, 0, -1, +1};
	
	static class Micro {
		int num;
		int sum;
		int dir; // 상: 1, 하: 2, 좌: 3, 우: 4
		public Micro(int num, int sum, int dir) {
			super();
			this.num = num;
			this.sum = sum;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Micro [num=" + num + ", sum=" + sum + ", dir=" + dir + "]";
		}
	}
	
	static int changeDir(int d) {
		if (d == 1) return 2;
		else if (d == 2) return 1;
		else if (d == 3) return 4;
		else if (d == 4) return 3;
		else return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			// N : 변의 길이, M : 격리시간, K : 군집의 개수
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			// 군집의 정보 입력받기
			HashMap<Point, Micro> microMap = new HashMap<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				microMap.put(new Point(x, y), new Micro(num, num, dir));
			}
			
			// M 격리시간만큼 돌리기
			for (int m = 0; m < M; m++) {
				HashMap<Point, Micro> tmpMap = new HashMap<>();
				for (Point tmp : microMap.keySet())
				{
					int x = tmp.x;
					int y = tmp.y;
					int num = microMap.get(tmp).num;
					int sum = microMap.get(tmp).sum;
					int dir = microMap.get(tmp).dir;
					// 위치 이동시키기
					x += dx[dir];
					y += dy[dir];
					
					// 약품이 발린 구역 : x == 0 || x == N-1 || y == 0 || y == N-1
					// if 약품이 발린 구역에 닿았다면
					if (x == 0 || x == N-1 || y == 0 || y == N-1) {
						//ㄴ 미생물의 수 반으로 줄이기
						sum = (int)Math.floor(sum / 2);
						if (num == 0) continue;
						// 방향 바꾸기
						dir = changeDir(dir);
					}
					
					Point curP = new Point(x, y);
					Micro ex = tmpMap.get(curP);

					if (ex == null) {
						// 최초 유입 -> 바로 추가
						tmpMap.put(curP, new Micro(num, sum, dir));
					}
					else {
						// 원래 미생물 수 > 현재 미생물 수 => 방향 원래 방향으로 바꾸기
						ex.sum += sum;
						if (ex.num < num) {
							ex.num = num;
							ex.dir = dir;
						}
					}
				}
				for (Micro micro : tmpMap.values()) {
					micro.num = micro.sum;    // 다음 턴부터는 이 덩어리의 크기 자체가 sum
				}
				microMap = tmpMap;
			}
			
			int sum = 0;
			for (Point key : microMap.keySet()) {
				sum += microMap.get(key).sum;
			}
			sb.append("#").append(tc).append(" ");
			sb.append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
