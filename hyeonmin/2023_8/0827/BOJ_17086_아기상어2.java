import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {
	
	static int N, M, maxAns;
	static int[][] map;
	static boolean[][] visit;
	
					  // 상    하     좌    우     좌상   우상   좌하   우하
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		maxAns = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) continue;
				maxAns = Math.max(maxAns, bfs(i, j) );
			}
		}
		
		System.out.println(maxAns);
	}
	
	static int bfs(int y, int x) {
		Queue<Point> queue = new ArrayDeque<>();
		visit = new boolean[N][M];
		
		queue.offer(new Point(y, x, 0));
		visit[y][x]= true; 
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int i = 0; i < 8; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				int nd = cur.d + 1;
				if(isInvalid(ny, nx) || visit[ny][nx]) continue;
				
				if(map[ny][nx] == 1) {
					return nd;
				}
				
				queue.offer(new Point(ny,nx,nd));
				visit[ny][nx] = true;
			}
		}
		return 0;
		
	}
	
	static boolean isInvalid(int y, int x) {
		return y < 0 || y >= N || x < 0 || x >= M;
	}
	
	static class Point {
		int y;
		int x;
		int d;
		Point(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

}
