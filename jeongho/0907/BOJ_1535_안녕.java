package algorithm2023.sep.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 세준이는 N명의 사람 중 몇명에게 인사를 하려고 한다.
 * i번 사람에게 인사를 하면 L[i]만큼의 체력을 잃고, J[i]만큼의 기쁨을 얻는다.
 * 세준이의 체력은 100이다.
 * 체력이 0이하로 떨어지지 않게 가장 많은 기쁨을 얻는 방법은??
 * 
 * -----풀이-----
 * knapsack과 비슷하게 생각
 * 100의 무게와 물건의 무게, 가치를 L, J로 생각하여 풀이
 * 100부터 탐색하여 1차원 배열로 풀이
 */

public class BOJ_1535_안녕 {
	static int N,L[],J[], dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		L = new int[N];
		J = new int[N];
		dp = new int[101];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i =0 ;i<N;i++) {
			L[i] = Integer.parseInt(st.nextToken());
			J[i] = Integer.parseInt(st2.nextToken());
		}
		
		int max = 0;
		for(int i =0;i<N;i++) {
			for(int j =100;j>L[i];j--) {
				dp[j] = Math.max(dp[j], dp[j-L[i]]+J[i]);
			}
		}
		
		System.out.println(dp[100]);
		
		
	}
}
