package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16401_과자나눠주기 {
	static int M,N,ans,max;
	static int[] snack;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		snack = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, snack[i]);
		}
		
		int left = 1;
		int right = max;
		
		binarySearch(left, right);
		
		System.out.println(ans);
	}
	//과자 길이 정하기 
	static void binarySearch(int left, int right) {
		int mid = 0;
		
		while(left <= right) {
			mid = (left+right) / 2;
			
			int cnt = can(mid); //해당 길이로 몇명에게 나눠줄 수 있는지
			
			if(cnt >= M) { //나눠줄 수 있는 크기라면 더 큰 크기 찾아보기
				left = mid+1;
				ans = Math.max(ans, mid);
			}else { //나눠줄 수 없는 크기라면 더 작은 크기 찾아보기 
				right = mid-1;
			}
		}
	}
	
	static int can(int length) {
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			cnt += snack[i]/length;
		}
		
		return cnt;
	}
}
