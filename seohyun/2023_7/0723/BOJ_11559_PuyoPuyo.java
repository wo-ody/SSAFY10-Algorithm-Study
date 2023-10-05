import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_11559_뿌요뿌요 {
	static char[][] map = new char[12][6];
	static int result = 0;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static Queue<Point> BFS(int x,int y, char color){
		Queue<Point> returned = new LinkedList<>();
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[12][6];
		
		returned.add(new Point(x,y));
		q.add(new Point(x,y));
 		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			for(int k=0;k<4;k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || visited[nx][ny]) continue;
				if(map[nx][ny] == color) {
					returned.add(new Point(nx,ny));
					q.add(new Point(nx,ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		return returned;
				
	}
	
	public static void set_gravity() {
		for(int j=0;j<6;j++) {
			int px = 11;
			for(int i=11;i>=0;i--) {
				if(map[i][j] == '.') continue;
				if(i == px) {
					px--;
					continue;
				}
				map[px--][j] = map[i][j];
				map[i][j] = '.';
				
			}
		}
	}
	
	public static void solve() {
		while(true) {
			// 같은 색의 뿌요들 찾아서 반환 BFS
			boolean isExplode = false;
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(map[i][j] == '.') continue;
					Queue<Point> q = BFS(i,j,map[i][j]);
					if(q.size() >= 4) {
						isExplode = true;
						while(!q.isEmpty()) {
							Point value = q.poll();
							map[value.x][value.y] = '.';
						}
					}
				}
			}
			
			
			// 연쇄반응이 없으면 solve 함수 return
			if(isExplode) result++;
			else return;
			
			// 중력 작용
			set_gravity();
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<12;i++) {
			String s = br.readLine();
			for(int j=0;j<6;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		solve();
		System.out.println(result);
		

	}
	
	
	
	

}
