import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		switch(n) {
		case 1:
			System.out.println(1);
			break;
		default:
			dp = new int[n + 1];
			dp[1] = 1;
			dp[2] = 3;
			for(int i = 3; i <= n; i++)
				dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;  // 2인 케이스가 결국 2개가 생겼으므로, 경우의 수 x 2
			System.out.println(dp[n]);
		}
	}
}