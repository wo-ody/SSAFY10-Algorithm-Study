import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_7576_토마토 {
	static int M,N;
	static int[][] map;
	static int depth = -1;
	static Deque<Node> tomato = new ArrayDeque<>();
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) tomato.add(new Node(i,j));
			}
		}

		solve();
		
		
	}
	
	
	static void find_tomato() {
		
		while(!tomato.isEmpty()) {
			int size = tomato.size();
			depth++;
			for (int i = 0; i < size; i++) {
				Node cur = tomato.poll();
				for (int k = 0; k < 4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M ) continue;
					if(map[nx][ny] == 0) {
						map[nx][ny] = 1;
						tomato.add(new Node(nx,ny));
					}
				}
			}
		}
	}
	
	static boolean isRipen_Tomato() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	static void solve() {
		find_tomato();
		if(isRipen_Tomato()) System.out.println(depth);
		else System.out.println(-1);
	}
	
	
	static class Node{
		int x,y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
