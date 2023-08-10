package com.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	private static int N;
	private static int[] A;
	private static int[] operator;
	private static int min, max;

	private static void dfs(int num, int idx) {
		if (idx == A.length) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {

				operator[i]--;
				switch (i) {
				case 0:
					dfs(num + A[idx], idx + 1);
					break;
				case 1:
					dfs(num - A[idx], idx + 1);
					break;
				case 2:
					dfs(num * A[idx], idx + 1);
					break;
				case 3:
					dfs(num / A[idx], idx + 1);
					break;

				}
				operator[i]++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		operator = new int[4];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());

		dfs(A[0], 1);

		System.out.println(max);
		System.out.println(min);

	}
}
