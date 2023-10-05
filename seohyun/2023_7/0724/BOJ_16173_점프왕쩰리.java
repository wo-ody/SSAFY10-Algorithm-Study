import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16173_점프왕쩰리 {
	static int N;
	static int[][] map;
	static boolean canGo;
	static boolean[][] visited;
	
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	

	public static void DFS(int x, int y) {
		if(canGo) return;
		
		visited[x][y] = true;
		if(map[x][y] == -1) {
			canGo = true;
			return;
		}
		
		for(int k = 0;k<2;k++) {
			int nx = x + (dx[k] * map[x][y]);
			int ny = y + (dy[k] * map[x][y]);
			if(nx<0 || nx>= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
			DFS(nx,ny);
			visited[nx][ny] = false;
		}
			
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0,0);
		if(canGo) System.out.println("HaruHaru");
		else System.out.println("Hing");
		
		
	}
	

}
