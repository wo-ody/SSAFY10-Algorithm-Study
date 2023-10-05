package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13144_List_Of_Unique_Numbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] numArr = new int[N];

		boolean[] checker = new boolean[N + 1];
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());

		}

//		int cnt = 0;
		int start = 0;
		int end = 0;
		long sum = 0;

//		while (start != N-1) {
//			
//		} 
//		for(int i = 0 ; i < N; i ++) {
//			
//		}
		while (end < N) {
			if (checker[numArr[end]]) { // 존재한다 ( 수열 안에 포함돼있다. )
				// TODO 얘는 여기서 이제 끝
//				sum += (end - start);
				while (end > start) {
					sum += (end - start);
					checker[numArr[start]] = false;
					if (numArr[end] == numArr[start]) {
//						sum += (end - start);
						start++;
						break;
					}
					start++; // 다음
//					sum += (end - start);
				}
			} else {
				checker[numArr[end++]] = true;
			}
		}
		for (int i = 1; i <= (end - start); i++) {
			sum += i;
		}
		System.out.println(sum);

	}
}
