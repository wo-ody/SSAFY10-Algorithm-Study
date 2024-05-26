import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long left, right, mid;

	public static void main(String[] args) throws Exception {
		long N = Long.parseLong(br.readLine());

		left = 0;
		right = (long) Math.sqrt(Long.MAX_VALUE);

		while (left <= right) {
			mid = (left + right) / 2;

			if (mid * mid >= N) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(left);
	}
}