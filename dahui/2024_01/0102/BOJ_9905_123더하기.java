package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	static int n;
	static long[] num = new long[12];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		num[1] = 1;
		num[2] = 2;
		num[3] = 4;
		
		for(int i=4; i<=11; i++) {
			num[i] = num[i-3] + num[i-2] + num[i-1];
		}
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			sb.append(num[n]).append("\n");
		}
		System.out.println(sb);
	}
}
