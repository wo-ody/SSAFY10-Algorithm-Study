import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int K, N, count;
	private static int[] line;

	private static void binarySearch(long start, long end) {
        long result = 0;
		while (start <= end) {
			long len = (start + end) / 2;

			count = 0;
			for (int i = 0; i < K; i++) {
				count += line[i] / len;
			}

			if (count >= N) {
				result = len;
				start = len + 1;
			} else {
				end = len - 1;
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		line = new int[K];

		for (int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(line);

		binarySearch(1, line[K - 1]);
	}
}
