import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int R, C, result;
	private static int ex, ey; // 도착지점
	private static Queue<Point> hedgehog, water;
	private static boolean[][] isVisited;
	private static char[][] map;
	private static int[][] delta = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	private static void move() {

		while (!hedgehog.isEmpty()) {

			int wsize = water.size();
			int hsize = hedgehog.size();

			result++;

			for (int i = 0; i < wsize; i++) {
				Point wNow = water.poll();

				for (int[] d : delta) {
					int nx = wNow.x + d[0];
					int ny = wNow.y + d[1];

					if (nx == ex && ny == ey)
						continue;
					if (nx < 0 || ny < 0 || nx >= R || ny >= C)
						continue;
					if (isVisited[nx][ny] || map[nx][ny] != '.')
						continue;

					isVisited[nx][ny] = true;
					water.add(new Point(nx, ny));
				}
			}

			for (int i = 0; i < hsize; i++) {
				Point hNow = hedgehog.poll();

				for (int[] d : delta) {
					int nx = hNow.x + d[0];
					int ny = hNow.y + d[1];

					if (nx == ex && ny == ey)
						return;
					if (nx < 0 || ny < 0 || nx >= R || ny >= C)
						continue;
					if (isVisited[nx][ny] || map[nx][ny] != '.')
						continue;

					isVisited[nx][ny] = true;
					hedgehog.add(new Point(nx, ny));
				}
			}

		}

		result = Integer.MAX_VALUE;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		result = 0;
		hedgehog = new ArrayDeque<>();
		water = new ArrayDeque<>();
		isVisited = new boolean[R][C];

		// 돌 X, 물 *, 비버 D, 고슴도치 S

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					hedgehog.add(new Point(i, j));
					isVisited[i][j] = true;
				} else if (map[i][j] == 'D') {
					ex = i;
					ey = j;
				} else if (map[i][j] == '*') {
					water.add(new Point(i, j));
					isVisited[i][j] = true;
				}
			}
		}

		move();

		if (result == Integer.MAX_VALUE)
			System.out.println("KAKTUS");
		else
			System.out.println(result);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}
}
