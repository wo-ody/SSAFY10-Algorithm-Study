import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502_연구소 {
	static int N,M;
	static int map[][];
	
	static ArrayList<Node> virus = new ArrayList<>();
	static int result = -1;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) virus.add(new Node(i,j));
			}
		}
		
		DFS(0);
		System.out.println(result);

	}
	
	static public void get_safe_zone() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < map.length; i++) tmp[i] = map[i].clone();
		
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for (int i = 0; i < virus.size(); i++) {
			Queue<Node> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			
			int cx = virus.get(i).x;
			int cy = virus.get(i).y;
			q.add(new Node(cx,cy));
			visited[cx][cy] = true;
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				
				for(int k=0;k<4;k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
					if(tmp[nx][ny] == 0) {
						q.add(new Node(nx,ny));
						visited[nx][ny] = true;
						tmp[nx][ny] = 2;
					}
				}
			}
		}
		
		int safe_zone = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tmp[i][j] == 0) safe_zone++;
			}
		}
		
		result = Math.max(result, safe_zone);
		
		
	}
	
	static public void DFS(int cnt) {
		if(cnt == 3) {
			// 바이러스 전파 후 안전영역 구하기
			get_safe_zone();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					DFS(cnt + 1);
					map[i][j] = 0;
				}
				
			}
			
		}
	}
	
	static class Node{
		int x,y;
		Node(int x,int y){
			this.x = x;
			this.y = y;
		}
	}

}
