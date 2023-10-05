package algorithm2023.aug.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1062_가르침 {
	static int N, K, max;
	static String[] word;
	static boolean[] alph = new boolean[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}
		if (K < 5) {
			System.out.println(0);
		} else if (K == 26) {
			System.out.println(N);
		} else {
			alph['a' - 'a'] = true;
			alph['c' - 'a'] = true;
			alph['t' - 'a'] = true;
			alph['i' - 'a'] = true;
			alph['n' - 'a'] = true;
			find(0, 5);
			System.out.println(max);
		}

	}

	static void find(int index, int cnt) {
		if (cnt == K) {
			int cntW = 0;
			loop: for (int i = 0; i < N; i++) {
				for (int j = 4; j < word[i].length() - 4; j++) {
					if (!alph[word[i].charAt(j) - 'a'])
						continue loop;
				}
				cntW++;
			}
			max = Math.max(max, cntW);
		}

		if (cnt < K) {
			for (int j = index + 1; j < 26; j++) {
				if (!alph[j]) {
					alph[j] = true;
					find(j, cnt + 1);
					alph[j] = false;
				}
			}
		}

	}
}