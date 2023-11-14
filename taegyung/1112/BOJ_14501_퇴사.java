import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, ans;// 퇴사까지 남은 일 수,정답
	static int[] T, P, dp;// 걸리는 일 수,보상 금액,뒤에서 부터 얻을 수 있는 최대값 계산

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		dp = new int[N + 2];// 인덱스를 맞춰주기 위해 0은 더미

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());

		} // 입력을 받고 배열에 저장
		choice();
		System.out.println(ans);
	}

	static void choice() {
		dp[N + 1] = 0;
		for (int i = N; i >= 0; i--) {
			int max = 0;
			if (i + T[i] > N + 1)
				dp[i] = 0;
			else {
				for (int j = N + 1; j >= i + T[i]; j--) {
					max = Math.max(max, dp[j]);
				}
				dp[i] = max + P[i];
			}
		}
		for (int i = 0; i <= N + 1; i++) {
			ans = Math.max(ans, dp[i]);
		}
	}//dp에 저장된 최대값을 ans에 저장
}
