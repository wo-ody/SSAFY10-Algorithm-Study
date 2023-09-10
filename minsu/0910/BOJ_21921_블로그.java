package bj.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921_블로그 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int max = 0;
		int count = 1;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (i == x - 1)
				max = sum;
			if (i > x - 1) {
				sum -= arr[i - x];
				if (max < sum) {
					max = sum;
					count = 1;
				} else if (max == sum) {
					count++;
				}
			}
		}

		if (max == 0)
			System.out.println("SAD");
		else {
			System.out.println(max + "\n" + count);
		}
	}
}
