package net.acmicpc;

import java.util.Scanner;

public class BOJ_1309_동물원 {
	/*
	 * 사자가 가로, 세로로 붙어있지 않도록 배치하는 것. dp로 해결할 수 있을 것 같다. 윗줄에 사자가 없다 -> 둘 다 놓을 수 있다.
	 * 윗줄에 사자가 있다 -> 하나 (윗줄에 놓이지 않은 열에)놓을 수 있다.
	 * 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] dp = new int[N][3];

		// 0 -> 없, 1-> 왼, 2-> 오른
		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[0][2] = 1;
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
			dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
			dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][0] %= 9901;
			dp[i][1] %= 9901;
			dp[i][2] %= 9901;
		}
		int sum = 0;
		sum += dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2];
		System.out.println(sum %= 9901);
	}
}
