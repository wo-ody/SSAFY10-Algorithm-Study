package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {
	static int n,m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Arrays.sort(arr); //오름차순으로 정렬하기
		
		for(int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			binarySearch(num);
		}
		
		System.out.println(sb);
	}
	
	static void binarySearch (int num) {
		int left = 0;
		int right = n-1;
		
		while(left <= right) {
			int midIdx = (left + right)/2;
			int mid = arr[midIdx];
			
			if(num < mid) right = midIdx-1;
			else if(num > mid) left = midIdx+1;
			else {
				sb.append(1).append(" ");
				return;
			}
		}
		sb.append(0).append(" ");
		return;
	}

}
