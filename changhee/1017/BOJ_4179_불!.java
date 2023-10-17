import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int n, m, ans;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static char[][] map;
	public static class Node {
		int x;
		int y;
		int time;
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	public static Queue<Node> jh, fire;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		jh = new LinkedList<>();
		fire = new LinkedList<>();
		
		
		map = new char[n][m];
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(map[i][j] == 'J') {
					jh.add(new Node(i, j, 0));
				}
				
				if(map[i][j] == 'F') {
					fire.add(new Node(i, j, 0));
				}
			}
		}
		
		ans = 0;
		
		if(bfs()) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}
	
		
		
		
	}
	
	public static boolean bfs() {
		// 불 먼저
		while(!jh.isEmpty()) {
			int f_size = fire.size();
			for(int i=0;i<f_size;i++) {
				Node node = fire.poll();
				
				for(int d=0;d<4;d++) {
					int nx = node.x + dx[d];
					int ny = node.y + dy[d];
					if(0 <= nx && nx < n && 0 <= ny && ny < m) {
						if(map[nx][ny] != '#' && map[nx][ny] !='F') {
							map[nx][ny] = 'F';
							fire.add(new Node(nx, ny, node.time+1));
						}
					} 
				}
				
			}
			
			int j_size = jh.size();
			
			for(int i=0;i<j_size;i++) {
				Node node = jh.poll();
				
				for(int d=0;d<4;d++) {
					int nx = node.x + dx[d];
					int ny = node.y + dy[d];
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
						ans = node.time+1;
						return false;
					}
					
					
					if(map[nx][ny] != '#' && map[nx][ny] !='F' && map[nx][ny] != 'J') {
							jh.add(new Node(nx, ny, node.time+1)); 
							map[nx][ny] = 'J';
					}
					
				}
				
			}
			
		}
		return true;

	}

}
