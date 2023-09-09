import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	private static int N, M;
	private static int targetX, targetY;
	private static boolean[][] isVisited;
	private static int[][] map, dist;
	private static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		isVisited = new boolean[N][M];

		q.add(new Point(x, y));
		isVisited[x][y] = true;

		while (!q.isEmpty()) {
			Point point = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + delta[i][0];
				int ny = point.y + delta[i][1];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == 1 && !isVisited[nx][ny]) {
						q.add(new Point(nx, ny));
						isVisited[nx][ny] = true;
						map[nx][ny] = map[point.x][point.y] + 1;
					}
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					map[i][j] = 0;
					targetX = i;
					targetY = j;
				}
			}
		}

		bfs(targetX, targetY);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!isVisited[i][j] && map[i][j] == 1) {
					sb.append(-1).append(" ");
				} else {
					sb.append(map[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
