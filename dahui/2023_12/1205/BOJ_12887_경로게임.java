package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_12887_경로게임 {
	static int M, blackCnt, ans, mapCnt;
	static char[][] map;
	static boolean[][] visit;
	static int[] dy = {-1,0,1}; //왼쪽으로는 가지 않음
	static int[] dx = {0,1,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		
		map = new char[2][M];
		
		for(int i=0; i<2; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '#') blackCnt++;
			}
		}
		
		mapCnt = 2*M; // 총 맵 칸수
		
		if(map[0][0] == '.') ans = bfs(0,0);
		if(map[1][0] == '.') ans = Math.max(ans, bfs(1,0));
		
		System.out.println(ans);
	}
	
	public static int bfs(int y, int x) {
		Queue<Node> q = new ArrayDeque<>();
		visit = new boolean[2][M];
		
		q.add(new Node(y,x,1));
		visit[y][x] = true;
		
		while(true) {
			Node n = q.poll();
			
			if(n.x == M-1) { //도착했다면 
				int a = mapCnt - (n.cnt + blackCnt);
				return a;
			}
			
			for(int d=0; d<3; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];
				
				if(ny<0 || nx<0 || ny>=2 || nx>=M || map[ny][nx] == '#'|| visit[ny][nx] == true) continue;
				
				visit[ny][nx] = true;
				q.add(new Node(ny, nx, n.cnt+1));
			}
		}
	}
	
	public static class Node {
		int y,x,cnt;
		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
