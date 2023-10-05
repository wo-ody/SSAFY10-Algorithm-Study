package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1305_광고 {
	static String advertisement;
	static int L;

	static int[] pi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(br.readLine());
		advertisement = br.readLine();

		pi = new int[L];
//		System.out.println(Arrays.toString(pi));
		makePi(advertisement);

//		System.out.println(Arrays.toString(pi));
//		int max_len = -1;
//		for (int i = 0; i < L; i++) {
//			max_len = Math.max(max_len, pi[i]);
//		}

//		System.out.println(L - max_len);

		System.out.println(L - pi[L - 1]);
	}

	public static void makePi(String p) {
		char[] pArray = p.toCharArray();

		int j = 0; // -> 초기화
		for (int i = 1; i < pArray.length; i++) { // 저장할 위치

			while (j > 0 && pArray[j] != pArray[i]) {
				j = pi[j - 1];
			}

			if (pArray[i] == pArray[j]) {
				pi[i] = ++j;
			}

		}
	}
}
