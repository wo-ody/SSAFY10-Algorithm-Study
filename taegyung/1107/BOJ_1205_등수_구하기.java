package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1205_등수_구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] nums = new int[P];

		if (N != 0) {
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < P; i++) {
				nums[i] = -1;
				if (st.hasMoreTokens())
					nums[i] = Integer.parseInt(st.nextToken());

			}

			int start = 0;
			int end = P - 1;
			int position = P - 1;
//			System.out.println(nums[P - 1] + " " + newScore);
			if (nums[P - 1] >= newScore) {
				System.out.println(-1);
			} else {
				while (start <= end) {
					int middle = (start + end) / 2;

					if (nums[middle] <= newScore) {
						end = middle - 1;
						position = middle;
					} else {
						start = middle + 1;

					}
				}

				System.out.println(position + 1);

			}
		} else {
			System.out.println(1);
		}

	}
}
