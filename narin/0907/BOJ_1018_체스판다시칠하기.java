import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static Character[][] chess;

	private static int color(int x, int y) {
		int count = 0;

		Character first = 'W';

		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {

				if (!chess[i][j].equals(first))
					count++;

				if (first.equals('W'))
					first = 'B';
				else
					first = 'W';
			}

			if (first.equals('W'))
				first = 'B';
			else
				first = 'W';
		}

		count = Math.min(count, 64 - count);
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chess = new Character[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				chess[i][j] = str.charAt(j);
			}
		}

		int min = 64; // 전체 칸의 넓이

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				min = Math.min(min, color(i, j));
			}
		}

		System.out.println(min);
	}
}
