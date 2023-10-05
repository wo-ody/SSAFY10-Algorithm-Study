import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
        dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[5] = 1;
        dp[7] = 1;
		
		for (int i = 1; i <= N; i++) {
			dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            dp[i + 2] = Math.min(dp[i + 2], dp[i] + 1);
            dp[i + 5] = Math.min(dp[i + 5], dp[i] + 1);
            dp[i + 7] = Math.min(dp[i + 7], dp[i] + 1);
		}
		
		System.out.println(dp[N]);
	}
}
