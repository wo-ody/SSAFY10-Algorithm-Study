import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int t;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			int target = Integer.parseInt(br.readLine());
			dp = new int[12];  // 최대 11
			dp[1] = 1; dp[2] = 2; dp[3] = 4;  // 주어진 제약에 대해선 경우의 수를 구해줌
			if(target > 3)
				for(int i = 4; i <= target; i++)
					dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			sb.append(dp[target]).append("\n");
		}
		System.out.println(sb);
	}
}

/*
 * dp[4] -> dp[3], 즉 3을 만들 수 있는 경우의 수 조합에서 1을 더하면 4를 만들 수 있음
 * 마찬가지로 dp[2], 2를 만들 수 있는 경우의 수 조합에서 2를 더하면 4를 만들 수 있음
 * 이러한 규칙을 가지고 1, 2, 3과 이전 조합을 통해 현재 수에 대한 경우의 수를 구할 수 있음
 * 가령 i = 8이라면 1 + dp[7], 2 + dp[6], 3 + dp[5]과 같이 구할 수 있음*/
