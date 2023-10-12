package day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {

	static int T, D, W, K, min;
	static int[][] map, mapCopy;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			mapCopy = new int[D][W];
			min = D;
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = mapCopy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 먼저 성늠검사부터 한다.
			if ( check() ) {
				sb.append("#").append(t).append(" ").append(0).append("\n");
				continue;
			}
			
			// 재귀돌리면서 성능검사를 해서 가장 낮은 횟수를 찾는다.
			recursive(0, 0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}	
	
	static void recursive(int cnt, int idx) {
		// 가지치기
		if ( cnt >= min ) return;
		// idx 다 돌았을 경우 성능검사를 해서 유효하면 min값 갱신한다.
		if ( idx == D ) {
			if ( check() ) min = Math.min(min, cnt);
			
			return;
		}
		
		// 아무것도 안함
		recursive(cnt, idx + 1);
		
		// A
		for (int w = 0; w < W; w++) {
			map[idx][w] = 0;
		}
		recursive(cnt + 1, idx + 1);
		
		// B
		for (int w = 0; w < W; w++) {
			map[idx][w] = 1;
		}
		recursive(cnt + 1, idx + 1);
		
		// 되돌리기
		for (int w = 0; w < W; w++) {
			map[idx][w] = mapCopy[idx][w];
		}
	}
	
	static boolean check() {
		// 모든 열 확인
		for (int j = 0; j < W; j++) {
			int count = 1; // 항상 카운트는 1부터 시작
			int prev = map[0][j];
			int max = 0;
			// 행 확인 (1부터)
			for (int i = 1; i < D; i++) {
				if ( prev == map[i][j] ) {
					count++;
				} else {
					count = 1;
				}
				prev = map[i][j]; // 다음값 고려를 위해 prev 갱신
				// max 값 갱신
				max = Math.max(max, count);
			}
			
			// 하나라도 max가 K보다 작으면 false 리턴
			if (max < K) return false;
		}
		// 무사히 다 통과하면 true 리턴
		return true;
	}
}