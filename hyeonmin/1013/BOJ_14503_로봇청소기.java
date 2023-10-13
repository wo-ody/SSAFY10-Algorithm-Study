package month10.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {

	static int N, M, r, c, d, cnt;
	static int[][] map;
	static boolean[][] visit;
	
	static final int DIRTY = 0;
	static final int WALL = 1;
	static final int CLEAN = -1;
	
					//  상    우     하     좌
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 3 <= N,M <= 50
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// (r,c) , d
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go(r, c, d);
		// 0 : 더러움, 1 : 벽, -1 : 청소 완료
		
		System.out.println(cnt);
	}
	
	static void go(int y, int x, int d) {
		// 1. 현재 칸이 더러운칸이면 청소
		if(map[y][x] == DIRTY) {
			map[y][x] = CLEAN;
			cnt++; // 청소 횟수 기록
		}
		
		// 주변 4칸에 빈칸이 없는 경우? 방향 반대로 한칸 후진
		// 지금 내 방향의 다음 방향부터 탐색 4방향 탐색
		// 		d:1,	0 3 2 1
		Boolean possibleMove = false;
		int ny = 0;
		int nx = 0;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if( map[ny][nx] == DIRTY ) possibleMove = true;
		}
		
		// 전진이 가능한 경우?
		if ( possibleMove ) {
			int turn = (d-1+4)%4; // 반시계방향 90도
			ny = y + dy[turn];
			nx = x + dx[turn];
			if( map[ny][nx] == DIRTY ) {
				// 90도 turn 후 앞에 DIRTY가 있으면? 전진
				go(ny, nx, turn);
			} else {
				go(y, x, turn); // 회전만 하고 다시 탐색
			}
		// 전진이 불가능한 경우?
		} else {
			int back = (d+2) % 4; // 뒤로 이동
			int by = y + dy[back];
			int bx = x + dx[back];
			if( map[by][bx] == CLEAN ) {
				go(by, bx, d); 
			}
		}
	}
	
	
}
