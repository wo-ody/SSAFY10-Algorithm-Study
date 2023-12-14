import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K, num, ans;
	static int[] input, diff;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(input);

		if (N == 1)
			System.out.println(input[0] + K);
		else {
			diff = new int[N - 1];

			diff[0] = input[1] - input[0];
			for (int i = 1; i < N - 1; i++) {
				diff[i] = (input[i + 1] - input[i]) * (i + 1) + diff[i - 1];
			}

			for (int i = 0; i < N - 1; i++) {
				if (diff[i] > K) {
					num = i;
					if (i != 0)
						K -= diff[i - 1];
					break;
				}
				if (i == N - 2) {
					K -= diff[N - 2];
					num = i + 1;
				}
			}
			ans = input[num] + K / (num + 1);
			System.out.println(ans);
		}
	}
}