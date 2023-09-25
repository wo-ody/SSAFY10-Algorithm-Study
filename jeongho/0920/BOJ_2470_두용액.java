package algorithm2023.sep.day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, liquid[], start, end;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		liquid = new int[N];
		start = 0;
		end = N - 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(liquid);
		for (int i = 0; i < N; i++) {
			binarySearch(liquid[i]);
			if (min == 0)
				break;
		}

		System.out.println(start + " " + end);
	}

	static void binarySearch(int now) {
		int low = 0;
		int high = N - 1;
		int tgt = -now;
		int middle = -1;

		while (low < high) {
			middle = (low + high) / 2;
			if (liquid[middle]!=now&&Math.abs(now + liquid[middle]) < min) {
				min = Math.abs(now + liquid[middle]);
				if (now > liquid[middle]) {
					start = liquid[middle];
					end = now;
				} else {
					start = now;
					end = liquid[middle];
				}
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
