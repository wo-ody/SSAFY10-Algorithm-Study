package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {
	static int N,M,ans;
	static int[] dy = {-1,1,0,0,1,1,-1,-1};
	static int[] dx = {0,0,-1,1,1,-1,1,-1}; 
	static int[][] ocean;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ocean = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				ocean[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int length = 0;
				if(ocean[i][j] == 1) {
					length = 0;
				}else {
					visit = new boolean[N][M];
					length = bfs(i,j);
				}
				
				ans = Math.max(length, ans);
			}
		}
		
		System.out.println(ans);

	}
	
	static int bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {y,x,0});
		visit[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int py = node[0];
			int px = node[1];
			int length = node[2];
			
			if(ocean[py][px] == 1) {
				return length;
			}
			
			for(int d=0; d<8; d++) {
				int ny = py + dy[d];
				int nx = px + dx[d]; 
				
				if(ny<0 || nx<0 || ny>=N || nx>=M || visit[ny][nx]) continue;
				
				q.add(new int[] {ny, nx, length+1});
				visit[ny][nx]=true;
			}
		}
		return 0;
	}
}
