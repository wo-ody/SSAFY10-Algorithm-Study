package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {

	static int N, answer;
	static int[] A, tgt;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		tgt = new int[N];
		
		// A 배열 만들기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 순열로 풀기
		perm(0, 0);
		
		System.out.println(answer);
	}
	
	private static void perm(int tgtIdx, int mask) {
		// 기저 조건
		if( tgtIdx == N ) {
			// complete code
			check();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if( (mask & 1<<i ) != 0 )continue;
			tgt[tgtIdx] = A[i];
			perm(tgtIdx+1, mask | 1 << i);
		}
	}
	
	private static void check() {
		int result = 0;
		for (int i = 0; i < N-1; i++) {
			result += Math.abs(tgt[i] - tgt[i+1]);
		}
		if(answer < result) answer = result;
	}

}
