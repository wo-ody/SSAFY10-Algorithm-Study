package ambigous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_11053_가장_긴_증가하는_부분_수열 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] array = new int[count];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < count; i++) array[i] = Integer.parseInt(st.nextToken());
		int[] dp = new int[count];
		dp[0] = 1;

		for(int i = 1; i < count; i++){
			dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(array[i] > array[j] && dp[i] <= dp[j]) dp[i] = dp[j]+1;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int d : dp) max = Math.max(max, d);
		System.out.println(max);




	}

}
