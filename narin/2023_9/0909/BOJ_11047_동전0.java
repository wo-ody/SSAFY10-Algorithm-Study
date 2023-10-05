import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] value = new int[N];
		int count = 0;

		for (int i = N - 1; i >= 0; i--) {
			value[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N; i++) {
			if (value[i] <= K) {
				count += K / value[i];
				K = K % value[i];
			}
		}

		System.out.println(count);
	}
}
