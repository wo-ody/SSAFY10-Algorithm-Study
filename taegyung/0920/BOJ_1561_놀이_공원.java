package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1561_놀이_공원 {

	static long N;
	static int M;
	static int[] time;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Long.parseLong(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		time = new int[M + 1];
		sarr = br.readLine().split(" ");

		for (int i = 1; i <= M; i++) {
			time[i] = Integer.parseInt(sarr[i - 1]);
			max = Math.max(max, time[i]);
		}

		if (N <= M) {
			bw.write(N + "\n");
			bw.flush();
			return;
		}

		else {
			long t = binSearch(0, (N / M) * max);

			long cnt = M;
			for (int i = 1; i <= M; i++)
				cnt += (t - 1) / time[i];

			for (int i = 1; i <= M; i++) {

				if (t % time[i] == 0)
					cnt++;

				if (cnt == N) {
					bw.write(i + "\n");
					bw.flush();
					return;
				}
			}

		}
	}

	public static long binSearch(long left, long right) {

		long pl = left;
		long pr = right;

		do {

			long pc = (pl + pr) / 2;

			long sum = M;
			for (int i = 1; i <= M; i++) {
				sum += pc / time[i];
			}

			if (sum < N)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

}