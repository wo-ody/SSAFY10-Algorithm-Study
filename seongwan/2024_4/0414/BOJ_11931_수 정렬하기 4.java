import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(input);

		for (int i = N - 1; i >= 0; i--) {
			sb.append(input[i]).append("\n");
		}
		System.out.println(sb);
	}
}