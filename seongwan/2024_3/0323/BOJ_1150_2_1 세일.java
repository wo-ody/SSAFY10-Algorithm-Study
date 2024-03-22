import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//정렬 후 비싼 것 부터 3개씩 사면 제일 높은 가격으로 할인을 받을 수 있다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(input);

		int cnt = 0;

		for (int i = N - 1; i >= 0; i--) {
			cnt++;
			if (cnt % 3 == 0)
				continue;
			ans += input[i];
		}
		System.out.println(ans);
	}
}