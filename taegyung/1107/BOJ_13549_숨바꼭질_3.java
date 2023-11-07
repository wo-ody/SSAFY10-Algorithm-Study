package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질_3 {

	static int[] dx = { -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dp = new int[150_000];

		for (int i = 0; i < 150_000; i++) {
			dp[i] = Integer.MAX_VALUE / 2;
		}

		dp[N] = 0;

		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] { N, 0 });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll(); // position, time, cnt

			int position = tmp[0];
			int time = tmp[1];

			for (int i = 0; i < 3; i++) {
				int nx = -1;
				if (i == 2) {
					nx = position * 2;
				} else {
					nx = position + dx[i];
				}
				if (nx >= 150_000 || nx < 0)
					continue;

				if (i == 2) {
					if (dp[nx] > time) {
						dp[nx] = time;

						queue.offer(new int[] { nx, time });
					}

				} else {
					if (dp[nx] > time + 1) {
						dp[nx] = time + 1;

						queue.offer(new int[] { nx, time + 1 });
					}

				}

			}
		}
//			System.out.println(Arrays.toString(dp[K]));
		System.out.println(dp[K]);

	}

}
