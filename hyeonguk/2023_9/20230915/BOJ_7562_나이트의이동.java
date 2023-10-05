import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 오른쪽, 아래, 왼쪽, 위 (반시계쪽 먼저)
	static int[] dy = {1, -1, 2, 2, 1, -1, -2, -2};
	static int[] dx = {2, 2, 1, -1, -2, -2, -1, 1};
	
	static int T, l, knightY, knightX, targetY, targetX;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<T; tc++) {
			l = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			knightY = Integer.parseInt(st.nextToken());
			knightX = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			targetY = Integer.parseInt(st.nextToken());
			targetX = Integer.parseInt(st.nextToken());
			
			map = new int[l][l];
			visited = new boolean[l][l];
			Queue<int[]> queue = new ArrayDeque<>();
			visited[knightY][knightX] = true;
			queue.offer(new int[] {knightY, knightX, 0});
			while(!queue.isEmpty()) {
				int[] item = queue.poll();
				
				int y = item[0];
				int x = item[1];
				int cnt = item[2];
				
				if(y==targetY && x==targetX) {
					sb.append(cnt).append("\n");
					break;
				}
				
				for(int d=0; d<8; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					
					if(ny < 0 || ny >= l || nx <0 || nx >=l) continue;
					
					if(!visited[ny][nx]) {
						visited[ny][nx] = true;
						queue.offer(new int[] {ny, nx, cnt+1});
					}
				}
			}
		}
		System.out.println(sb);
	}
}
