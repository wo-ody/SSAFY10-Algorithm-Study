package month10.day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047_동전0 {

	static int N, K, cnt;
	
	static int[] coins;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coins = new int[N];
		
		// 코인배열 받기
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		// 뒤에서부터 팀색
		int idx = N-1;
		
		while(K > 0) {
			if(K - coins[idx] >= 0) {
				cnt+= K / coins[idx];
				K %= coins[idx];
			} else {
				idx--;
			}
		}
		
		System.out.println(cnt);
	}

}
