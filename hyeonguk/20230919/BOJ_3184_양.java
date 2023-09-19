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
	static int R, C, cntSheep, cntWolf, resSheep, resWolf;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		resSheep = 0;
		resWolf = 0;
		
		for(int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if(map[i][j] == '#') continue;
				
				if(!visited[i][j]) {
					cntSheep = 0;
					cntWolf = 0;
					bfs(i, j);
					if(cntWolf >= cntSheep) {
						cntSheep = 0;
					}else {
						cntWolf = 0;
					}
					resWolf += cntWolf;
					resSheep += cntSheep;
				}
			}
		}
		
		System.out.println(resSheep+" "+resWolf);

	}
	
	static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		
		if(map[i][j] == 'v') cntWolf += 1;
		
		else if(map[i][j] == 'o') cntSheep += 1;
		
		visited[i][j] = true;
		
		queue.offer(new int[] {i, j});
		while(!queue.isEmpty()) {
			int[] items = queue.poll();
			
			int y = items[0];
			int x = items[1];
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				
				if(!visited[ny][nx] && map[ny][nx] != '#') {
					visited[ny][nx] = true;
					if(map[ny][nx]=='v') cntWolf += 1;
					else if(map[ny][nx]== 'o') cntSheep += 1;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
		
	}

}
