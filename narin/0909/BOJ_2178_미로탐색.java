import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int N, M;
	private static int[][] maze;
	private static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[N][M];

		isVisited[x][y] = true;
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + delta[i][0];
				int ny = p.y + delta[i][1];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (maze[nx][ny] == 1 && !isVisited[nx][ny]) {
						isVisited[nx][ny] = true;
						q.add(new Point(nx, ny));
						maze[nx][ny] = maze[p.x][p.y] + 1;
					}
				}

			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);

		System.out.println(maze[N - 1][M - 1]);
	}
}
