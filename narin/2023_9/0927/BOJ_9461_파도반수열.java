import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		long[] P = new long[101];

		P[1] = 1;
		P[2] = 1;
		P[3] = 1;

		for (int i = 4; i <= 100; i++) {
			P[i] = P[i - 3] + P[i - 2];
		}

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(P[N]).append("\n");
		}

		System.out.println(sb);
	}
}
