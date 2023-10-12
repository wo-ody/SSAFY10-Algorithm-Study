package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11401_이항_계수_3 {

	static StringBuilder sb = new StringBuilder();
	static long P = 1_000_000_007;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		long[] divs = new long[N + 1];
		divs[0] = 1;
		divs[1] = 1;

		for (int i = 2; i <= N; i++) {
			divs[i] = (divs[i - 1] * i) % P;
		}
		long tmp1 = pow(divs[R], P - 2);
		long tmp2 = pow(divs[N - R], P - 2);

		System.out.println((((divs[N] * tmp1) % P) * tmp2) % P);
	}

	public static long pow(long base, long exp) {
		long r = 1;

		while (exp > 0) {
			if (exp % 2 == 1) {
				r = (r * base) % P;
				exp -= 1;

			}

			base = (base * base) % P;
			exp >>= 1;

		}
		return r % P;
	}

}
