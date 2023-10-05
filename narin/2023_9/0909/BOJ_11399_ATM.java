import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		/** 누적합 */
		int[] time = new int[N + 1];
		int result = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time);

		for (int i = 1; i <= N; i++) {
			time[i] += time[i - 1];
			result += time[i];
		}

		System.out.println(result);

	}
}
