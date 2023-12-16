import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, right, left = 1;
	static int[] budget;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		budget = new int[N];

		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			right = Math.max(budget[i], right);
		}

		M = Integer.parseInt(br.readLine());
		find();

	}

	static void find() {
		while (left <= right) {
			int half = (left + right) / 2;
			int count = 0;

			for (int i = 0; i < N; i++) {
				int temp = Math.min(half, budget[i]);
				count += temp;
			}

			if (count > M) {
				right = half - 1;
			} else if (count < M) {
				left = half + 1;
			} else {
				System.out.println(half);
				return;
			}
		}
		System.out.println(right);
	}
}