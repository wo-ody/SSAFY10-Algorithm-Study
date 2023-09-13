import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, count;
	private static int[][] area;
	private static boolean[][] isVisited;
	private static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void bfs(int x, int y, int height) {

		Queue<Point> q = new LinkedList<>();
		isVisited[x][y] = true;
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + delta[d][0];
				int ny = p.y + delta[d][1];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (!isVisited[nx][ny] && area[nx][ny] > height) {
						isVisited[nx][ny] = true;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		HashSet<Integer> height = new HashSet<>();
		int max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				height.add(area[i][j]);
			}
		}

		for (int num : height) {
			isVisited = new boolean[N][N];
			count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (area[i][j] > num && !isVisited[i][j]) {
						bfs(i, j, num);
						count++;
					}
				}
			}

			max = Math.max(max, count);
		}

		if (height.size() == 1) {
			max = 1;
		}

		System.out.println(max);

	}
}
