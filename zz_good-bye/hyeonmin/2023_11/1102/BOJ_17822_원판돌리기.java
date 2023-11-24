package month11.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17822_원판돌리기 {

	static int N, M, T;
	static int x, d, k;
	
	static boolean removed;
	static int[][] map;
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 배열의 왼쪽과 오른쪽을 연결한 형태
		
		// start. 입력
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// T번 반복해야됨
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); // 원판번호
			d = Integer.parseInt(st.nextToken()); // 방향, 0:시계, 1:반시계
			k = Integer.parseInt(st.nextToken());
			
			// 1. x의 배수 원판들 d방향으로 k번 회전 시키기
			for (int i = 1; i*x <= N; i++) {
				spin(i*x-1); // 배열이 0부터시작하기 때문에 -1 해서 보정해야됨
			}
			// 2. 원판에 인접한 수들 탐색하기 ??
			// M은 연결되어 있는 것도 잘 체크해야됨 -> M 이랑 1만 한번 더 확인해주면 됨
			// N은 연결되어 있지는 않지만 인접된거 잘 찾아야됨
			
			// 조건을 만족하는 완탐으로 해결 가능
			removed = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 이미 지워진 곳 제외하고 탐색
					if (map[i][j] == 0) continue;
					remove(i, j, map[i][j]);
				}
			}
			// 없는 경우에는 원판에 적힌 수의 평균을 구하고, 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더한다.
			if(!removed) {
				float avg = (float) sum() / (float) count();
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						// 지워진 곳은 제외
						if (map[i][j] == 0) continue;
						if(map[i][j] > avg) map[i][j]--;
						else if(map[i][j] < avg) map[i][j]++;
					}
				}
			}

		}
		// end. 원판에 적힌 수의 합 출력
		System.out.println( sum() );
		
	}
	
	static int count() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) count++;
			}
		}
		return count;
	}
	
	static int sum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}
	
	static void remove(int y, int x, int removeNum) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {y, x});
		boolean removedCur = false;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur[0] + dy[d];
				int nx = cur[1] + dx[d];
				
				// y는 연결 안되어 있음
				if ( ny >= N || ny < 0 ) continue;
				// x는 연결되어 있음 (보정)
				if (nx >= M ) nx = 0;
				else if(nx < 0) nx = M-1;
				
				// 지워야하는 번호랑 같은지 확인
				if ( map[ny][nx] == removeNum ) {
					removed = true;
					removedCur = true;
					// 같으면 지워버리기
					map[ny][nx] = 0;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
		
		// 자기 자신도 지워주기
		if( removedCur ) map[y][x] = 0;
		
	}
	
	static void spin(int n) {
		// k칸 이동
		for (int i = 0; i < k; i++) {
			// 시계 방향
			if(d==1) {
				int temp = map[n][0];
				for (int j = 0; j < M-1; j++) {
					map[n][j] = map[n][j+1]; // 한칸씩 이동
				}
				map[n][M-1] = temp;
				
			} // 반시계 방향
			else {
				int temp = map[n][M-1];
				for (int j = M-1; j > 0; j--) {
					map[n][j] = map[n][j-1];
				}
				map[n][0] = temp;
			}	
		}
		
	}

}
