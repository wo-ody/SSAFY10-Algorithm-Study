import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	private static int N, L, R, date;
	private static int[][] population;
	private static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static boolean[][] isVisited;
	private static List<Point> select;
	private static boolean moved; // 인구 이동의 유무

	private static void bfs(int x, int y) {
		select = new ArrayList<>();
		Queue<Point> q = new ArrayDeque<>();

		q.add(new Point(x, y));
		select.add(new Point(x, y));
		isVisited[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int[] d : delta) {
				int nx = p.x + d[0];
				int ny = p.y + d[1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				int n = Math.abs(population[p.x][p.y] - population[nx][ny]);

				if (!isVisited[nx][ny] && n >= L && n <= R) {
					isVisited[nx][ny] = true;
					q.add(new Point(nx, ny));
					select.add(new Point(nx, ny));
				}
			}

		}

		int sum = 0;
		for (Point s : select) {
			sum += population[s.x][s.y];
		}

		if (select.size() != 1) {

			int replace = sum / select.size();

			for (Point s : select) {
				population[s.x][s.y] = replace;
			}

			moved = true;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N*N 배열
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken()); // 인구수의 차이가 L 이상 R 이하

		population = new int[N][N];
		date = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 인구가 이동하는 경우는 인접한 국가의 인구수 차이가 L 이상 R 이하인 경우

		while (true) {

			isVisited = new boolean[N][N];
			moved = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!isVisited[i][j])
						bfs(i, j);
				}
			}

			if (!moved)
				break;

			date++;
		}

		System.out.println(date);

	}
}
