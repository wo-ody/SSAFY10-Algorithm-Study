import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 동 남 서 북
	// 0 1 2 3
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static Dice dice;
	static StringTokenizer st;
	static int N, M, K, direction, answer;
	static int[][] array, dfsCalcResult;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		// 변수 초기화
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new int[N+1][M+1];
		dfsCalcResult = new int[N+1][M+1];
		dice = new Dice();
		
		// 배열 입력받기
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// bfs를 돌며  해당 자리에서 획득 가능한 점수값들을 미리 계산한다.
		// -> 해당 자리 방문하면 해당 자리의 dfcCalcResult 값을 바로 받으면 된다. 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(dfsCalcResult[i][j]!=0) continue;
				
				bfs(i, j);
			}
		}
		
		// 주사위로 이동하며 해당 자리에서 획득 가능한 점수값 (bfsCalcResult)을 획득한다.
		// K번만큼만 이동이 가능하다.
		direction = 0; // 처음 방향 동쪽
		answer = 0; // 처음 정답 0 
		int y = 1, x = 1;
		for(int i = 0; i<K; i++) {
			int[] nextLocation = step1(y, x); // step1을 통해 다음 목적지 좌표를 얻는다.
			y = nextLocation[0];
			x = nextLocation[1];
			
			step2(y, x); // {ny, nx} step2 를 통해 다음 목적지에 방문하여 도착한 칸의 점수를 얻는다.
			step3(y, x); //step3 를 통해 다음 이동 방향을 결정한다.
		}

		
		// 결과 출력
		System.out.println(answer);
		
		
	}
	
	// 1번째 순서.
	static int[] step1(int y, int x) {
		
		// 다음 목적지 좌표 확인하기 위해 계산
		int nx = x + dx[direction];
		int ny = y + dy[direction];
		
		// 이동 방향에 칸이 없으면 방향을 반대로 바꾸기
		if(nx < 1 || nx > M || ny < 1 || ny > N) {
			if(direction == 0) direction = 2;
			else if(direction == 1) direction = 3;
			else if(direction == 2) direction = 0;
			else if(direction == 3) direction = 1;
		}
		
		// 목적지가 바꼈을 수도 있으므로 다시 계산
		ny = y + dy[direction];
		nx = x + dx[direction];
		
		
		// 다음 목적지 좌표 반환.
		return new int[] {ny, nx};
	}
	
	static void step2(int y, int x) {
		// 다음 목적지 방향으로 주사위 한 번 구르기
		if(direction == 0) dice.moveRight();
		else if(direction == 1) dice.moveDown();
		else if(direction == 2) dice.moveLeft();
		else if(direction == 3) dice.moveUp();
		
		// 목적지 도착하여 값 계산하여 answer 갱신.
		answer += dfsCalcResult[y][x];
		return;
	}
	
	static void step3(int y, int x) {
		int A = dice.getFloorNum();
		// 주사위 바닥에 있는 수가 주사위 있는 칸에 있는 정수보다 값이 큰 경우
		if(A > array[y][x]) {
			// 주사위 방향 시계 방향 돌리기
			//dice.moveClockWise();
			// 방향 전환하기
			if(direction == 0) direction = 1;
			else if(direction == 1) direction = 2;
			else if(direction == 2) direction = 3;
			else if(direction == 3) direction = 0;
		}
		// 주사위 바닥에 있는 수가 주사위 있는 칸에 있는 정수보다 값이 큰 경우
		else if(A < array[y][x]) {
			// 주사위 방향 반시계 방향 돌리기
			//dice.moveCounterClockWise();
			// 방향 전환하기
			if(direction == 0) direction = 3;
			else if(direction == 1) direction = 0;
			else if(direction == 2) direction = 1;
			else if(direction == 3) direction = 2;
		}
	}
	
	
	// bfs를 돌며  해당 자리에서 획득 가능한 점수값들을 미리 계산한다.
	static void bfs(int i, int j) {
		Queue<Integer[]> bfsQ = new ArrayDeque<>();
		Queue<Integer[]> resultQ = new ArrayDeque<>();
		
		
		// bfs
		// 같은 값의 개수를 탐색하며 resultQ에 좌표를 추가한다.
		bfsQ.offer(new Integer[] {i, j});
		resultQ.offer(new Integer[] {i, j});
		dfsCalcResult[i][j] = 1;
		
		while(!bfsQ.isEmpty()) {
			Integer[] item = bfsQ.poll();
			int y = item[0];
			int x = item[1];

			
			// 그 다음 목적지 큐에 추가 하기.
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx<1 || nx> M || ny<1 || ny> N) continue;
				
				if(dfsCalcResult[ny][nx] == 0 && array[ny][nx] == array[y][x]) {
					// 방문한 곳이므로  방문 처리
					bfsQ.offer(new Integer[] {ny, nx});
					resultQ.offer(new Integer[] {ny, nx});
					dfsCalcResult[ny][nx] = 1;
				}
			}
		}
		
		// cnt * 값으로 해당 좌표들을 채운다.
		int maxScore = resultQ.size() * array[i][j];
		while(!resultQ.isEmpty()) {
			Integer[] item = resultQ.poll();
			int y = item[0];
			int x = item[1];
			dfsCalcResult[y][x] = maxScore;
		}
	}
	
	static class Dice{
		int[][] dice = {
				{0, 2, 0},
				{4, 1, 3},
				{0, 5, 0},
				{0, 6, 0}
		};
		
		void moveRight(){
			int tmp = dice[1][2];
			for(int i=2; i>0; i--) {
				dice[1][i] = dice[1][i-1];
			}
			dice[1][0] = dice[3][1];
			dice[3][1] = tmp;
		}
		
		void moveLeft() {
			int tmp = dice[1][0];
			for(int i=0; i<2; i++) {
				dice[1][i] = dice[1][i+1];
			}
			dice[1][2] = dice[3][1];
			dice[3][1] = tmp;
		}
		
		void moveUp() {
			int tmp = dice[0][1];
			for(int i=0; i<3; i++) {
				dice[i][1] = dice[i+1][1];
			}
			dice[3][1] = tmp;
		}
		
		void moveDown() {
			int tmp = dice[3][1];
			for(int i=3; i>0; i--) {
				dice[i][1] = dice[i-1][1];
			}
			dice[0][1] = tmp;
		}
		
		void moveClockWise() {
			int tmp = dice[0][1];
			dice[0][1] = dice[1][0];
			dice[1][0] = dice[2][1];
			dice[2][1] = dice[1][2];
			dice[1][2] = tmp;
		}
		void moveCounterClockWise() {
			int tmp = dice[0][1];
			dice[0][1] = dice[1][2];
			dice[1][2] = dice[2][1];
			dice[2][1] = dice[1][0];
			dice[1][0] = tmp;
		}
		
		int getFloorNum () {
			return dice[3][1];
		}
	}
}
