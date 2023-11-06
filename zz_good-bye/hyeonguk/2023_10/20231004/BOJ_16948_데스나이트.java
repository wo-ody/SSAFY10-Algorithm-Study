import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1, 1, -2, 2, -1, 1};
	static int[] dx = {-2, -2, 0, 0, 2, 2};
	static int[][] map;
	static boolean[][] visited;
	static int N, r1, c1, r2, c2, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		answer = -1;
		bfs(c1, r1);
		
		System.out.println(answer);
		
	}
	
	static void bfs(int i, int j) {
		
		visited[i][j] = true;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {i, j});
		while(!queue.isEmpty()) {
			int[] item = queue.poll();
			
			int y = item[0];
			int x = item[1];
			
			if(y==c2 && x == r2) {
				answer = map[c2][r2];
				return;
			}
			
			for(int d=0; d<6; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				
				if(!visited[ny][nx]) {
					map[ny][nx] = map[y][x] + 1;
					visited[ny][nx] = true;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
	}
}
