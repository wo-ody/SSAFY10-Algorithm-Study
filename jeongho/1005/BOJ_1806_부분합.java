package algorithm2023.oct.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, S, arr[];
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		
		st = new StringTokenizer(br.readLine());
		
		//문자열의 길이 N, 합의 최솟값 S
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		//배열의 길이 초기화
		arr = new int[N+1];
		
		//입력
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		//투포인터를 위한 왼쪽, 오른쪽 위치 포인터
		int lo = 0;
		int hi = 0;
		
		//합을 나타내는 수
		long sum = 0;
		
		//투포인터 로직
		while(lo<=hi) {
			//합이 S보다 작으면 오른쪽 포인터 증가
			if(sum<S) {
				if(hi==N)break;
				sum+=arr[hi++];
				//합이 S보다 크면 왼쪽 포인터 증가
			}else {
				ans = Math.min(ans, hi-lo);
				sum-=arr[lo++];
			}
		}
		
		
		
		System.out.println(ans==Integer.MAX_VALUE?0:ans);
		
	}
	
	
	
}
