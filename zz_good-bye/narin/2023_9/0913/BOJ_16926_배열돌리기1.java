import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, R;
	private static int[][] A;
	private static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 돌려야 하는 껍질(?)의 개수
		int num = Math.min(N, M) / 2;

		for (int r = 0; r < R; r++) {
			for (int n = 0; n < num; n++) {
				int x = n, y = n;
				int temp = A[x][y];

				for (int d = 0; d < 4; d++) {
					while (true) {
						int nx = x + delta[d][0];
						int ny = y + delta[d][1];

						if (nx >= n && nx < N - n && ny >= n && ny < M - n) {
							A[x][y] = A[nx][ny];
							x = nx;
							y = ny;
						} else {
							break;
						}
					}
				}

				A[n + 1][n] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
