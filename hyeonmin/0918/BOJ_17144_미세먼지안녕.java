import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {

	static int R, C, T;
	static int[][] map, mapCopy;
	static int acTopY, acBottomY;
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		mapCopy = new int[R][C];
		
		// 맵 만들기
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = mapCopy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 공기청정기 위치 찾기 : 가장 먼저 발견한 지점이 공기청정기의 윗부분이다.
		for (int i = 0; i < R; i++) {
			if(map[i][0] == -1) {
				// air cleaner Top and Bottom Y coordinate
				acTopY = i;
				acBottomY = acTopY+1;
				break;
			}
		}
		
		// 이 모든걸 T번 반복
		for (int t = 0; t < T; t++) {
			// 1. 먼지 확산 => 고려사항 : -1이거나 벽일경우
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] <= 0) continue;
					spreadDust(i, j);
				}
			}
			
			// 맵 덮어쓰기
			for (int i = 0; i < R; i++) {
				System.arraycopy(mapCopy[i], 0, map[i], 0, C);
			}

			// 2. 공기청정기 작동
			// 공기청정기 안으로 들어가는 먼지를 제거하고 시작
			map[acTopY-1][0] = map[acTopY+2][0] = 0;
			cycle();
			
			// 맵 다시 복사하기
			for (int i = 0; i < R; i++) {
				System.arraycopy(map[i], 0, mapCopy[i], 0, C);
			}
		}
		
		// 미세먼지 양 확인
		int sumDust = 2; // 공기청정기 때문에 +2 해줌
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sumDust += map[i][j];
			}
		}
		
		System.out.println(sumDust);
	}
	static void cycle() {
		// 모든 이동경로에 대한 좌표로 move 함수 실행
		// 순서는 	Top : DOWN, LEFT, UP, RIGHT
		// 		Bottom : UP, LEFT, DOWN, RIGHT
		
		// 배열 인덱스 계산
		int r = R-1;
		int c = C-1;
		
		// move(startY, startX, endY, endX)
		move(0,0,acTopY,0); 
		move(0,c,0,0);
		move(acTopY,c,0,c);
		move(acTopY,0,acTopY,c);
		
		move(r,0,acBottomY,0);
		move(r,c,r,0);
		move(acBottomY,c,r,c);
		move(acBottomY,0,acBottomY,c);
		
		// 0이 되버린 공기청정기 자리 다시 -1로 만들어주기
		map[acTopY][0] = map[acBottomY][0] = -1;
	}
	
	// startY, startX, endY, endX
	static void move(int y1, int x1, int y2, int x2) {
		// 항상 목적지부터 출발지 순으로 차례대로 한칸씩 이동시킨다.
		
		// UP
		if(y1 > y2) {
			for (int i = y2; i < y1; i++) {
				map[i][x1] = map[i+1][x1];
			}
			map[y1][x1] = 0; // 마지막으로 이동한 자리 빈자리 만들어주기
			
		// DOWN
		} else if(y1 < y2) {
			for (int i = y2; i > y1; i--) {
				map[i][x1] = map[i-1][x1];
			}
			map[y1][x1] = 0; // 마지막으로 이동한 자리 빈자리 만들어주기
			
		// LEFT
		} else if(x1 > x2) {
			for (int i = x2; i < x1; i++) {
				map[y1][i] = map[y1][i+1];
			}
			map[y1][x1] = 0; // 마지막으로 이동한 자리 빈자리 만들어주기
			
		// RIGHT
		} else {
			for (int i = x2; i > x1; i--) {
				map[y1][i] = map[y1][i-1];
			}
			map[y1][x1] = 0; // 마지막으로 이동한 자리 빈자리 만들어주기
		}
		
	}
	
	static void spreadDust(int y, int x) {
		int ny = y;
		int nx = x;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if( isOutRange(ny, nx) || map[ny][nx] == -1 ) continue;
			int dust = map[y][x] / 5;
			mapCopy[ny][nx] += dust;
			mapCopy[y][x] -= dust;
		}
	}

	static boolean isOutRange(int y, int x) {
		return y<0 || y>=R || x<0 || x>=C;
	}
	
}
