import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T, N, M;
	static StringTokenizer st;
	static int[] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			input = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					if (input[j] + input[k] < M)
						continue;
					if (input[j] + input[k] == M) {
						ans++;
						break;
					}
					if (input[j] + input[k] > M)
						break;

				}
			}

			sb.append("Case #").append(i).append(": ").append(ans).append("\n");

		}
		System.out.println(sb);
	}
}