import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N;

	private static List<Point> store;
	private static Point start, end;

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

	private static boolean bfs(Point start) {

		Queue<Point> q = new ArrayDeque<>();
		boolean[] isVisited = new boolean[N];

		q.add(start);

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (Math.abs(p.x - end.x) + Math.abs(p.y - end.y) <= 1000) {
				return true;
			}

			for (int i = 0; i < N; i++) {
				if (!isVisited[i]) {
					int nx = store.get(i).x;
					int ny = store.get(i).y;

					if (Math.abs(p.x - nx) + Math.abs(p.y - ny) <= 1000) {
						isVisited[i] = true;
						q.add(new Point(nx, ny));
					}
				}
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			store = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				store.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			st = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			if (bfs(start)) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
		}

		System.out.println(sb);
	}
}
