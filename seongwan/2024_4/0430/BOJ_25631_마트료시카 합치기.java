import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] input;
	static int N;
	static int ans = 1;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		input = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			int temp = input[i];

			if (temp == input[i - 1]) {
				cnt++;
				ans = Math.max(ans, cnt);
			} else
				cnt = 1;
		}
		System.out.println(ans);
	}
}