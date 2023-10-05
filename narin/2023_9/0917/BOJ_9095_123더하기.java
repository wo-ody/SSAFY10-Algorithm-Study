import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[12];

			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;

			for (int i = 4; i <= n; i++) {
				arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
			}

			sb.append(arr[n]).append("\n");

		}

		System.out.println(sb);
	}
}
