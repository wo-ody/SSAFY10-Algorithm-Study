import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long X, Y, left, right, mid;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		long winRate = (Y * 100 / X);

		left = 1;
		right = 1_000_000_000;

		while (left <= right) {
			mid = (left + right) >> 1;

			long tempRate = ((Y + mid) * 100) / (X + mid);

			if (tempRate > winRate) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}


		System.out.println(left == 1000000001 ? -1 : left);

	}
}