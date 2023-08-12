import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] area = new int[100][100];
	private static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우하좌상

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = 100 - y - 10; i < 100 - y; i++) {
				for (int j = x; j < x + 10; j++) {
					area[i][j] = 1;
				}
			}

		}

		int count = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (area[i][j] == 1) {
					for (int[] d : delta) {
						int dx = i + d[0], dy = j + d[1];
						if (dx >= 0 && dx < 100 && dy >= 0 && dy < 100) {
							if (area[dx][dy] == 0)
								count++;
						} else {
							count++;
						}
					}
				}
			}
		}

		System.out.println(count);
	}
}
