package report;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_18291_비요뜨의징검다리건너기 {
	static int T,N;
	static long num = 1000000007;
	static long ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());	
			N -= 2; //2의 N-2제곱을 구해야함. 
			
			ans = 1;
			long n = 2;
			
			while(N > 0) {
				if(N%2 == 1) {
					ans *= n;
					ans %= num;
				}
				n*=n;
				n%=num;
				N = N>>1;
			}
			
			System.out.println(ans);
		}
		
		
	}

}
