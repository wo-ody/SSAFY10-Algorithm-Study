import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	
	static int minL, maxL;
	
	static int result;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		minL = Integer.MAX_VALUE;
		maxL = Integer.MIN_VALUE;
		result = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minL = Math.min(minL, map[i][j]);
				maxL = Math.max(maxL, map[i][j]);
			}
		}
		
		for (int i = minL - 1; i <= maxL; i++) {
			result = Math.max(result, simulation(i));
		}
		
		System.out.println(result);
	}
	
	static void bfs(int depth, int x, int y, boolean[][] visited) {
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(new Node(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				if(!isCango(nx,ny) || visited[nx][ny] || map[nx][ny] <= depth) continue;
				q.add(new Node(nx,ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	static int simulation(int depth) {
		boolean[][] visited = new boolean[N][N];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j] || map[i][j] <= depth) continue;
				bfs(depth,i,j,visited);
				cnt++;
			}
		}
		
		return cnt;
	}
	
	static boolean isCango(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
