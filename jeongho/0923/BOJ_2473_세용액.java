package algorithm2023.sep.day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2473_세용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, liquid[];
	static PriorityQueue<Integer> ans = new PriorityQueue<>();
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		liquid = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(liquid);
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				binarySearch(i, j);
				if (min == 0)
					break;
			}

		}
		while (!ans.isEmpty()) {
			System.out.print(ans.poll() + " ");
		}
	}

	static void binarySearch(int i, int j) {
		int low = 0;
		int high = N - 1;
		int a = liquid[i];
		int b = liquid[j];
		long now = a + b;
		int tgt = -(a + b);
		int middle = -1;

		while (low < high) {
			middle = (low + high) / 2;
			if (middle!=i&&middle!=j && Math.abs(now + liquid[middle]) < min) {
				min = Math.abs(now + liquid[middle]);
				ans = new PriorityQueue<>();
				ans.add(a);
				ans.add(b);
				ans.add(liquid[middle]);

			}
			if (liquid[middle] == tgt) {
				break;
			}
			if (liquid[middle] < tgt) {
				low = middle + 1;
			}
			if (liquid[middle] > tgt) {
				high = middle;
			}

		}

	}

}
