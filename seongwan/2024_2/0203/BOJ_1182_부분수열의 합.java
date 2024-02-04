import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N이 20까지 이므로 2^20 =100만 으로 전체 다 계산해보면 될 거 같음
//각 자리의 수를 뽑거나 뽑지 않거나 2가지의 20제곱
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, S, ans;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		finding(0, 0);

		//모두 다 더하지 않고 0이 나오는 경우 제외
		System.out.println(S == 0 ? ans - 1 : ans);

	}

	private static void finding(int idx, int sum) {
		if (idx == N) {
			if (sum == S) {
				ans++;
			}
			return;
		}

		sum += numbers[idx];
		finding(idx + 1, sum);
		sum -= numbers[idx];
		finding(idx + 1, sum);
	}
}