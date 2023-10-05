package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과_M_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] target;
	static int[] src;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		src = new int[N];
		for (int i = 0; i < N; i++) {
			src[i] = i + 1;
		}
		target = new int[M];

		comb(0, 0);

	}

	public static void comb(int tgtIdx, int srcIdx) {
		if (tgtIdx == target.length) {
			for (int i = 0; i < target.length; i++) {
				sb.append(target[i]).append(" ");
			}
			System.out.println(sb);
			sb = new StringBuilder();
			return;
		}

		if (srcIdx == src.length)
			return;
		target[tgtIdx] = src[srcIdx];
		comb(tgtIdx + 1, srcIdx + 1);
		comb(tgtIdx, srcIdx + 1);

	}
}
