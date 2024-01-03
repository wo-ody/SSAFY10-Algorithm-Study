package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간_합_구하기_4 {
	// 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램
	// 수의 개수 N와 합을 구해야하는 횟수 M.
	// N개의 수
	// 합을 구해야하는 구간 i, j

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;

	static int[] numArray;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numArray = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}

//		int sumFromStart = 0;
		int[] sumFromStart = numArray.clone();
//		sumFromStart = numArray.clone();
//		int sumFromLast = 0;
		int[] sumFromLast = numArray.clone();
//		sumFromLast[N-1] = numArray.clone();
		for (int i = 1; i < N; i++) {
			sumFromStart[i] += sumFromStart[i - 1];
			sumFromLast[N - i - 1] += sumFromLast[N - i];
		}

//		System.out.println(Arrays.toString(sumFromStart));
//		System.out.println(Arrays.toString(sumFromLast));
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;

			System.out.println(sumFromStart[end] + sumFromLast[start] - sumFromLast[0]);
		}
	}
}
