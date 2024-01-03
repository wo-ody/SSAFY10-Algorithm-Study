package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18353_병사_배치하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] soldiers = new int[N];

		int idx = 0;
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		soldiers[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
//			if (i == 0)

			int tmp = Integer.parseInt(st.nextToken());
			if (tmp < soldiers[idx]) {
				soldiers[++idx] = tmp;
			} else {
				int start = 0;
				int end = idx;
				int swapIdx = 0;
				while (start <= end) {
					int middle = (start + end) / 2;

					if (tmp >= soldiers[middle]) {
						swapIdx = middle;
						end = middle - 1;
					} else {
						start = middle + 1;
					}
				}
				soldiers[swapIdx] = tmp;

				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
