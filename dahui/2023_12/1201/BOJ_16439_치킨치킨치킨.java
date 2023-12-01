package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16439_치킨치킨치킨 {
	static int[][] p; //선호도
	static int[] tgt = new int[3];
	static int N,M,ans;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
		System.out.println(ans);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			int s = preference();
			ans = Math.max(ans, s);
			return;
		}
		
		if(srcIdx == M) return;
		
		tgt[tgtIdx] = srcIdx;
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);
	}
	
	static int preference() {
		int sum = 0;
		for(int i=0; i<N; i++) {
			int chic = 0;
			for(int j=0; j<3; j++) { //치킨 수
				chic = Math.max(chic, p[i][tgt[j]]);
			}
			sum += chic;
		}
		
		return sum;
	}

}
