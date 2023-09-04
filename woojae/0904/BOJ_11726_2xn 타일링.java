import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		
		switch (n) {
		case 1:
			System.out.println(1);
			break;
		default:
			dp[1] = 1;
			dp[2] = 2;
			for(int i = 3; i <= n; i++)
				dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;  // 마지막에만 나누는 것이 아니라 상시 나눠줘야 함
			// 1과 2는 고정이므로 n을 만들기 위한 경우의 수로 1과 2를 뺐을 때 나오는 경우의 수의 합을 구하면 됨
			System.out.println(dp[n]);
		}
	}
}