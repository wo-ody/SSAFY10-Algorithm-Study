import java.util.*;

public class Main { 

	public static void main(String[] args) { // DP를 이용한 풀이
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		int[] dp = new int[n];
		String[] route = new String[n]; // 경로 저장
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
			dp[i] = 1;
			route[i] = ""+A[i];
		}
		int max, maxindex;
		maxindex = max = 0;
		for (int i = 0; i < n; i++) {
			for (int j=i; j<n; j++) {
				if (A[j] > A[i]) {
					if (dp[j] < dp[i]+1) { i 번째 다음에 갈 수 있는 모든 j에 대하여
						dp[j] = dp[i]+1; // i번째에 더 큰 경우 저장
						route[j] = route[i] + " " + A[j];
						if (max < dp[j]) {
							max = dp[j]; // max가 저장
							maxindex = j; // max 저장된 인덱스
						}
					}
				}
			}
		}
		System.out.println(dp[maxindex]);
		System.out.println(route[maxindex]);
		sc.close();
	}

}