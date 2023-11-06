package swea;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class swea_5607_조합 {
	static int T,N,R;
	static int mod = 1234567891;
	static long[] f = new long[1000001];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		// factorial 만들기
		make_f();
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			long c1 = f[N];
			long c2 = cal((f[N-R] * f[R]) % mod ,mod-2);
			
			sb.append("#").append(tc).append(" ").append(c1 * c2 % mod).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static long cal(long n, long k) {
		if(k == 1) return n;
		
		long x = cal(n, k/2) % mod;
		if(k%2==0) {
			return (x*x) % mod;
		}
		else {
			return (x*x) % mod *n % mod;
		}
	}
	
	static void make_f() {
		f[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			f[i] =  f[i-1] * i  % mod;
		}
	}

}
