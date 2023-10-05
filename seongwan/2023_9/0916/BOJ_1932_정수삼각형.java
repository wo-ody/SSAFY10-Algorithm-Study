import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, dp[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		dp = new int[n][n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			cnt++;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cnt; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 삼각형 입력
		dp();
		Arrays.sort(dp[n-1]);//최대값을 구하기 위해 정렬
		System.out.println(dp[n-1][n-1]);

	}

	static void dp() {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0)
					dp[i][j] += dp[i - 1][j];
				else 
					dp[i][j]=Math.max(dp[i][j]+dp[i-1][j-1],dp[i][j]+dp[i-1][j]);

			}
		}
	}
}
