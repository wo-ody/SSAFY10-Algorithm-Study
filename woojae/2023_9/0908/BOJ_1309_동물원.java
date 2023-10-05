import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		dp = new int[100001];
		dp[0] = 1;
		dp[1] = 3;
		for(int i = 2; i <= n; i++)
			dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
		System.out.println(dp[n]);
	}
}
