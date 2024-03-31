import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long[][] dp;
	static long mod = 1000000000;
	static long answer = 0;
    
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		dp = new long[n + 1][10];
		
		for(int i = 1; i < 10; i++)
			dp[1][i] = 1; 
		
		for(int i = 2; i <= n; i++)
			for(int j = 0; j < 10; j++) {
				if(j == 0)
					dp[i][0] = dp[i - 1][1] % mod;
				else if (j == 9)
					dp[i][9] = dp[i - 1][8] % mod;
				else
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		
		for(int i = 0; i < 10; i++)
			answer += dp[n][i];

		System.out.println(answer % mod);
	}
}
