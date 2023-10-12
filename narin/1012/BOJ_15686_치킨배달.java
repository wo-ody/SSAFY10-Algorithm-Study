import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, result;
	private static List<Point> chicken, house;
	private static Point[] pick;

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

	private static void comb(int index, int count) {

		if (count == M) {
			int sum = 0;
			for (int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {

					int d = Math.abs(house.get(i).x - pick[j].x) + Math.abs(house.get(i).y - pick[j].y);

					min = Math.min(min, d);
				}

				sum += min;
			}

			result = Math.min(sum, result);

			return;
		}

		for (int i = index; i < chicken.size(); i++) {
			pick[count] = chicken.get(i);
			comb(i + 1, count + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chicken = new ArrayList<>();
		house = new ArrayList<>();
		pick = new Point[M];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());

				if (temp == 1) {
					house.add(new Point(i, j));
				} else if (temp == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}

		comb(0, 0);

		System.out.println(result);
	}
}
