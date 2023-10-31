package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2740_행렬_곱셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr1 = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr2 = new int[M][K];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] answer = new int[N][K];

		for (int i = 0; i < N; i++) {
			for (int k = 0; k < K; k++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += arr1[i][j] * arr2[j][k];
				}
				answer[i][k] = sum;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}

	}
}
