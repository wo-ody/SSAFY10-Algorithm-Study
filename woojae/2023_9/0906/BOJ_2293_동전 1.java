import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k;
	static int[] coins;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coins = new int[n + 1];
		dp = new int[k + 1];
		dp[0] = 1;
		for(int i = 1; i <= n; i++)
			coins[i] = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++)  // 동전을 순서대로 하나씩 가져와서
			for(int target = 1; target <= k; target++)  // 목표 동전을 1 ~ k까지 늘려가며 확인
				if(target - coins[i] >= 0)  // 목표 동전에 현재 동전을 뺄 경우 나오는 값은 이전에 만들 수 있는 경우의 수가 기록되어 있음
					dp[target] += dp[target - coins[i]];  // 경우의 수 갱신
		// 가령 target이 7이고 현재 동전이 3이라면 기존 target을 만들 수 있는 경우의 수에 4(7 - 3)를 만들 수 있는 경우의 수 누적
		// 만약 4가 0이 아니라면 이전 동전들 혹은 현재 동전으로 해당 target을 만들 수 있다는 것을 의미
		System.out.println(dp[k]);
	}
}
