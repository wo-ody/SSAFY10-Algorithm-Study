package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질_2 {
	static int[] dx = { -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[150_000][2];

		for (int i = 0; i < 150_000; i++) {
			dp[i][0] = Integer.MAX_VALUE / 2;
			dp[i][1] = 0;
		}

		dp[N][0] = 0;
		dp[N][1] = 1;

		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] { N, 0, 1 });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll(); // position, time, cnt

			int position = tmp[0];
			int time = tmp[1];
			int cnt = dp[position][1];

			for (int i = 0; i < 3; i++) {
				int nx = -1;
				if (i == 2) {
					nx = position * 2;
				} else {
					nx = position + dx[i];
				}
				if (nx >= 150_000 || nx < 0)
					continue;

				if (dp[nx][0] > time + 1) {
					dp[nx][0] = time + 1;
					dp[nx][1] = cnt;

					queue.offer(new int[] { nx, time + 1, cnt });
				} else if (dp[nx][0] == time + 1) {
					dp[nx][1] += cnt;
				}

			}
		}
//		System.out.println(Arrays.toString(dp[K]));
		System.out.println(dp[K][0]);
		System.out.println(dp[K][1]);

	}
}
