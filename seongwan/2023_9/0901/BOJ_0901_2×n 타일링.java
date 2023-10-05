import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, dp[];

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];// 0은 더미
		dp[1] = 1;
		if (N >= 2)
			dp[2] = 2;
		if (N >= 3)
			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
			}
		System.out.println(dp[N]);
	}

}
