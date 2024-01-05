package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1439_뒤집기 {
	static String S;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		
		int cnt = 0;
		int pre = S.charAt(0) - '0';
		int now = 0;
		
		for(int i=1; i<S.length(); i++) {
			now = S.charAt(i) - '0';
			
			if(now != pre) cnt++;
			
			pre = now;
		}
		
		int ans = (cnt+1)/2;
		
		System.out.println(ans);
	}

}
