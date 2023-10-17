package month10.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610_마법사상어와비바라기 {

	static int N, M;
	
	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	
	static int[][] map;
	static boolean[][] visitCloud;
	static Queue<int[]> clouds = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 본 문제에서는 1부터 N이지만, 이 풀이에서는 0부터 N-1 로 처리
		map = new int[N][N];
		visitCloud = new boolean[N][N];
		
		// 입력
		// 둘째 줄부터 N개의 줄에는 N개의 정수가 주어진다. r번째 행의 c번째 정수는 A[r][c]를 의미한다.
		// 다음 M개의 줄에는 이동의 정보 di, si가 순서대로 한 줄에 하나씩 주어진다.
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 비바라기를 시전하면  (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다
		// -> 왼쪽 아래 4칸에 비구름 생김
//		cloud[N-1][0] = cloud[N-1][1] = cloud[N-2][0] = cloud[N-2][1] = true;
		clouds.offer(new int[] {N-1, 0});
		clouds.offer(new int[] {N-1, 1});
		clouds.offer(new int[] {N-2, 0});
		clouds.offer(new int[] {N-2, 1});
		
		// M번의 이동명령
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1; // 방향 (1~8 > 0~7 보정)
			int s = Integer.parseInt(st.nextToken()); // 거리
			
			// 1. 구름 이동
			move(d, s);
			
			// 3. 구름 사라짐 (이 때 사라지면 안됨, 마지막에 차례 때 사라져야 됨)
			// 4. 물이 증가한 칸의 대각선 1거리 되는 칸 중 물이 있는 칸의 개수 만큼 물의 양이 증가
			// (이 때, 범위 벗어나는 칸은 계산 안함)
			increase();
			
			// 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2줄어든다. 이 칸은 구름이 사라졌던 칸이면 안된다.
			makeCloud();
			
			// 6. 구름 배열을 초기화 해준다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visitCloud[i][j] = false;
				}
			}
		}
		
		// 정답 출력
		// 첫째 줄에 M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 출력한다.
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
	}
	
	static void move(int d, int s) {
		int size = clouds.size(); // 현재 구름의 개수
		for (int i = 0; i < size; i++) {
			int[] cur = clouds.poll();
							// (방향  X 거리) + 현재구름위치
			int ny = rangeCalc( dy[d] * s + cur[0] );
			int nx = rangeCalc( dx[d] * s + cur[1] );

			// visitCloud 에 기록
			visitCloud[ny][nx] = true;
			
			// 2. 구름있는 칸 물+1
			map[ny][nx] += 1;
			
			// 4번수행을 위해 다시 큐에 넣기
			clouds.offer(new int[] {ny, nx});
		}
	}
	
	static void increase() {
		int size = clouds.size(); // 현재 구름의 개수
		for (int i = 0; i < size; i++) {
			// 구름이 있었던 위치 하나씩 꺼내서 증가할 물의양 구하기
			int[] cur = clouds.poll();
			int y = cur[0];
			int x = cur[1];
			
			int cnt = 0;
			
			// 1, 3, 5, 7 방향 확인(대각선)
			for (int d = 1; d < 8; d+=2) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if( isOutRange(ny, nx) ) continue;
				if( map[ny][nx] > 0 ) cnt++;
			}
			
			// cnt 만큼 물의 양 증가
			map[y][x]+=cnt;
		}
	}
	
	static void makeCloud() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 구름이 생겼던 칸이면 continue
				if( visitCloud[i][j] ) continue;
				// 물의 양이 2이상인 모든 칸에 구름이 생기고 물의 양이 2 줄어든다.
				if( map[i][j] >= 2 ) {
					clouds.offer( new int[] {i, j} );
					map[i][j]-=2;
				}
			}
		}
	}
	
	static boolean isOutRange(int y, int x) {
		return y >= N || y < 0 || x >= N || x < 0;
	}
	
	// 맵의 처음과 끝이 연결되어 있을 때 거리를 계산해주는 함수
	static int rangeCalc(int n) {
		if( n >= N ) return rangeCalc(n-N);
		else if( n < 0 ) return rangeCalc(n+N);
		else return n;
	}
	
}
