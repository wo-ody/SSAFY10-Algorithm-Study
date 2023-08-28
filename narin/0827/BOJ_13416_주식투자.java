import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int T, N, sum;
	private static int[][] profit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			profit = new int[N][3];
			sum = 0;

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				profit[n][0] = Integer.parseInt(st.nextToken());
				profit[n][1] = Integer.parseInt(st.nextToken());
				profit[n][2] = Integer.parseInt(st.nextToken());

				int max = 0;

				for (int i = 0; i < 3; i++) {
					if (max < profit[n][i])
						max = profit[n][i];
				}

				if (max < 0)
					max = 0;
				sum += max;
			}

			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
}
