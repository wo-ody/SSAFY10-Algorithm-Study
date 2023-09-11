import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, white, blue;
	private static int[][] paper;

	private static void color(int row, int col, int len) {

		int count = 0;
		for (int i = row; i < row + len; i++) {
			for (int j = col; j < col + len; j++) {
				if (paper[row][col] == paper[i][j]) {
					count++;
				}
			}
		}

		if (count == len * len) {
			if (paper[row][col] == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}

		if (len > 1) {
			color(row, col, len / 2);
			color(row + len / 2, col, len / 2);
			color(row, col + len / 2, len / 2);
			color(row + len / 2, col + len / 2, len / 2);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		white = 0;
		blue = 0;

		color(0, 0, N);

		System.out.println(white);
		System.out.println(blue);

	}
}
