import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[301];
		int[] dp = new int[301];

		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = stair[1];
		dp[2] = Math.max(stair[2], dp[1] + stair[2]);
		dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
		}

		System.out.println(dp[N]);

	}
}
