package algorithm2023.oct.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class BOJ_1261_알고스팟 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	
	//가로가 M, 세로가 N인 미로
	static int M,N,maze[][];
	
	//방향 벡터
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	//좌표 저장할 클래스, d는 벽을 부순 횟수
	static class Pos{
		int y,x,d;

		public Pos(int y, int x,int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
		
	}
	
	//좌표의 유효성 검사
	static boolean isValid(int y, int x) {
		if(y<0||x<0||y>=N||x>=M)return false;
		return true;
		
	}
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		
		for(int i =0 ;i<N;i++) {
			String[] s = br.readLine().split("");
			for(int j =0;j<M;j++) {
				maze[i][j] = Integer.parseInt(s[j]);
			}
		}
		
//		입력 종료
		
		
		
		//거리가 모두 동일하므로 벽을 부순 횟수를 기준으로 다익스트라 실행
		PriorityQueue<Pos> pq = new PriorityQueue<>((o1,o2)->o1.d-o2.d);
		pq.add(new Pos(0,0,0));
		
		
		//다익스트라를 사용하기 위한 dijk배열
		int[][] dijk = new int[N][M];
		//최솟값 기준으로 갱신해야 하므로 Integer.MAX_VALUE로 초기화
		for(int i= 0;i<N;i++) {
			Arrays.fill(dijk[i], Integer.MAX_VALUE);
		}
		
		//다익스트라 시행
		while(!pq.isEmpty()) {
			Pos cur = pq.poll();
			//4 방향을 모두 살피며
			for(int d = 0;d<4;d++) {
				int ny = cur.y+dy[d];
				int nx = cur.x+dx[d];
				if(!isValid(ny,nx))continue;
				//현재까지의 비용
				int cost = cur.d;
				//벽이라면 비용 추가
				if(maze[ny][nx]==1) {
					cost++;
				}
				//다음 좌표에 저장된 벽을 부수는 횟수보다 더 적은 횟수로 갈 수 있다면 갱신.
				if(dijk[ny][nx]>cost) {
					dijk[ny][nx] = cost;
					pq.add(new Pos(ny,nx,cost));
				}
			}
		}
		//사이즈가 1*1이라면 답0
		if(N==1&&M==1)dijk[0][0] = 0;
		System.out.println(dijk[N-1][M-1]);
	}
}
