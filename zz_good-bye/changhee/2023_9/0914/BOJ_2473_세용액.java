/*
 *  09.14 김창희
 *  BOJ_2473_세용액
 *
 *  [풀이]
 *  1. 투 포인터로 차이가 가장 작은 두 점을 찾는것에서 한번더 반복문을 돌려 mid라는 점을 잡고 세점을 더하며 탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static long[] arr, result=new long[3];
	static int n;
	static long diff = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr =new long[n];
		
		st=new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i =0; i<n-2; i++) {
			if(search(i)) break;
		}
		
		Arrays.sort(result);
		StringBuilder answer = new StringBuilder();
		answer.append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]);
		System.out.println(answer);
		
	}
	
	public static boolean search(int start) {
		int mid =start+1, end = n-1;
		while(mid<end) {
			long temp = arr[start]+arr[mid]+arr[end];
			
			if(diff>Math.abs(temp)) {
				diff = Math.abs(temp);
				result[0] = arr[start];
				result[1] = arr[mid];
				result[2] = arr[end];
			}
			
			if(temp == 0) break;
			
			if(temp>0) end--;
			else mid++;
			
		}
		
		if(diff==0) return true;
		return false;
	}
}
