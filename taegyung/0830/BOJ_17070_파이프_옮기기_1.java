package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프_옮기기_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[N + 1][N + 1][3];

		// 위에서 ,왼쪽 대각선, 왼쪽에서 온 것.

//		for(int i = 0 ; i < N; i ++)

//		dp[0][1][]
		dp[1][2][2] = 1;
		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= N; j++) {
//				if (map[i - 1][j - 1] == 1 || map[i - 1][j] == 1 || map[i][j - 1] == 1) {
//					dp[i][j][0] = 0;
//					dp[i][j][1] = 0;
//					dp[i][j][2] = 0;
//					continue;
//				}
				if (map[i - 1][j - 1] != 1) {
					if (i >= 2 && map[i - 2][j - 1] != 1)
						dp[i][j][0] += dp[i - 1][j][0] + dp[i - 1][j][1];
					if (i >= 2 && j >= 2 && map[i - 1][j - 1] != 1 && map[i - 2][j - 1] != 1 && map[i - 1][j - 2] != 1
							&& map[i - 2][j - 2] != 1)
						dp[i][j][1] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
					if (j >= 2 && map[i - 1][j - 2] != 1)
						dp[i][j][2] += dp[i][j - 1][1] + dp[i][j - 1][2];
				}
			}
		}
//		for (int i = 0; i < N + 1; i++) {
//			for (int j = 0; j < N + 1; j++) {
////				System.out.println(Arrays.toString(dp[N][N]));
//				
//			}
//		}
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);

	}
}
