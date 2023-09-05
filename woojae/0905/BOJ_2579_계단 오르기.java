import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] arr, dp;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1];
		
		for(int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		if(n == 1)  // 1일 땐 밟을 계단이 하나 밖에 없다.
			System.out.println(arr[1]);
		else if(n == 2)  // 연속해서 2개까지 밟을 수 있는데, 최대를 만들어야 하는 상황에서 하나를 건너뛸 필요는 없다.
			System.out.println(arr[1] + arr[2]);
		else {
			dp[1] = arr[1];
			dp[2] = arr[1] + arr[2];  // dp는 현재 칸을 밟을 때 만들 수 있는 최대 점수를 기록한다.
			for(int i = 3; i <= n; i++)  // 현재까진 세 문제 정도의 dp문제를 풀어본 바, n = 4일 때까지만 보면 패턴 확인이 가능했다.
				dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
			// 세 번째 칸을 밟을 수 있는 경우의 수는 처음엔 연속적으로 오르다가 하나를 건너뛰거나 시작하자마자 건너뛰고 연속적으로 오르는 경우이다.
			// n = 3일 때 오를 수 있는 경우의 수: (0) 1, 3 or (0) 2, 3
			// n = 4일 때 오를 수 있는 경우의 수: 1, 2, 4 or 1, 3, 4
			// 이러한 패턴을 수식으로 표현하면 위와 같아지면 해당 문제는 최대를 구하는 문제이므로 max를 사용하여 비교해준다.
			System.out.println(dp[n]);
		}
	}
}