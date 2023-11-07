package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13913_숨바꼭질_4 {
	static int[][] dp;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 어디서 오는지 저장하면 되지 않을까

		dp = new int[150_000][2];

//		for (int i = N - 1; i >= 0; i--) {
//			dp[i][0] = dp[i + 1][0] + 1; // 한칸씩 내려가는거
//			dp[i][1] = i + 1; // 왔던 경로를 저장
//
//		}

		for (int i = 0; i < 150_000; i++) {
			dp[i][0] = Integer.MAX_VALUE / 2;
		}

		dp[N][0] = 0;
		dp[N][1] = -1; // 끝
		bfs();
//
//		for (int i = N + 1; i < 150_000; i++) {
//			dp[i][0] = dp[i - 1][0] + 1;
//			dp[i][1] = i - 1;
//
//			if (i % 2 == 0 && dp[i / 2][0] + 1 < dp[i][0]) {
//				dp[i][0] = dp[i / 2][0] + 1;
//				dp[i][1] = i / 2;
//			}
//		} // 입력 끝
//		for (int i = 0; i <= K; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}

		int next_index = dp[K][1];
		int now = K;
		StringBuilder sb = new StringBuilder();

		while (now != -1) {
			sb.append(reverse(Integer.toString(now)));
			now = next_index;
			if (now == -1)
				break;
			sb.append(" ");
			next_index = dp[next_index][1];
		}
		sb.append(reverse(dp[K][0] + "\n"));
		System.out.println(reverse(sb.toString()));
	}

	static int[] dx = { -1, 1 };

	static void bfs() {

		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] { N, 0 });
		// index, cnt

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			int x = tmp[0];
			int cnt = tmp[1];
			for (int i = 0; i < 3; i++) {
				int nx = -1;
				if (i == 2)
					nx = 2 * x;

				else
					nx = x + dx[i];

				if (nx > 130_000 || nx < 0)
					continue;

				if (dp[nx][0] > cnt + 1) {
					queue.offer(new int[] { nx, cnt + 1 });

					dp[nx][0] = cnt + 1;
					dp[nx][1] = x;
				}
			}
		}
	}

	static String reverse(String input) {
		StringBuilder sb = new StringBuilder();

		char[] tmp = input.toCharArray();

		for (int i = input.length() - 1; i >= 0; i--) {
			sb.append(tmp[i]);
		}
		return sb.toString();
	}
}
