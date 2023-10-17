import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
	
public class BOJ_16234_인구이동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	
	
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static int bfs(Node start) {

		ArrayList<Node> result = new ArrayList<Node>();
		Deque<Node> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.y][start.x] = true;
		
		int population = map[start.y][start.x];
		int cnt = 1;
		result.add(start);
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(visited[ny][nx]) continue;
				
				int diff = Math.abs(map[cur.y][cur.x] - map[ny][nx]);
				
				if(diff < L || diff > R) continue;
				
				queue.add(new Node(nx, ny));
				result.add(new Node(nx, ny));
				population += map[ny][nx];
				cnt += 1;
				visited[ny][nx] = true;
			}
		}
		
		
		int val = population / cnt;
		
		for(Node node : result) {
			map[node.y][node.x] = val;
		}
		
		
		return cnt > 1 ? cnt : 0;
		
	}
	

	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int answer = 0;
		int cnt = 0;
		while(true) {
			visited = new boolean[N][N];
			cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j]) continue;
					cnt += bfs(new Node(j, i));
				}
			}
			
			
			if(cnt == 0) break;
			answer += 1;
			
		}
		
		System.out.println(answer);
		

	}

}
