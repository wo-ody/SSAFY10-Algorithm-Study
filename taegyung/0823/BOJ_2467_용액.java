package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Long[] liquid = new Long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(liquid);
		Long n1 = (long) -1;
		Long n2 = (long) -1;

		Long min = Long.MAX_VALUE;

		int start = 0;
		int end = N - 1;

		while (start < end) {
			if (min > Math.abs(liquid[start] + liquid[end])) {
				min = Math.abs(liquid[start] + liquid[end]);
				// 더 작은걸 저장하고 해당 값이 음수면 start를 늘리고
				// 양수면 end를 줄이는 방식으로 하자
				n1 = liquid[start];
				n2 = liquid[end];
			}
			if (liquid[start] + liquid[end] < 0) {
				start += 1;
			} else {
				end -= 1;
			}
		}

		System.out.println(n1 + " " + n2);
	}
}
