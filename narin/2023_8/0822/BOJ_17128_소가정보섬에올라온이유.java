import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, Q;
	private static int[] level, sum;
	private static int S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		level = new int[N + 1];
		sum = new int[N + 1];
		S = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			level[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			int a1 = i, a2 = i + 1, a3 = i + 2, a4 = i + 3;
			if (a2 > N)
				a2 -= N;
			if (a3 > N)
				a3 -= N;
			if (a4 > N)
				a4 -= N;
			sum[i] = level[a1] * level[a2] * level[a3] * level[a4];
			S += sum[i];
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int change = Integer.parseInt(st.nextToken());
			int change2 = change - 1, change3 = change - 2, change4 = change - 3;
			if (change2 < 1)
				change2 += N;
			if (change3 < 1)
				change3 += N;
			if (change4 < 1)
				change4 += N;

			sum[change] *= -1;
			sum[change2] *= -1;
			sum[change3] *= -1;
			sum[change4] *= -1;

			S = S + 2 * (sum[change] + sum[change2] + sum[change3] + sum[change4]);

			sb.append(S + "\n");
		}

		System.out.println(sb);
	}

}
