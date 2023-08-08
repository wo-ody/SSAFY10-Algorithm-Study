package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16401_과자_나눠주기 {
	// 조카에게 균등하게 최대한 많은 과자를 나눠주기

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long[] snacks = new long[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			snacks[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(snacks);
//		System.out.println(snacks[N-M]);

		long start = 1;
		long end = snacks[N - 1]; // 최대
		// upperbound를 구해야함

		long save = 0;
		while (start <= end) {
			int cnt = 0;
			long middle = (start + end) / 2;
			for (int i = 0; i < N; i++) {
				cnt += snacks[i] / middle;
			}

			if (cnt >= M) {
				save = middle;
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		System.out.println(save);

	}
}
