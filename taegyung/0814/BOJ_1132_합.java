package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1132_합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] alpha_cnt = new long[10];
		for (int i = 0; i < 10; i++) {
			alpha_cnt[i] = 0;
		}
		boolean[] can_zero_arr = new boolean[10];
		for (int i = 0; i < 10; i++) {
			can_zero_arr[i] = true;
		}
		for (int i = 0; i < N; i++) {
			String alphaNum = br.readLine();
			for (int j = alphaNum.length() - 1; j >= 0; j--) {// 뒤에서부터 확인
				alpha_cnt[(int) alphaNum.charAt(j) - 65] += (long) Math.pow(10, (alphaNum.length() - 1) - j);
			}
			can_zero_arr[alphaNum.charAt(0) - 65] = false; // 얘는 처음은 안돼

		}
		int alphabet_cnt = 0;
		for (int i = 0; i < 10; i++) {
			if (alpha_cnt[i] > 0)
				alphabet_cnt++;
		}

		if (alphabet_cnt == 10) { // 0이 있어야해
			long min_val = Long.MAX_VALUE;
			int min_index = -1;
			for (int i = 0; i < 10; i++) {
				if (can_zero_arr[i] && min_val > alpha_cnt[i]) { // 0이 될 수 있음
					min_val = alpha_cnt[i];
					min_index = i;
				}
			}

			alpha_cnt[min_index] = 0; // 어차피 곱해봐야 0임

		}

		long sum = 0;
		Arrays.sort(alpha_cnt);
		for (int i = 9; i >= 0; i--) {
			sum += i * alpha_cnt[i];
		}
		System.out.println(sum);

	}
}
