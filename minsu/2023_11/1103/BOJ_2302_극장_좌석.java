import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int ans = 1;

		// vip 좌석을 제외한 나머지 좌석의 경우의 수를 서로 곱함.
		int beforeSeat = 0;
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(br.readLine());
			ans *= dp[temp - beforeSeat - 1];
			beforeSeat = temp;
		}
		ans *= dp[N - beforeSeat]; // 마지막 vip 좌석 다음 좌석에서 끝 좌석까지의 경우의 수.

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
