package algorithm2023.nov.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24337_가희와탑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, a, b;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		boolean flag = true;
		int[] arr = new int[N + 1];
		if (a + b <= N + 1) {
			flag = false;
			int max = Math.max(a, b);

			if (a == 1) {
				arr[0] = max;
				int h = 1;
				for (int i = 1; i < N; i++) {
					if (i <= N - b) {
						arr[i] = 1;
					} else {
						arr[i] = --max;
					}
				}
			} else {
				int idx = N - b;
				int h = 1;
				for(int i =0;i<N;i++) {
					if(i<=idx-a+1) {
						arr[i] = 1;
					}else if(i<N-b) {
						arr[i] = ++h;
					}else if(i==idx) {
						arr[i] = max;
					}
					else {
						arr[i] = --b;
					}
				}
			}
		}

		if (flag) {
			sb.append(-1);
		} else {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i] + " ");
			}
		}
		System.out.println(sb);
	}

}