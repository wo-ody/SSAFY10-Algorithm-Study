package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	static int N,M,ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		ans = bfs(new Node(0,0,0));
		System.out.println(ans);
	}
	
	static int bfs(Node start) {
		Deque<Node> q = new ArrayDeque<>();
		q.add(start);
		visit[start.y][start.x] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int y = node.y;
			int x = node.x;
			int cnt = node.cnt;
			
			if(y==N-1 && x==M-1) return cnt+1;
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny>=0 && nx>=0 && ny<N && nx<M && !visit[ny][nx] && map[ny][nx]==1) {
					q.add(new Node(ny,nx,cnt+1));
					visit[ny][nx] = true;
				}
			}
		}
		
		return 0; //도착못하는 경우는 없지만 만들어 놓음
		
	}

	static class Node{
		int y,x,cnt;
		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
