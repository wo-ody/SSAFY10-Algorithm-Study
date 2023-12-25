package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2193_이친수 {
	static int N;
	static long[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new long[N+1];
		arr[1] = 1;
		
		for(int i=2; i<=N; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		
		System.out.println(arr[N]);

	}

}
