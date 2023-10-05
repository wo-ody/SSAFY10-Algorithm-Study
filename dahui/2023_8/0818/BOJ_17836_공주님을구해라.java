import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//검을 가지고 가는 경우와, 안 가지고 가는 경우 나누어서 돌리기
//검까지 가는 bfs, 해당 bfs에서 결과값으로 나온 t를 목적지까지 가는 bfs에 검의 위치와 함께 넣기
//둘다 구출 가능하다면 적은 시간 가져오기
//구출할 수 없으면 "Fail" 출력
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N,M,T; //성의 크기 N*M, 구해야하는 시간 T
	static int[][] map,copyMap; // 0:길 1:벽 2:검
	static boolean[][] visit;
	static int time1, time2, time;
	static int[] dy = {-1, 1, 0, 0}; //상하좌우
	static int[] dx = {0, 0, -1, 1};
	static Node gram; //검의 위치
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copyMap = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copyMap[i][j] = map[i][j];
				if(map[i][j] == 2) {
					gram = new Node(i, j, 0); //검의 위치 저장
				}
			}
		}
		int toGram = bfsGram(0,0,0); //검까지 가는 time 가져오기
		
		for(int i=0;i<N; i++) {
			Arrays.fill(map[i], 0);
		}//벽 부수기
		visit = new boolean[N][M]; //방문 초기화하고 처음부터
		
		boolean result2 = bfs(gram.y, gram.x, toGram);//검의 위치에서 도착까지 time2
		time2 = time;
		
		for(int i=0; i<N; i++) { //맵 원래대로 돌려놓기
			for(int j=0; j<M; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
		visit = new boolean[N][M]; //방문 초기화하고 처음부터
		
		boolean result1 = bfs(0,0,0); //처음위치에서 도착까지 time1
		time1 = time;
		
		if(result1 && result2) { //둘다 성공이면
			time = Math.min(time1, time2);
			System.out.println(time);
		}else if(result1) {
			time = time1;
			System.out.println(time);
		}else if(result2) {
			time = time2;
			System.out.println(time);
		}else  //둘다 실패면
			System.out.println("Fail");
		
	}
	
	static boolean bfs(int y, int x, int t) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(y, x, t));
		visit[y][x] = true;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int tempY = temp.y;
			int tempX = temp.x;
			int tempT = temp.t;
			
			if(tempT > T) return false; //시간초과로 실패
			
			if(tempY == N-1 && tempX == M-1) { //도착하면 시간 가져오기, true 반환
				time = tempT;
				return true;
			}
			
			for(int i=0; i<4; i++) { //4방향
				int ny = tempY + dy[i];
				int nx = tempX + dx[i];
				//맵밖을 벗어나지 않고, 방문하지 않았고, 벽이 아니면 이동
				if(ny >= 0 && nx >= 0 && ny < N && nx < M && !visit[ny][nx] && map[ny][nx] != 1) {
					visit[ny][nx] = true;
					q.add(new Node(ny, nx, tempT + 1));
				}
			}
		}
		//공주에게 도착하지 못했다면
		time = Integer.MAX_VALUE;
		return false;
	}
	
	static int bfsGram(int y, int x, int t) { //검에 도착한 시간  return
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(y, x, t));
		visit[y][x] = true;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int tempY = temp.y;
			int tempX = temp.x;
			int tempT = temp.t;
			
			if(tempY == gram.y && tempX == gram.x) { //도착하면 시간 가져오기, true 반환
				return tempT;
			}
			
			for(int i=0; i<4; i++) { //4방향
				int ny = tempY + dy[i];
				int nx = tempX + dx[i];
				//맵밖을 벗어나지 않고, 방문하지 않았고, 벽이 아니면 큐에 집어넣기 
				if(ny >= 0 && nx >= 0 && ny < N && nx < M && !visit[ny][nx] && map[ny][nx] != 1) {
					visit[ny][nx] = true;
					q.add(new Node(ny, nx, tempT + 1));
				}
			}
		}
		
		//검에 도착 못했다면
		return Integer.MAX_VALUE;
	}
	
	static class Node {
		int y;
		int x;
		int t;
		
		public Node(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}
	}
}
