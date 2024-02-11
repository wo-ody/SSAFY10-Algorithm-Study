import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int n, m;
	private static int[][] map;
	private static int sx, sy;
	private static boolean[][] isVisited;
	private static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void bfs(int x, int y) {
		// 갈 수 없는 땅 0
		// 갈 수 있는 땅 1
		// 앞 칸의 값 + 1

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));

		while (!q.isEmpty()) {

			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = p.x + delta[d][0];
				int ny = p.y + delta[d][1];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (isVisited[nx][ny] || map[nx][ny] == 0)
					continue;

				isVisited[nx][ny] = true;
				q.add(new Point(nx, ny));
				map[nx][ny] = map[p.x][p.y] + 1;

			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		isVisited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					// 출발 지점 2 -> 0으로 변경, 방문처리
					map[i][j] = 0;
					sx = i;
					sy = j;
				}
			}
		}

		bfs(sx, sy);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// isVisited = false -> -1 로 변경
				if (!isVisited[i][j] && map[i][j] != 0) {
					map[i][j] = -1;
				}
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
