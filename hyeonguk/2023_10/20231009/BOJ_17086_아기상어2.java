import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static int[][] map;
	// 동, 남, 서, 북, 오윈, 오아래, 왼아래, 왼위
	static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int tmp = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) continue;
				
				tmp = bfs(i, j);
				answer = Math.max(answer, tmp);
			}
		}
		
		System.out.println(answer);

	}
	
	static int bfs(int i, int j) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {i, j, 0});
		visited[i][j] = true;
		while(!queue.isEmpty()) {
			int[] items = queue.poll();
			int y = items[0];
			int x = items[1];
			int num = items[2];
			
			for(int d=0; d<8; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny<0 || ny >= N || nx < 0 || nx >= M) continue;
				
				if(map[ny][nx] == 1) return num+1;
				
				if(!visited[ny][nx] ) {
					visited[ny][nx] = true;
					queue.offer(new int[] {ny, nx, num+1});
				}
			}
		}
		return  0;
	}
}
