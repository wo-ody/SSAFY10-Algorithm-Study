package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class S1_1914_하노이탑 {
	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
        BigInteger bi = new BigInteger("2");
        BigInteger c = bi.pow(n).subtract(BigInteger.ONE); // 2의 n제곱 - 1
        System.out.println(c);
		if (n <= 20) {
			hanoi(n, 1, 2, 3);
			System.out.print(sb);
		}
	}

	static void hanoi(int k, int start, int via, int to) {
		if (k == 1) {
			sb.append(start).append(" ").append(to).append("\n");
			return;
		}
		hanoi(k - 1, start, to, via);
		sb.append(start).append(" ").append(to).append("\n");
		hanoi(k - 1, via, start, to);
		

	}
}
