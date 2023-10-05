package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2352_반도체_설계 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int[] port = new int[n];
		int idx = 0;

		for (int i = 0; i < n; i++) {
			if (i == 0)
				port[i] = Integer.parseInt(st.nextToken());
			else {
				int tmp = Integer.parseInt(st.nextToken());
				if (port[idx] <= tmp) {
					port[++idx] = tmp;
				} else {
					int start = 0;
					int end = idx;

					int swapIdx = 0;
					while (start <= end) {
						int middle = (start + end) / 2;

						if (port[middle] >= tmp) {
							swapIdx = middle;
							end = middle - 1;

						} else {
							start = middle + 1;
						}

					}
					port[swapIdx] = tmp;
				}
			}

		}
//		System.out.println(Arrays.toString(port));
		System.out.println(idx + 1);

	}
}
