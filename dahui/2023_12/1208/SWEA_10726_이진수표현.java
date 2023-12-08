package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10726_이진수표현 {
	static int T,N,M;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int n = (int)Math.pow(2, N) - 1;
			
			if( (n & M) == n) sb.append("#").append(t).append(" ").append("ON").append("\n");
			else  sb.append("#").append(t).append(" ").append("OFF").append("\n");
		}
		
		System.out.println(sb);
	}
}
