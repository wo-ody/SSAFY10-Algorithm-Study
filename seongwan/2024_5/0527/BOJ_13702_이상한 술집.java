import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K;
	static int[] input;
	static StringTokenizer st;
	static long left, right, mid;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(input);
		right = input[N - 1];

		while (left <= right) {
			mid = (left + right) / 2;
			if (mid == 0)
				break;

			int cnt = 0;

			for (int i = 0; i < N; i++) {
				cnt += input[i] / mid;
			}

			if (cnt >= K)
				left = mid + 1;
			else
				right = mid - 1;
		}

		System.out.println(right);
	}
}