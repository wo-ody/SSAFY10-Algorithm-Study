package month10.day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 0.5 초 (추가 시간 없음)	512 MB
public class BOJ_17140_이차원배열과연산 {

	static int r, c, k, time;
	static int[][] A;
	static int rowLenMax, colLenMax;
	
	static PriorityQueue<int[]> pqueue = new PriorityQueue<>( 
			(e1, e2) -> e1[1] == e2[1] ? e1[0] - e2[0] : e1[1] - e2[1] );
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken())-1; //보정
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		
		A = new int[100][100];
		// 배열 A에 들어있는 수는 100보다 작거나 같은 자연수이다.
		// R연산 : 모든 행들 하나씩 정렬, 행의 개수>=열의 개수인 경우
		// C연산 : 모든 열들 하나씩 정렬, 행의 개수<열의 개수인 경우
		// 열의 개수 = 행의 최대 길이(rowLenMax)
		// 행의 개수 = 열의 최대 길이(colLenMax)
		// -> if(열의 개수 > 행의 개수) 모든 열 정렬
		//    else 모든 행 정렬
		// 정렬 기준 :
		// 1. 수의 개수 오름차순
		// 2. 수 오름차순
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rowLenMax = colLenMax = 3; // 초기 길이 3
		
		// A[r][c]==k인지 확인
		while(A[r][c] != k) {
			time++;
			// 행의 개수와 열의개수에 따라 R,C연산
			
			if(rowLenMax > colLenMax) C();
			else R();
			
			if(time > 100) {
				time = -1;
				break;
			}
		}
		
		System.out.println(time);
		
	}
	
	static void R() {
		// 행 정렬
		// 모든 행에 대한 정렬 시작
		rowLenMax = 0;
		for (int i = 0; i < 100; i++) {
			
			int[] cntArray = new int[101]; // 100까지 자연수 count, 숫자가 0이 아니면 visit한거다.
			// 행 탐색
			for (int j = 0; j < 100; j++) {
				int n = A[i][j];
//				if(n == 0) break; // 0을 만나면 더 탐색할 필요 없음
				
				// 열 전부 탐색해서 n의 개수 세기
				// 이미 탐색(0이 아닌) 경우 continue;
				if(cntArray[n] != 0) continue;
				int cnt = 0;
				for (int m = 0; m < 100; m++) {
					if(A[i][m] == n) cnt++;
				}
				// n 개수 저장
				cntArray[n] = cnt;
			}
			
			// 탐색이 끝났으면 pqueue에 넣기
			for (int j = 1; j <= 100; j++) {
				// 0이면 없는 수
				if( cntArray[j] == 0 ) continue;
				pqueue.offer(new int[] {j, cntArray[j]});
			}
			// len 업데이트
			rowLenMax = Math.max(rowLenMax, pqueue.size() * 2);
			
			// 배열 업데이트, cntMax값 갱신
			for (int size = 0; size < 100; size+=2) {
				// pqueue가 비어있지 않으면
				if( !pqueue.isEmpty() ) {
					int[] cur = pqueue.poll();
					A[i][size] = cur[0];
					A[i][size+1] = cur[1];
				// 더 업데이트할 값이 없는데, 맵에 값이 남아 있다면 0으로 초기화
				} else {
					A[i][size] = 0;
					A[i][size+1] = 0;
				}
			}
			
			// pqueue 초기화( 인덱스 100 이상 넘으면 버려야 됨 )
			pqueue.clear();
		}
	}
	
	static void C() {
		// 열 정렬
		// 모든 열에 대한 정렬 시작
		colLenMax = 0;
		for (int i = 0; i < 100; i++) {
			int[] cntArray = new int[101]; // 100까지 자연수 count, 숫자가 0이 아니면 visit한거다.
			// 행 탐색
			for (int j = 0; j < 100; j++) {
				int n = A[j][i];
//				if(n == 0) break; // 0을 만나면 더 탐색할 필요 없음
				
				// 열 전부 탐색해서 n의 개수 세기
				// 이미 탐색(0이 아닌) 경우 continue;
				if(cntArray[n] != 0) continue;
				int cnt = 0;
				for (int m = 0; m < 100; m++) {
					if(A[m][i] == n) cnt++;
				}
				// n 개수 저장
				cntArray[n] = cnt;
			}
			
			// 탐색이 끝났으면 pqueue에 넣기
			for (int j = 1; j <= 100; j++) {
				// 0이면 없는 수
				if( cntArray[j] == 0 ) continue;
				pqueue.offer(new int[] {j, cntArray[j]});
			}
			// len 업데이트
			colLenMax = Math.max(colLenMax, pqueue.size() * 2);
			
			// 배열 업데이트, cntMax값 갱신
			for (int size = 0; size < 100; size+=2) {
				// pqueue가 비어있지 않으면
				if( !pqueue.isEmpty() ) {
					int[] cur = pqueue.poll();
					A[size][i] = cur[0];
					A[size+1][i] = cur[1];
				// 더 업데이트할 값이 없는데, 맵에 값이 남아 있다면 0으로 초기화
				} else {
					A[size][i] = 0;
					A[size+1][i] = 0;
				}
			}
			
			// pqueue 초기화( 인덱스 100 이상 넘으면 버려야 됨 )
			pqueue.clear();
		}
	}

}
