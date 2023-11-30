package algorithm2023.nov.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] arr;
	static int N, C;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i= 0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i] = n;
		}
		
		Arrays.sort(arr);
		int lo =1;
		int hi = arr[N-1]-arr[0]+1;
		while(lo<hi) {
			int mid = (lo+hi)/2;
			if(cntRouter(mid)<C) {
				hi = mid;
			}else {
				lo = mid+1;
			}
		}
		
		System.out.println(lo-1);
		
	}
	
	
	static int cntRouter(int d) {
		int cnt = 1;
		int cur = arr[0];
		for(int i =1;i<N;i++) {
			int next = arr[i];
			if(next-cur>=d) {
				cnt++;
				cur = next;
			}
		}
		return cnt;
	}
}
