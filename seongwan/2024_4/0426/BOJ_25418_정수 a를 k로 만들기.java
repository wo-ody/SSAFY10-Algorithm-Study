import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int A, K;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[K + 1];

		for (int i = A; i <= K - 1; i++) {
			int a = i + 1;
			int b = i * 2;

			if (dp[a] == 0)
				dp[a] = dp[i] + 1;
			else
				dp[a] = Math.min(dp[a], dp[i] + 1);

			if (b > K)
				continue;

			if (dp[b] == 0)
				dp[b] = dp[i] + 1;
			else
				dp[b] = Math.min(dp[b], dp[i] + 1);
		}

		System.out.println(dp[K]);
	}
}