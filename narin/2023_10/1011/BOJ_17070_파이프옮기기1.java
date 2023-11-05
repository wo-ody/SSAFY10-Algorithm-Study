import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, count;
	private static int[][] house;
	private static int[][] delta = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

	private static void move(int r, int c, int d) {

		if (r == N - 1 && c == N - 1) {
			count++;
			return;
		}

		for (int i = 0; i < 3; i++) {

			if ((d == 0 && i == 1) || (d == 1 && i == 0))
				continue;

			int nr = r + delta[i][0];
			int nc = c + delta[i][1];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;

			if (i == 2 && (house[nr][nc - 1] == 1 || house[nr - 1][nc] == 1))
				continue;

			if (house[nr][nc] == 1)
				continue;

			move(nr, nc, i);

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		house = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move(0, 1, 0);

		System.out.println(count);
	}
}
