import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n + 1][n + 1];
		for(int i = 0; i <= n; i++)
			for(int j = 0; j <= i; j++)
				dp[i][j] = ((j == 0 || j == i) ? 1 : dp[i-1][j-1] + dp[i-1][j]) % 10007;
		// 그냥 이항계수 표 그려보면 됨
		
		System.out.println(dp[n][k]);
	}
}
