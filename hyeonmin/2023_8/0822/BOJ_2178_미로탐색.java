import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {

	static int N, M;
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		isVisited = new boolean[N][M];
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
	}

	static void bfs(int y, int x) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {y,x});
		isVisited[y][x] = true;
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int cy = cur[0];
			int cx = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				
				if(ny < 0 || ny >= N || nx <0 || nx >= M) continue;
				if(isVisited[ny][nx] || map[ny][nx] == 0) continue;
				
				queue.add(new int[] {ny, nx});
				map[ny][nx] = map[cy][cx] + 1;
				isVisited[ny][nx] = true;
			}
			
		}
			
		
	}
}
