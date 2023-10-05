import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[][] map;
	static ArrayList<Pos> cam;
	//상하좌우
	static int dy[] = {0,0,-1,1};
	static int dx[] = {-1,1,0,0};
	
	public static int[][][] mode = {{{0}}, {{0}, {1}, {2}, {3}}, {{2, 3}, {0, 1}},
			{{0, 3}, {1, 3}, {1, 2}, {0, 2}},
			{{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
			{{0, 1, 2, 3}}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cam = new ArrayList<>();
		int zero_cnt = 0;
		
		//입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] >=1 && map[i][j] <= 5) {
					cam.add(new Pos(map[i][j], i, j));
				}
				else if(map[i][j] == 0) zero_cnt++;
			}
		}
		
		ans = zero_cnt;
		
		comb(0, cam.size(), map);
		
		System.out.println(ans);
	}
	
	public static void comb(int depth, int size, int[][] map) {
		//기저조건
		if(depth == size) {
			int cnt = check(map);
			ans = Math.min(ans, cnt);
			return;
		}
		
		int type = cam.get(depth).type;
		int x = cam.get(depth).x;
		int y = cam.get(depth).y;
		
		for(int i=0; i<mode[type].length; i++) {
			int[][] map_copy = new int[N][M];
			for(int k=0; k<N; k++) {
				map_copy[k] = map[k].clone();
			}
			
			for(int j=0; j<mode[type][i].length; j++) {
				int d = mode[type][i][j];
				
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				while(true) {
					if(nx<0 || nx>=N || ny<0 || ny>=M) break;
					
					if(map[nx][ny] == 6) break;
					
					map_copy[nx][ny] = -1;
					nx += dx[d];
					ny += dy[d];
				}
			}
			
			comb(depth+1, size, map_copy);
		}
	}
	
	public static int check(int[][] map) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static class Pos {
		int type;
		int x;
		int y;
		
		public Pos(int type, int x, int y){
			this.type = type;
			this.x = x;
			this.y = y;
		}
	}
}
