package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4354_문자열_제곱 {

	static int[] pi;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 10; tc++) {
			s = br.readLine();

			if (s.equals(".")) // 종료
				break;
			pi = new int[s.length()];

			makePi(s);

//			System.out.println(Arrays.toString(pi));

			int value = pi[s.length() - 1];

//			boolean flag = true;
//			for (int i = 0; i < s.length(); i++) {
//				if (pi[i] == 0)
//					continue;
//
//				if (pi[i] == value + 1) {
//					value += 1;
//
//				} else if (value == 1)
//					continue;
//				else {
//					flag = false;
//					break;
//				}
//			}

//			if (!flag) {
//				value = 0;
//			}

//			System.out.println(s.length() / (s.length() - value) == s.length() / (s.length() - value));
//			System.out.println(1 == 1.0);
			System.out.println(s.length() % (s.length() - value) == 0 ? s.length() / (s.length() - value) : 1);

		}
	}

	public static void makePi(String p) {
		char[] pArray = p.toCharArray();

		int j = 0;

		for (int i = 1; i < pArray.length; i++) {
			while (j > 0 && pArray[i] != pArray[j])
				j = pi[j - 1];

			if (pArray[i] == pArray[j])
				pi[i] = ++j;
		}
	}
}
