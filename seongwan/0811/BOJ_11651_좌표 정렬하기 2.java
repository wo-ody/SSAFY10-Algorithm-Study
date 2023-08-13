import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class point {
	int x;
	int y;

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static point[] points;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		points = new point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new point(x, y);
		}
		Arrays.sort(points, (n1, n2) -> n1.y == n2.y ? n1.x - n2.x : n1.y - n2.y);
		for (point p : points) {
			sb.append(p.x + " ").append(p.y).append("\n");

		}
		System.out.println(sb);
	}

}
