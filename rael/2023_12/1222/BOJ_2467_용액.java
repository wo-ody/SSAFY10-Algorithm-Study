import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int value = Integer.MAX_VALUE;
		int[] answer = new int[2];

		st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N - 1;

		while (left < right) {
			int sum = num[left] + num[right];
			int abs = Math.abs(sum);

			if (abs < value) {
				value = abs;
				answer[0] = num[left];
				answer[1] = num[right];
			}

			if (sum <= 0) {
				left++;
			} else {
				right--;
			}

		}
		System.out.println(answer[0] + " " + answer[1]);
	}
}
