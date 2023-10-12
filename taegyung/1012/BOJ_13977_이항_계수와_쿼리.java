package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13977_이항_계수와_쿼리 {

	static StringBuilder sb = new StringBuilder();
	static long P = 1_000_000_007;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());

		long[] divs = new long[4_000_000 + 1];
		divs[0] = 1;
		divs[1] = 1;

		for (int i = 2; i <= 4_000_000; i++) {
			divs[i] = (divs[i - 1] * i) % P;
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < M; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			// N!이 나온다

//					long tmp1 = 1;
//					long tmp2 = 1;
			long tmp1 = pow(divs[R], P - 2);
			long tmp2 = pow(divs[N - R], P - 2);

			sb.append((((divs[N] * tmp1) % P) * tmp2) % P).append("\n");
//			System.out.println((((divs[N] * tmp1) % P) * tmp2) % P);
		}
		System.out.println(sb);

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