import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int dp[];

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
		}
		System.out.println(dp[N]);
	}
}