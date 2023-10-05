package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] stickers = new int[N][2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				stickers[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				stickers[i][1] = Integer.parseInt(st.nextToken());
			}
			// 입력 완료

			int[][] dp = new int[N][2];

			dp[0] = stickers[0];

			for (int i = 1; i < N; i++) {
				dp[i][0] = Math.max(dp[i - 1][1] + stickers[i][0], dp[i - 1][0]);
				dp[i][1] = Math.max(dp[i - 1][0] + stickers[i][1], dp[i - 1][1]);
			}

			System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));

		}

	}
}
