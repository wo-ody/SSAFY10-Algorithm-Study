import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 동, 남, 서, 북
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int N, answer;
	static boolean[][] rooms;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		rooms = new boolean[N][N];
		visited = new boolean[N][N][N*N+1];
		// 검은방이면 true(벽이 있어서 가지 못한다.)
		for(int i=0; i<N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				if(tmp[j] == '0') rooms[i][j] = true;
			}
		}
		
		answer = Integer.MAX_VALUE;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0, 0, 0}); // y좌표, x좌표, 검은 방-> 흰 방 바꾼 횟수
		visited[0][0][0] = true; // 시작점 방문 처리
		while(!queue.isEmpty()) {
			int[] item = queue.poll();
			int y = item[0];
			int x = item[1];
			int cnt = item[2];
			
			if(y==N-1 && x == N-1) {
				answer = Math.min(answer, cnt);
			}
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				
				if(!rooms[ny][nx] && !visited[ny][nx][cnt]) {
					visited[ny][nx][cnt] = true;
					queue.offer(new int[] {ny, nx, cnt});
				}
				
				if(rooms[ny][nx] && !visited[ny][nx][cnt+1] && cnt < N*N-1) {
					
					visited[ny][nx][cnt+1] = true;
					queue.offer(new int[] {ny, nx, cnt+1});
				}
			}
			
		}
		System.out.println(answer);
	}
}
