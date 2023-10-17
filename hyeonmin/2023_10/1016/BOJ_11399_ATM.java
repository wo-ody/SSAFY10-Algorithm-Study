package month10.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {

	static int N, ans;
	
	static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(p);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				ans += p[j];
			}
		}
		
		System.out.println(ans);
	}

}
