import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2638_치즈 {
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N,M;
	static int[][] map;
	static int[][] cheeze;
	
	static int result = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void print(int[][] arr) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void BFS() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.add(new Point(0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int k=0;k<4;k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				if(map[nx][ny] == 1) {
					cheeze[nx][ny]++;
				}
				else {
					q.add(new Point(nx,ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	public static boolean isCheeze() {
		boolean isExist = false;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(cheeze[i][j] >= 2) {
					map[i][j] = 0;
					isExist = true;
				}
			}
		}
		
		return isExist;
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cheeze = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//
		while(true) {
			BFS();
			//print(cheeze);
			if(!isCheeze()) {
				System.out.println(result);
				return;
			}
			cheeze = new int[N][M];
			result++;
		}
		
		
	}

}
