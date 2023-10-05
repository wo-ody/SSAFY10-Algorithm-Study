import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int M, N, date;
	private static int[][] box;
	private static Queue<Point> tomato;
	private static boolean[][] isVisited;
	private static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

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

	private static void bfs() {

		while (!tomato.isEmpty()) {
			int size = tomato.size();
			for (int t = 0; t < size; t++) {
				Point p = tomato.poll();
				for (int i = 0; i < 4; i++) {
					int nx = p.x + delta[i][0];
					int ny = p.y + delta[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;
					if (isVisited[nx][ny])
						continue;
					if (box[nx][ny] == 1 || box[nx][ny] == -1)
						continue;

					isVisited[nx][ny] = true;
					tomato.add(new Point(nx, ny));
					box[nx][ny] = 1;
				}

			}
			date++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		isVisited = new boolean[N][M];
		box = new int[N][M];
		tomato = new LinkedList<>();
		date = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					tomato.add(new Point(i, j));
					isVisited[i][j] = true;
				}
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					date = -1;
					break;
				}
			}
		}

		if(date==-1) {
			System.out.println(date);
		} else {
		System.out.println(date - 1);
		}
	}
}
