package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		long[] numArr = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken()) + numArr[i - 1];
		}

		// 누적합 저장

		// TODO 투포인터로 탐색하면서 차가 S 이상이 될 때의 길이 중 최소값을 저장한다.

		int min_diffs = Integer.MAX_VALUE;

		int start = 0;

		int end = 1;

		while (start < end && end <= N) {
			if (numArr[end] - numArr[start] >= S) {
				min_diffs = Math.min(min_diffs, end - start);
				start += 1;
			} else {
				end += 1;
			}
		}
//		System.out.println(Arrays.toString(numArr));
		System.out.println(min_diffs == Integer.MAX_VALUE ? 0 : min_diffs);
	}
}
