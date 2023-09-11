import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n+1][n+8>>1];
		if (k>n+2>>1) k = n-k;
		dp[1][0] = 1; dp[1][1] = 1;
		for (int i=2; i<=n; i++){
			for (int j=0; j<=k; j++){
				dp[i][j] = j==0? 1: dp[i-1][j] + dp[i-1][j-1];
				dp[i][j]%=10007;
			}
		}
		System.out.println(dp[n][k]);
	} // main
}
