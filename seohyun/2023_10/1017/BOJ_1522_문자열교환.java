package BOJ;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1522_문자열교환 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int cnt = 0;
		int[] idx = new int[3000];
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'b') idx[cnt++] = i;
		}
		
		int tmp = cnt; // 처음과 끝이 이어져있어서 처음 부분을 뒤에 더 넣어줌 ㅎㅎ
		for (int i = 0; i < tmp; i++) {
			idx[cnt++] = (idx[i] + str.length());
		}
		
		if(cnt <= 1) {
			System.out.println(0);
			return;
		}
		
		int result = Integer.MAX_VALUE;
		int last = idx[cnt-1];
		int[] dp = new int[last+1];
		
		for (int i = 0; i <= last; i++) {
 			int low = i;
			int high = i + tmp - 1;
			int count = 0;
			for (int j = 0; j < cnt; j++) {
				if(low <= idx[j] && idx[j] <= high) count++;
			}
			
			dp[i] = tmp - count;
			
			result = Math.min(result, dp[i]);
		}
		
		System.out.println(result);
	}

}
