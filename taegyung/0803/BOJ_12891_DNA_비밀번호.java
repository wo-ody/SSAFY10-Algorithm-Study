package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891_DNA_비밀번호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String dnaString = br.readLine();
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < P; i++) {
			if (dnaString.charAt(i) == 'A') {
				A -= 1;
			} else if (dnaString.charAt(i) == 'C') {
				C -= 1;
			} else if (dnaString.charAt(i) == 'G') {
				G -= 1;
			} else if (dnaString.charAt(i) == 'T') {
				T -= 1;
			}

		}
		int cnt = 0;
		if (A <= 0 && C <= 0 && G <= 0 && T <= 0)
			cnt += 1;
		for (int i = P; i < S; i++) {
			if (dnaString.charAt(i) == 'A') {
				A -= 1;
			} else if (dnaString.charAt(i) == 'C') {
				C -= 1;
			} else if (dnaString.charAt(i) == 'G') {
				G -= 1;
			} else if (dnaString.charAt(i) == 'T') {
				T -= 1;
			}

			if (dnaString.charAt(i - P) == 'A') {
				A += 1;
			} else if (dnaString.charAt(i - P) == 'C') {
				C += 1;
			} else if (dnaString.charAt(i - P) == 'G') {
				G += 1;
			} else if (dnaString.charAt(i - P) == 'T') {
				T += 1;
			}
			if (A <= 0 && C <= 0 && G <= 0 && T <= 0)
				cnt += 1;

		}
		System.out.println(cnt);

	}
}
