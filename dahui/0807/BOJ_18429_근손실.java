package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_근손실 {
	static int K,N;
	static int[] plan;
	static int kg,count;
	static boolean[] select;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		plan = new int[N];
		select = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		kg = 500;
		excercise(0);
		
		System.out.println(count);
	}
		
	static void excercise(int planIdx) {
		//기저 조건
		if(planIdx == N) {
			count++;
			return;
		}
		
		
		for(int i=0; i<N; i++) { //루틴 순열 돌기
			if(select[i]) continue;
			kg -= K;
			kg += plan[i];
			if(kg >= 500) {
				select[i] = true;
				excercise(planIdx + 1);
				select[i] = false;
			}
				kg += K;
				kg -= plan[i];

		}
		
		
	}
}
