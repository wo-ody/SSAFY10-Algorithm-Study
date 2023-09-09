import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n + 1];
		int[] box = new int[1001];

		Arrays.fill(box, 1);

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		box[input[1]] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (input[i] > input[j] && box[i] < box[j] + 1) {
					box[i] = box[j] + 1;
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (box[i] > result) {
				result = box[i];
			}
		}

		System.out.println(result);
	}
}
