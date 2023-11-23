import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, ans;
	static Integer[] input;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		input = new Integer[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(input, (i1, i2) -> i2 - i1);

		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, input[i] * (i + 1));
		}
		System.out.println(ans);
	}
}