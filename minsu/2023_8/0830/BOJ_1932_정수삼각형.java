package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {
	static int n, max = Integer.MIN_VALUE;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// n이 1인 경우에는 아래의 경우는 패스하고 맨 위의 값이 답이기 때문에 출력하고 끝내기
		if (n == 1) {
			System.out.println(dp[0][0]);
			return;
		}

		dp[1][0] = dp[1][0] + dp[0][0];
		dp[1][1] = dp[1][1] + dp[0][0];

		for (int i = 2; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i][0];
			dp[i][i] = dp[i - 1][i - 1] + dp[i][i];
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1] + dp[i][j], dp[i - 1][j] + dp[i][j]);
			}
		}

		for (int arr : dp[n - 1]) {
			max = Math.max(max, arr);
		}

		System.out.println(max);
	}
}
