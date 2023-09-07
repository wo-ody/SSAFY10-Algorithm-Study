package problem.solving;
import java.util.*;
import java.io.*;
import java.util.ArrayDeque;


public class BOJ_1388_바닥_장식 {
	static boolean[][] visited;
	static int N,M;
	static char [][] floor;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		floor = new char[N][M];
		
		for(int i = 0 ; i < N ; i ++) {
			floor[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j <M ; j ++) {
				if (visited[i][j] == false) {
					cnt ++;
					bfs(i,j);
				}
			}
		}
		System.out.println(cnt);
		
		
	}
	static int [] dx = {-1,0,0,1};
	static int [] dy = {0,-1,1,0};
	static void bfs(int i,int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int []{i,j});

		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			boolean verticle = true;
			
			if (floor[x][y] == '-') {
				verticle = true;
			}
			else {
				verticle = false;
			}
			for(int d = 0 ; d < 4 ; d ++) {
				if (verticle) {
					if (dy[d] == 0) continue;
				}
				else {
					if (dx[d] == 0 ) continue;
				}
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx>=N || nx < 0 || ny >= M || ny <0)
					continue;
				
				if (!visited[nx][ny]) {
					if (verticle) {
						if (floor[nx][ny] == '-') {
							queue.offer(new int [] {nx,ny});
							visited[nx][ny]  =true;
						}
					}
					else {
						if (floor[nx][ny] == '|') {
							queue.offer(new int [] {nx,ny});
							visited[nx][ny] = true;
						}
					}
				
				}
				
			}
		}
	}
}
