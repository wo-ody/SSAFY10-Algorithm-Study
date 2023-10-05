import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int[] zero, one;

	private static void fibonacci(int n) {
		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;
		for (int i = 2; i <= n; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			zero = new int[41];
			one = new int[41];
			fibonacci(N);
			sb.append(zero[N] + " " + one[N] + "\n");
		}

		System.out.println(sb);
	}
}
