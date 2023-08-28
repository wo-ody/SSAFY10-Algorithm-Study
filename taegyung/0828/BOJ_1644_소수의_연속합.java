package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1644_소수의_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] prime_nums = new boolean[N + 1];

//		for(int i = )
		for (int i = 0; i <= N; i++)
			prime_nums[i] = true;
		prime_nums[0] = false;
		prime_nums[1] = false;

		int[] only_primes = new int[N + 1];
		int idx = 0;
		for (int i = 2; i <= N; i++) {
			if (prime_nums[i]) {
				only_primes[idx++] = i;
				for (int j = i * 2; j <= N; j += i) {
					prime_nums[j] = false;
				}
			}
		}
		// 한번 모아두자

		int start = 0;
		int end = 0;
		int sum = only_primes[0];

		int cnt = 0;

		while (start <= end) {
			if (sum == N) {
				cnt++;
			}
			if (sum > N) {
//				start  ++;
				sum -= only_primes[start++];

			} else {
				sum += only_primes[++end];

			}

			if (end >= idx) { // 더 이상 진행 x
				break;
			}

//			int middle = (start + end) /2;

		}
		System.out.println(cnt);
	}
}
