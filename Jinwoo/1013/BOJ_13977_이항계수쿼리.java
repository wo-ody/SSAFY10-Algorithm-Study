import java.util.*;
import java.io.*;
public class Main {
	static long[] facto = new long[4_000_001];
	static int modular = 1_000_000_007;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		facto[0]=facto[1] = 1;
		for (int i=2; i<4_000_001; i++) facto[i] = (facto[i-1] * i)%modular;
		
		int m = Integer.parseInt(br.readLine()), n, k;
		StringBuilder sb = new StringBuilder();
		long ans;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			ans = facto[n];
			ans *= pow(facto[k], modular-2);
			ans %= modular;
			ans *= pow(facto[n-k], modular-2);
			sb.append(ans%modular).append("\n");
		}
		System.out.println(sb);
	}

	static long pow(long base, int exp) {
		long res = 1;
		while (exp >0) {
			if ((exp&1) == 1) {res*=base; res%=modular;}
			exp>>=1; base*=base; base%=modular;
		}
		return res;
	}
}
