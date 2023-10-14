import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int[][] mat;
	static int INF = 1000000;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		mat = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(mat[i], INF);
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			mat[from][to] = 1;
			mat[to][from] = 1;
		} // 인접 행렬 입력

		floyd();
		find();

	}

	static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}
	}

	static void find() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (mat[i][j] > 6) {
					System.out.println("Big World!");
					return;
				}
			}
		}
		System.out.println("Small World!");
	}

}