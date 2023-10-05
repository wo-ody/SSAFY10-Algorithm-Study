import java.util.Scanner;

public class BOJ_11722_가장_긴_감소하는_부분_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		/*
		 * dp로 뒤에서부터 확인하면서 나보다 작은 수를 찾고 그 위치들에서 가장 숫자가 큰 수에서 +1을 하면 될 것 같음.
		 * 
		 */

		int[] dp = new int[N];
		dp[N - 1] = 1;
		for (int i = N - 2; i >= 0; i--) {
			dp[i] = 1;
			for (int j = i + 1; j < N; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = (dp[i] < dp[j] + 1) ? dp[j] + 1 : dp[i];
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++)
			max = (max < dp[i]) ? dp[i] : max;
		System.out.println(max);
	}

}
