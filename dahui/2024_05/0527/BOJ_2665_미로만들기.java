import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2665_미로만들기 {
	static int N,ans;
	static int[][] rooms;
	static boolean[][] visit;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rooms = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				rooms[i][j] = str.charAt(j) - '0';
			}
		}

		ans = simul(0, 0);
		System.out.println(ans);
	}

	public static int simul(int startY, int startX) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
		pq.add(new Node(startY, startX, 0));
		visit[startY][startX] = true;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (node.y == N-1 && node.x == N-1) return node.cnt;

			for(int d=0; d<4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) continue;
				if (rooms[ny][nx] == 0) {
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

/**
 * 검은 방 : 벽
 * 되도록 적은 방을 바꾸고 시작방에서 끝방으로 가고 싶다.
 */
