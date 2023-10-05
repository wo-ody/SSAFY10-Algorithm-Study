import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, K;
	private static int[] weight, value;
	private static int[][] bag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		weight = new int[N + 1];
		value = new int[N + 1];

		bag = new int[N + 1][K + 1];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			weight[n] = Integer.parseInt(st.nextToken());
			value[n] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j < weight[i]) {
					bag[i][j] = bag[i - 1][j];
				} else {
					bag[i][j] = Math.max(bag[i - 1][j], bag[i - 1][j - weight[i]] + value[i]);
				}
			}
		}

		System.out.println(bag[N][K]); // 마지막 칸 출력
	}
}
