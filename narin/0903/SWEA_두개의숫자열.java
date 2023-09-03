import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] A = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			int sum = 0;
			int max = 0;

			if (N < M) {
				for (int i = 0; i < M - N + 1; i++) {
					for (int j = 0; j < N; j++) {
						sum += A[j] * B[i + j];
					}
					if (sum > max) {
						max = sum;
					}
					sum = 0;
				}
			} else {
				for (int i = 0; i < N - M + 1; i++) {
					for (int j = 0; j < M; j++) {
						sum += B[j] * A[i + j];
					}
					if (sum > max) {
						max = sum;
					}
					sum = 0;
				}
			}

			sb.append(max + "\n");
		}

		System.out.println(sb);

	}
}
