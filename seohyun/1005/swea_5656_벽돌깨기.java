import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T,N,W,H;
	static int[][] map;
	
	static int result;
	static StringBuilder sb = new StringBuilder();
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//
			result = Integer.MAX_VALUE;
			dfs(0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}
	
	static void simulation(int x, int y) {
		// 구슬 깨수기
		bfs(x,y);
		
		// 중력 작용
		set_gravity();
	}
	
	static void set_gravity() {
		for (int j = 0; j < W; j++) {
			int px = H-1;
			for (int i = H-1; i >= 0; i--) {
				if(map[i][j] != 0) {
					if(px == i) px--;
					else {
						int tmp = map[i][j];
						map[i][j] = 0;
						map[px][j] = tmp;
						px--;
					}
				}
			}
		}
		
	}
	
	
	static void bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		//boolean[][] visited = new boolean[H][W];
		
		q.add(new Node(x,y));
		//visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int num = map[cur.x][cur.y];
			
			// 자기 자신 없애기
			map[cur.x][cur.y] = 0;
			
			for (int k = 0; k < 4; k++) {
				int cx = cur.x;
				int cy = cur.y;
				for (int cnt = 0; cnt < num - 1; cnt++) {
					cx += dx[k];
					cy += dy[k];
					if(isCango(cx, cy) == false) break;
					if(map[cx][cy] > 1) q.add(new Node(cx,cy));
					if(map[cx][cy] == 1) map[cx][cy] = 0;
					//visited[cx][cy] = true;
				}
			}
			
		}
	}
	
	static boolean move(int idx, int cnt) {
		boolean isCrash = false;
		
		int x = 0;
		int y = idx;
		
		while(true) {
			if(isCango(x, y) == false) break;
			if(map[x][y] != 0) {
				isCrash = true;
				// BFS 로 구슬 작용
				//System.out.println("cnt : " + cnt + " x , y " + x + " " + y);
				simulation(x,y);
				break;
			}
			x++;
		}
		
		return isCrash;
	}
	
	static int get_brick() {
		int sum = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] != 0) sum++;
			}
		}
		
		return sum;
	}
	
	static void dfs(int cnt) {
		//정답 갱신
		result = Math.min(result, get_brick());
		if(cnt == N) {
			return;
		}
		
		int[][] tmp = new int[H][W];
		for (int i = 0; i < H; i++) tmp[i] = map[i].clone();
		
		for (int i = 0; i < W; i++) {
			// 구슬 
			if(move(i,cnt)) {
				dfs(cnt + 1);
				for (int j = 0; j < H; j++) map[j] = tmp[j].clone();
			}
			
		}
	}
	
	static boolean isCango(int x, int y) {
		if(x < 0 || x >= H || y < 0 || y >= W) return false;
		return true;
	}
	
	static class Node{
		int x,y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
