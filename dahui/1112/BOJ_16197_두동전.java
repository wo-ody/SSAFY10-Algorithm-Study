package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16197_두동전 {
	//두 동전 중 하나만 떨어뜨리기 //둘다 떨어뜨릴수 없거나 
	//하나만 떨어뜨리는게 불가능하거나 10번보다 많이눌러야하면 -1
	static char[][] board;
	static int N,M,ans;
	static int[] coin1, coin2; //각 코인의 y좌표 : 0 , x좌표 : 1
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		coin1 = new int[2];
		coin2 = new int[2];
		
		boolean coin = false;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				board[i][j] = str.charAt(j);
				if(board[i][j] == 'o') {
					if(!coin) {
						coin1[0] = i;
						coin1[1] = j;
						coin = true;
					}else {
						coin2[0] = i;
						coin2[1] = j;
					}
				}
			}
		}
		
		System.out.println(bfs()==-1?-1:ans);
		
		
	}
	
	static int bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(coin1[0], coin1[1], coin2[0], coin2[1], 0));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int y1 = n.y1;
			int x1 = n.x1;
			int y2 = n.y2;
			int x2 = n.x2;
			int cnt = n.cnt;
			
			if(cnt >= 10) return -1;
			
			for(int d=0; d<4 ;d++) {
				int ny1 = y1 + dy[d];
				int nx1 = x1 + dx[d];
				int ny2 = y2 + dy[d];
				int nx2 = x2 + dx[d];
				
				boolean c1 = CanGo(ny1,nx1);
				boolean c2 = CanGo(ny2,nx2);
				
				if(!c1 && !c2) continue; //둘다 맵 밖이면 넘기기
				else if(c1 && c2) { //둘다 움직일 수 있으면 벽인지 체크하고 좌표 넘기기
					if(wall(ny1, nx1) && wall(ny2, nx2)) { //둘다 벽이면
						continue; //셀 필요 없음 
					}else if(wall(ny1, nx1)) { // coin1이 움직일 곳이 벽이면 
						q.add(new Node(y1, x1, ny2, nx2, cnt+1));
					}else if(wall(ny2, nx2)) { //coin2가 움직일 곳이 벽이면
						q.add(new Node(ny1, nx1, y2, x2, cnt+1)); 
					}else { //둘다 움직일 수 있다면
						q.add(new Node(ny1, nx1, ny2, nx2, cnt+1));
					}
				}else { //하나만 밖이면 
					return ans = cnt+1;
				}
			}
		}
		
		return -1;
	}
	static boolean CanGo (int y, int x) {
		if(y < 0 || x < 0 || y >= N || x >= M) return false;
		return true;
	}
	
	static boolean wall(int y, int x) {
		if(board[y][x] == '#') return true;
		return false;
	}
	
	public static class Node {
		int y1,x1,y2,x2,cnt;
		public Node(int y1, int x1, int y2, int x2, int cnt) {
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
			this.cnt = cnt;
		}
	}
}
