package studyAuthenticating;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179_불 {
	static char[][] map;
	static int r, c;
	static Queue<Point> queue;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][] visited;
	static Point J;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean[r][c];
		queue = new LinkedList<>();
		
		for (int i = 0; i < r; i++){
			String stk = br.readLine();
			for (int j = 0; j < c; j++){
				map[i][j] = stk.charAt(j);
				if(map[i][j] == 'J'){
					if(canEscape(i,j)){
						System.out.println(1);
						return;
					}
					map[i][j] = '.';
					J = new Point(i, j, 0, 0);
				}
				else if (map[i][j] == 'F'){
					queue.offer(new Point(i, j, 1, 0));
				}
			}
		}
		bfs(queue);
		
	}
	static void bfs(Queue<Point> q){
		int x, y, count;		
		q.offer(J);
		visited[J.x][J.y] = true;
		while(!q.isEmpty()){
			Point p = q.poll();
			x = p.x;
			y = p.y;
			count = p.count;
			
			// 탈출조건 확인
			if(canEscape(x, y) && p.isFire == 0){
				System.out.println(count + 1);
				return;
			}
			
			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(!isRange(nx,ny) || map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
				
				if(p.isFire == 0 && !visited[nx][ny]){
					q.offer(new Point(nx, ny, p.isFire, count + 1));
					visited[nx][ny] = true;
				}
				else if(p.isFire == 1){
					map[nx][ny] = 'F';
					q.offer(new Point(nx, ny, p.isFire, count +1));
				}
			}			
		}
		System.out.println("IMPOSSIBLE");
	}
	
	// 배열의 가장자리에 도착했는지 확인
	static boolean canEscape(int x, int y){
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!isRange(nx,ny)){
				return true;
			}
		}
		return false;
	}
	
	// 배열의 범위 확인
	static boolean isRange(int x, int y){
		if (x >= 0 && y >= 0 && x < r && y < c) {
			return true;
		}
		return false;
				
	}
	
	// 현제 좌표, 불이 난 곳, 몇번만에 도착했는지 
	static class Point{
		int x, y, isFire, count;

		public Point(int x, int y, int isFire, int count) {
			super();
			this.x = x;
			this.y = y;
			this.isFire = isFire;
			this.count = count;
		}
	}
}
