package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기_설치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, C;
	static long[] houses;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		houses = new long[N];
		for (int i = 0; i < N; i++) {
			houses[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(houses);

		long start = 1;
		long end = houses[N - 1] - houses[0]; // 이게 최대

		long save = 0;

		while (start <= end) {

			long middle = (start + end) / 2;
			int cnt = 1;
			long done_area = houses[0];
			for (int i = 1; i < N; i++) {
				if (houses[i] - done_area >= middle) {
					done_area = houses[i];
					cnt++;
				}
			}
			if (cnt < C) { // 숫자가 적다면 길이를 더 짧게
				end = middle - 1;

			} else {
				start = middle + 1;
				save = middle;
			}
//			System.out.println(middle);
		}
		System.out.println(save);
	}
}
