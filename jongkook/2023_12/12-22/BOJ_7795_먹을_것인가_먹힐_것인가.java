package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795_먹을_것인가_먹힐_것인가 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int lenA = Integer.parseInt(st.nextToken());
			int lenB = Integer.parseInt(st.nextToken());
			
			int[] A  = new int[lenA];
			int[] B = new int[lenB];
			
			// A 배열 만들기
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < lenA; i++) A[i] = Integer.parseInt(st.nextToken());
						
			// B 배열 만들기
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < lenB; i++) B[i] = Integer.parseInt(st.nextToken());
			
			// 정렬 후 이분탐색하기
			Arrays.sort(A);
			Arrays.sort(B);
			
			int count = 0;
			
			for(int i = 0; i < lenA; i++) {
				System.out.println(Arrays.binarySearch(B, A[i]));
				int bin = Arrays.binarySearch(B, A[i]);
				int absBin = Math.abs(Arrays.binarySearch(B, A[i]));
				if(bin < 0) count += absBin - 1;
				else if(bin >= 0) count += bin;
			}			
			System.out.println(count);
		}
	}
}
