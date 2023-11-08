package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 한 번만 부수기 가능 
//맵 1000*1000 -> 1,000,000
//부쉈던 벽이라면 표시하기(map에서 2로 변경) + 부수고 가고 있는지 체크하기
public class BOJ_2206_벽부수고이동하기 {
	static int[][] map;
	static boolean[][] visit,wall; //부순상태로 들렸다면 wall을 체크 
	static int N,M,ans;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		wall = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		boolean possible = simulation();
		if(possible) System.out.println(ans);
		else System.out.println(-1);
	}
	
	static boolean simulation() {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0,0,1,false));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int y = n.y;
			int x = n.x;
			int cnt = n.cnt;
			boolean bw = n.breakWall;
			
			if(y==N-1 && x==M-1) {
				ans = cnt;
				return true;
			}
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M ) continue;
				
				
				//벽을 부수고 간 상태 -> map == 0이고 방문 안한 곳일때만 이동 가능 
				if(bw) {
					if(map[ny][nx] == 0 && !wall[ny][nx]) {
						q.add(new Node(ny, nx, cnt+1, bw));
						wall[ny][nx] = true;
					}
				}else {//벽을 안 부수고 간 상태  ->map==2이면 못감,  
					//map == 1이면 부수고 가기(부순 벽 체크, 부수고갔다고 체크),
					if(map[ny][nx] == 1 && !visit[ny][nx]) {
						q.add(new Node(ny, nx, cnt+1, true));
						visit[ny][nx] = true;
					}else if(map[ny][nx] == 0 && !visit[ny][nx]){//0이면 그냥 가기 
						q.add(new Node(ny, nx, cnt+1, bw));
						visit[ny][nx] = true;
					}
				}
			}
		}
		return false;
	}
	
	public static class Node{
		int y, x, cnt;
		boolean breakWall;
		public Node(int y, int x, int cnt, boolean breakWall) {
			this.cnt = cnt;
			this.y = y;
			this.x = x;
			this.breakWall = breakWall;
		}
	}
}
