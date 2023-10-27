import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BOJ_14503_로봇청소기 {
	
	static int y,x,count;
	static int map[][];
	static int dy[] = {-1,0,1,0};  // 북동남서
	static int dx[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken()); 
		x = Integer.parseInt(stk.nextToken());
		map = new int[y][x];
		
		stk = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		d = Integer.parseInt(stk.nextToken()); // 방향 0북 , 1동, 2남, 3서
		count = 1;
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
 
		dfs(r,c,d);
		System.out.println(count);
	}
	
	public static void dfs(int r, int c, int direction) {
		
		//현재 위치를 청소한다.
		map[r][c] = -1;
		
		//현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
		for(int i=0; i<4; i++) {
			direction = (direction + 3) % 4; // 왼쪽 방향으로 변환 (북 -> 서 -> 남 -> 동)
			int ny = r + dy[direction];
			int nx = c + dx[direction];
			
			// 청소가 안된 곳이 있으면 count++,  dfs
			if(ny >=0 && ny < y && nx >= 0 && nx < x && map[ny][nx] == 0) {
				count++;
				dfs(ny,nx, direction);
				
				//여기서 return을 안하면 복귀하는 도중 뒤로가서 다른 곳을 청소할수가 있음.
				return;
			}
		}
		
		//네 방향 모두 청소가 이미 되어있거나 벽인 경우에는
		//뒤쪽 칸이 벽이 아니라는 전제 하에, 바라보는 방향을 유지한 채로 한 칸 후진.
		int back = (direction + 2) % 4;
		int by = r + dy[back];
		int bx = c + dx[back];
        
		if(by>=0 && by<y && bx>=0 && bx<x && map[by][bx] != 1) {
			dfs(by,bx,direction);
		}
	}
}
