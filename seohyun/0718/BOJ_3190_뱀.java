import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

class Point{
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class boj_3190_뱀 {
	
	static int N,K,L;
	static int[][] map;
	static HashMap<Integer,String> direction = new HashMap<>();
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			direction.put(sec, dir);
		}

		solve();
	}
	
	public static void solve() {
		int time = 0;
		int sdir = 1;
		Deque<Point> dq = new ArrayDeque();
		
		dq.addFirst(new Point(0,0));
		map[0][0] = 2; 
		
		while(true) {
			time++;
			
			int cx = dq.peek().x;
			int cy = dq.peek().y;
			
			int nx = cx + dx[sdir];
			int ny = cy + dy[sdir];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2)
				break;
			
			dq.addFirst(new Point(nx,ny));
			
			if(map[nx][ny] == 1) {
				map[nx][ny] = 2;
			}
			else {
				map[nx][ny] = 2;
				map[dq.peekLast().x][dq.peekLast().y] = 0;
				dq.removeLast();
			}
			
			// 위치 변환
			if(direction.containsKey(time)) {
				if(direction.get(time).equals("D")) {
					sdir = (sdir + 1) % 4;
				}
				else {
					sdir -= 1;
					if(sdir == -1) sdir = 3;
				}
			}
		}
		System.out.println(time);
	}
	
}
