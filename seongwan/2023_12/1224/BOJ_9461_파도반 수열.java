import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T, N;
	static StringBuilder sb = new StringBuilder();
	static long[] dp = new long[101];

	public static void main(String[] args) throws Exception {
		init();

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}
		System.out.println(sb);
	}

	static void init() {
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for (int i = 6; i <= 100; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
	}
}