package month10.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {

	static int N, NN;
	
	static int[][] map;
	static int[][] info;
	static int sitOrder[];
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static int mask = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 3 ≤ N ≤ 20
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		// map 배열 -1로 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], -1);
		}
		
		NN = N * N; // N^2 로 업데이트
		info = new int[NN][4]; // N^2명의 학생과 4명의 좋아하는 학생
		sitOrder = new int[NN]; // 순서기록
		
		// 입력 
		for (int i = 0; i < NN; i++) {
			st = new StringTokenizer(br.readLine());
			sitOrder[i] = Integer.parseInt(st.nextToken()) -1;
			
			for (int j = 0; j < 4; j++) {
				info[ sitOrder[i] ][j] = Integer.parseInt(st.nextToken()) -1;
			}
		}
		
		// 모든 학생들 자기 자리 찾으러 가기
		for (int i = 0; i < NN; i++) {
			checkMySeat(sitOrder[i]);	
		}
		
		// 모든 학생의 만족도 구하기
		int sum = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {

				int cnt = 0; // 인접칸 좋아하는 학생 수
				
				// 인접칸
				for (int d = 0; d < 4; d++) {
					int ny = r + dy[d];
					int nx = c + dx[d];
					if ( isOutRange(ny, nx) ) continue;
					
					for (int i = 0; i < 4; i++) {
						if( map[ny][nx] == info[map[r][c]][i] ) cnt++;
					}
				}
				
				switch (cnt) {
				case 0 : sum += 0; break;
				case 1 : sum += 1; break;
				case 2 : sum += 10; break;
				case 3 : sum += 100; break;
				case 4 : sum += 1000; break;
				}
				
			}
		}

		// 정답 출력
		System.out.println(sum);
		
		// 1. 좋아하는 학생이 인접한 칸에 가장 많은 칸
		// 2. 인접칸 중 비어있는 칸이 많은 칸
		// 3. 행의 번호가 가장 작은 칸
		// 4. 열의 번호가 가장 작은 칸
		
		// -> 왼쪽 위부터 탐색하고, 
		// 사방 탐색 후 좋아하는 학생이 가장 많은 칸이 생기면 업데이트1
		// 같은 개수의 칸이 나오게 되면 인접칸중 비어있는 칸계산 후 업데이트
		
		// 학생의 만족도는 자리 배치가 모두 끝난 후에 구할 수 있다.
		// 학생의 만족도를 구하려면 그 학생과 인접한 칸에 앉은 좋아하는 학생의 수를 구해야 한다.
		// 그 값이 0이면 학생의 만족도는 0, 1이면 1, 2이면 10, 3이면 100, 4이면 1000이다.
	}
	
	static void checkMySeat(int selectStudent) {
		int max = -1;
		// 선택 좌표
		int selectY = 0; 
		int selectX = 0;
		
		// 모든 자리 고려
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				// 이미 앉아 있으면 continue
				if( map[r][c] != -1 ) continue;
				
				// 좋아하는 친구의 수
				int cnt = countMyLove(selectStudent, r, c);
				// 더 많은 칸이 나타나면?
				if( max < cnt ) {
					max = cnt;
					// 선택한 좌표 업데이트
					selectY = r;
					selectX = c;
				// 같다면?
				} else if( max == cnt ) {
					// 같으면 인접칸 중 비어 있는 칸 계산 후 업데이트
					if( countBlank(selectY, selectX) < countBlank(r, c) ) {
						// 선택한 좌표 업데이트
						selectY = r;
						selectX = c;
					}
				}
			}
		}
		// 앉힌다.
		map[selectY][selectX] = selectStudent;

	}
	
	static int countMyLove(int selectStudent, int y, int x) {
		int cnt = 0; // 인접칸 좋아하는 학생 수
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if ( isOutRange(ny, nx) || map[ny][nx] == -1 ) continue;
			// 좋아하는 학생이면 cnt 증가
			for (int i = 0; i < 4; i++) {
				if( map[ny][nx] == info[selectStudent][i] ) cnt++;
			}
		}
		return cnt;
	}
	
	static int countBlank(int y, int x) {
		int cnt = 0; // 빈칸 개수
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if ( isOutRange(ny, nx) || map[ny][nx] != -1 ) continue;
			cnt++;
		}
		return cnt;
	}
	
	static boolean isOutRange(int y, int x) {
		return y >= N || y < 0 || x >= N || x < 0;
	}

}
