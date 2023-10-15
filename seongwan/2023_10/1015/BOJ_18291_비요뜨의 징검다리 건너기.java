import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T, N;
	static StringBuilder sb = new StringBuilder();
	static int P = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			sb.append(power(N - 2) + "\n");
		}
		System.out.println(sb);
	}

	static int power(int N) {
		long num = 2;
		long result = 1;
		while (N > 0) {
			if ((N & 1) == 1)
				result = result * num % P;
			N >>= 1;
			num = num * num % P;
		}
		return (int) result;
	}

}