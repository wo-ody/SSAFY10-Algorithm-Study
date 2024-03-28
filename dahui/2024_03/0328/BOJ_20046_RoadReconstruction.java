import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20046_RoadReconstruction {
	static int m,n,ans;
	static int[][] load;
	static boolean[][] visit;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		load = new int[m][n];
		visit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				load[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation();
		System.out.println(ans);
	}
	//0 존재, 1 필요, 2 필요, -1 안돼
	public static void simulation() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.v - o2.v);
		if (load[0][0] == -1) {
			ans = -1;
			return;
		}
		pq.add(new Node(0,0,load[0][0]));

		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int y = node.y;
			int x = node.x;
			int v = node.v;
			visit[y][x] = true;
			if(y == m-1 && x == n-1) {
				ans = v;
				return;
			}

			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if(ny < 0 || ny >= m || nx < 0 || nx >= n || visit[ny][nx] || load[ny][nx] == -1) {
					continue;
				}
				pq.add(new Node(ny, nx, v + load[ny][nx]));
			}
		}
		ans = -1;
	}

	public static class Node{
		int y;
		int x;
		int v;
		public Node(int y, int x, int v) {
			this.y = y;
			this.x = x;
			this.v = v;
		}
	}
}
