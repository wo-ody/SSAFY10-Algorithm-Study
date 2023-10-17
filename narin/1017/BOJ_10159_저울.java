import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] num;

	private static int count(int n) {
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			if (num[n][i] == 0 && num[i][n] == 0)
				cnt++;
		}

		return cnt - 1; // 자기자신은 제외
	}

	private static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (num[i][k] != 0 && num[k][j] != 0) {
						num[i][j] = 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		num = new int[N + 1][N + 1];

		for (int m = 0; m < M; m++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			num[a][b] = 1;
		}

		floyd();

		for (int i = 1; i <= N; i++) {
			sb.append(count(i)).append("\n");
		}

		System.out.println(sb);
	}

}
