package algorithm2023.sep.day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, arr[], x, ans;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		for (int i = 0;i< n; i++) {
			if(arr[i]>x/2)break;
			int tgt = x - arr[i];
			if (tgt > 0) {
				int lo = 0;
				int hi = n - 1;

				while (lo <= hi) {

					int mid = (lo + hi) / 2;
					if (arr[mid] == tgt) {
						if (mid != i) {
							ans++;
						}
						break;
					}
					if (tgt < arr[mid]) {
						hi = mid - 1;
					} else {
						lo = mid + 1;
					}

				}
			}
		}

		System.out.println(ans);

	}
}
