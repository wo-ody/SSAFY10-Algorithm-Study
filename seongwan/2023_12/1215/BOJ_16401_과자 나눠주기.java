import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M, N, right, left = Integer.MAX_VALUE;
	static int[] cookies;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		cookies = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cookies[i] = Integer.parseInt(st.nextToken());
			right = Math.max(cookies[i], right);
			left = Math.min(cookies[i], left);
		}

		if (M > N)
			left = right / M == 0 ? 1 : right / M;// 조카들의 수가 과자의 수보다 많다면 제일 긴 길이의 과자를 필요한 과자수만큼 쪼갠 길이부터 탐색 // 작은 길이부터 탐색

		find();
	}

	static void find() {
		while (left <= right) {
			int half = (left + right) / 2;
			int count = 0;

			for (int i = 0; i < N; i++) {
				int temp = cookies[i] / half;
				count += temp;
			}

			if (count < M) {
				right = half - 1;
			} else {
				left = half + 1;
			}

		}
		System.out.println(right);
	}
}