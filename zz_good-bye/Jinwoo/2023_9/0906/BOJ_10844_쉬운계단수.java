import java.io.*;
import java.util.*;
public class BOJ_10844_쉬운계단수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int b = 1_000_000_000;
		
		int[][] dp = new int[n+1][10];
		for (int k=0; k<=9; k++) dp[1][k] = 1;
		for (int i=2;i<=n;i++){
			for (int k=0; k<=9; k++){
				if (k==0) dp[i][k] = dp[i-1][k+1];
				else if (k==9) dp[i][k] = dp[i-1][k-1];
				else dp[i][k] = dp[i-1][k-1] + dp[i-1][k+1];
				dp[i][k] %= b;
			}
		}
		int ans=0;
		
		for (int i=1; i<=9; i++) {ans+= dp[n][i]; ans%=b;}
		System.out.println(ans);
	} // main
}
