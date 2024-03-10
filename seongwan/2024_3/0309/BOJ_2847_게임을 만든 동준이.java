import java.io.BufferedReader;
import java.io.InputStreamReader;

//맨 뒤의 값은 그대로 두고 그 앞부터 맨 앞까지
//한 칸 뒤의 수보다 작다면 그대로 두고 같거나 크다면 -1인 수가 될 수 있게 값을 뺀다.
//뺀 값을 다 더하면 정답
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		int ans = 0;

		for (int i = N - 2; i >= 0; i--) {
			//뒤의 값보다 작은 상황이라면
			if (input[i] < input[i + 1]) {
				continue;
			} else {
				ans += input[i] - (input[i + 1] - 1);
				input[i] = input[i + 1] - 1;
			}
		}
		System.out.println(ans);
	}
}