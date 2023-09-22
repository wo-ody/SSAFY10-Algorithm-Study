import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	// 동, 남, 서, 북
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{return o2-o1;});
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
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					bfs(i, j);
					cnt+=1;
				}
			}
		}
		
		
		System.out.println(cnt);
		if(pq.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(pq.poll());
		}
		
	}
	
	static void bfs(int i, int j) {
		map[i][j] = 0;
		int count = 1;
		Queue<int[] > queue = new ArrayDeque<>();
		queue.offer(new int[] {i, j});
		while(!queue.isEmpty()) {
			int[] items = queue.poll();
			int y = items[0];
			int x = items[1];
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny<0 || ny>=N || nx < 0 || nx >= M) continue;
				
				if(map[ny][nx]==1) {
					map[ny][nx] = 0;
					count++;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
		pq.offer(count);
	}
}
