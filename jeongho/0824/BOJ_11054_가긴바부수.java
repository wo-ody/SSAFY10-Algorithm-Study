package algorithm2023.aug.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11054_가긴바부수 {
	static int N, arr[], left[], right[], LIS[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		left = new int[N];
		right = new int[N];
		LIS = new int[N];
		Arrays.fill(LIS, 1001);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int last = 0;
		LIS[0] = arr[0];
		for (int i = 0; i < N; i++) {
			int idx = Arrays.binarySearch(LIS, arr[i]);
			if (arr[i] > LIS[last]) {
				LIS[++last] = arr[i];
				left[i] = last;
			} else {
				if (idx < 0) {
					idx = -idx - 1;
				}
				LIS[idx] = arr[i];
				left[i] = idx;
			}

		}
		
		Arrays.fill(LIS, 1001);
		LIS[N-1] = arr[N-1];
		last = 0;
		for (int i = N-1; i >=0; i--) {
			int idx = Arrays.binarySearch(LIS, arr[i]);
			if (arr[i] > LIS[last]) {
				LIS[++last] = arr[i];
				right[i] = last;
			} else {
				if (idx < 0) {
					idx = -idx-1;
				}
				
				LIS[idx] = arr[i];
				right[i] = idx;
			}

		}
		int max = 0;
		for(int i= 0;i<N;i++) {
			max = Math.max(max, left[i]+right[i]+1);
		}
		System.out.println(max);

	}
}
