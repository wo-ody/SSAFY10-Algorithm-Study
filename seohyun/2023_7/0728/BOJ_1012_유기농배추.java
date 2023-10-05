import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1012_유기농배추 {
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static int T,N,M,K;
	static int[][] map;
	static int result = 0;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[M][N];
		
		q.add(new Point(x,y));
		visited[x][y] = true;
		map[x][y] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int cx = p.x;
			int cy = p.y;
			for(int k=0;k<4;k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny]) continue;
				if(map[nx][ny] == 1) {
					q.add(new Point(nx,ny));
					visited[nx][ny] = true;
					map[nx][ny] = 0;
				}
			}
		}
	}
	
	public static void solve() {
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 0) continue;
				BFS(i,j);
				result++;
			}
		}
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			//입력
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			//함수 돌리기
			solve();
			
			System.out.println(result);
			result = 0;
			
		}
		
	}

}
