import java.io.*;
import java.util.*;
public class BOJ_2294_동전2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Integer> coins = new ArrayList<>();
		boolean visit[] = new boolean[10001];
		int c;
		for (int i=0; i<n; i++) {
			c = Integer.parseInt(br.readLine());
			if (c>=10000 || visit[c]) continue;
			visit[c] = true;
			coins.add(c);
		}
		Collections.sort(coins, Collections.reverseOrder());
		
		int[] dp = new int[k+1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;
		
		for (int coin : coins) {
			for (int i=coin; i<=k; i++) {
				dp[i] = Math.min(dp[i],dp[i-coin]+1);
			}
		}
		System.out.println(dp[k]==10001 ? -1:dp[k]);
	} // main

}