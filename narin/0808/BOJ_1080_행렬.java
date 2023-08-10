package com.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1080_행렬 {

	private static int N, M;
	private static int[][] A;
	private static int[][] B;
	private static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		B = new int[N][M];

		for (int i = 0; i < N; i++) {
			String num = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = num.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			String num = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = num.charAt(j) - '0';
			}
		}

		count = 0;

		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] != B[i][j]) {
					for (int a = i; a < i + 3; a++) {
						for (int b = j; b < j + 3; b++) {
							A[a][b] = 1 - A[a][b];
						}
					}
					count++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(count);

	}
}
