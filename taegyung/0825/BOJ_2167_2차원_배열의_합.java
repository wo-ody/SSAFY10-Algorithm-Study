package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2167_2차원_배열의_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] numArr = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				numArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
//				if (i == 0 || j == 0)
//					numArr[i][j] = 0;
//				else {
				numArr[i][j] += numArr[i - 1][j] + numArr[i][j - 1] - numArr[i - 1][j - 1];
//			}
			}

		}
		// 누적합들을 저장

		int K = Integer.parseInt(br.readLine());
//		int [][] dots = new int [K][4];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int sum = numArr[x2][y2];
			sum -= numArr[x1 - 1][y2];
			sum -= numArr[x2][y1 - 1];
			sum += numArr[x1 - 1][y1 - 1];
			System.out.println(sum);
		}
	}
}
