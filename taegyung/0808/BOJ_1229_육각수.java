package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1229_육각수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static final int MAX_N = 146858;
	static int[] six_angle = new int[MAX_N + 1];
	static int[] dp;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		process_six_angle();
//		for (int i = 0; i < 10; i++) {
//			System.out.println(six_angle[i]);
//		}

		dp = new int[N + 1];
		Arrays.fill(dp, MAX_N);
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (six_angle[j] > i) {
					break;
				}
				if (dp[i - six_angle[j]] + 1 < dp[i]) {
					dp[i] = dp[i - six_angle[j]] + 1;
				}
			}
		}
		System.out.println(dp[N]);

	}

	public static void process_six_angle() {
		six_angle[1] = 1;
		for (int i = 2; i <= MAX_N; i++) {
			six_angle[i] = (i - 1) * 6 + six_angle[i - 1] - (2 * (i - 1) - 1);
		}
	}
}
