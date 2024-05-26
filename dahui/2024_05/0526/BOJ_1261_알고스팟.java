import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static int N,M,ans;
	static int[][] maze;
	static boolean[][] visit;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}

		ans = simul(0,0);
		System.out.println(ans);
	}

	public static int simul(int startY, int startX) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
		pq.add(new Node(startY, startX, 0));
		visit[startY][startX] = true;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (node.y == N-1 && node.x == M-1) return node.cnt;

			for(int d=0; d<4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) continue;
				if (maze[ny][nx] == 1) {
					pq.add(new Node(ny, nx, node.cnt+1));
					visit[ny][nx] = true;
				}else {
					pq.add(new Node(ny, nx, node.cnt));
					visit[ny][nx] = true;
				}
			}
		}
		return 0;
	}

	public static class Node {
		int y,x,cnt;
		public Node (int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
