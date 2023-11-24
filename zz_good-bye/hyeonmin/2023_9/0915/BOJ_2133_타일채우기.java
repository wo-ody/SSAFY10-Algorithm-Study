import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2133_타일채우기 {

	static int N;
	static int dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		if(N>1) {
			dp[2] = 3;
			for (int i = 4; i < N+1; i++) {
				if(i%2 != 0) continue;
				dp[i] = dp[i-2] * dp[2]+2;
				
				for (int j = i-4; j >= 2; j--) {
					dp[i] += dp[j]*2;
				}
			}
		}
		System.out.println(dp[N]);
	}
}
