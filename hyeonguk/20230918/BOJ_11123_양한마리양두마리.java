import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	// 동, 남, 서, 북
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	static int T, H, W;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			visited = new boolean[H][W];
			
			for(int i=0; i<H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int cnt = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(!visited[i][j] && dfs(i,j)) {
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
			
		}
		
		System.out.println(sb);

	}
	
	static boolean dfs(int y, int x) {
		if(map[y][x] == '.') return false;
		
		visited[y][x] = true;
		
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || ny >= H || nx < 0 || nx >=W) continue;
			
			if(!visited[ny][nx] && map[ny][nx] == '#') {
				dfs(ny, nx);
			}
		}
		
		return true;
	}
}
