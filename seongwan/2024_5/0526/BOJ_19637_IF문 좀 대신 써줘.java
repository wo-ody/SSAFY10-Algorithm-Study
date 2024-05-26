import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] range;
	static String[] title;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(BR.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		range = new int[N];
		title = new String[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(BR.readLine());
			title[i] = st.nextToken();
			range[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int power = Integer.parseInt(BR.readLine());
			sb.append(findTitle(power)).append("\n");
		}

		System.out.print(sb);
	}

	static String findTitle(int power) {
		int left = 0, right = N - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (range[mid] >= power) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return title[left];
	}
}