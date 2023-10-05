package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12015_가장_긴_증가하는_부분_수열_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());

		int[] LIS = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		LIS[0] = A[0];
		int idx = 1;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (LIS[idx - 1] < A[i]) {
				LIS[idx++] = A[i];
				cnt++;
			}
			// 이분탐색으로 들어갈 곳을 찾자
			else {
				int start = 0;
				int end = idx - 1;
				int swapIdx = 0;

				while (start <= end) {
					int middle = (start + end) / 2;
					if (LIS[middle] >= A[i]) {
						swapIdx = middle;
						end = middle - 1;
					} else {
						start = middle + 1;
					}
				}
				LIS[swapIdx] = A[i];
//				System.out.println(Arrays.toString(LIS));
			}

		}
//		System.out.println(Arrays.toString(LIS));

//		System.out.println(LIS.length);
		System.out.println(cnt);

	}
}
