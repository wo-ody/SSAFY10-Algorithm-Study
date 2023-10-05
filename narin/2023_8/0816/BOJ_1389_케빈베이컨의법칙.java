import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] relation;
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		relation = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				relation[i][j] = 54645741;

				if (i == j) {
					relation[i][j] = 0;
				}
			}
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			relation[A][B] = 1;
			relation[B][A] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (relation[i][j] > relation[i][k] + relation[k][j]) {
						relation[i][j] = relation[i][k] + relation[k][j];
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int result = 0;

		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += relation[i][j];
			}
			if (sum < min) {
				min = sum;
				result = i;
			}
		}

		System.out.println(result);

	}
}
