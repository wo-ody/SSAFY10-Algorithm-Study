import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N, result;
	private static int[] num;

	private static void search(int index) {
		int left = 0;
		int right = N - 1;

		while (true) {
			if (left == index)
				left++;
			else if (right == index)
				right--;

			if (left >= right)
				break;

			if (num[left] + num[right] > num[index])
				right--;
			else if (num[left] + num[right] < num[index])
				left++;
			else {
				result++;
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		num = new int[N];
		result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		for (int i = 0; i < N; i++) {
			search(i);
		}

		System.out.println(result);

	}
}
