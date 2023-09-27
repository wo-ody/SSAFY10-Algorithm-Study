package report;

import java.util.Scanner;

public class BOJ_10974_순열 {
	static int N;
	static int[] tgt;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tgt = new int[N];
		select = new boolean[N];
		
		perm(0);
		System.out.println(sb);
		
	}
	
	static void perm(int srcIdx) {
		//기저조건
		if(srcIdx == N) {
			//Complete Code
			for(int i=0; i<tgt.length; i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		

		for(int i=0; i<N; i++) {
			if(select[i]) continue;
			tgt[srcIdx] = i+1;
			select[i] = true;
			perm(srcIdx + 1);
			select[i] = false;
		}
	}
}
