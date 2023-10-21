import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회2 {
	static int N, END, MIN = Integer.MAX_VALUE;
	static int W[][];
	static int tgt[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		tgt = new int[N+1];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Perm(0, 0);
		
		System.out.println(MIN);
	}
	
	static void Perm(int tgtIdx, int mask) {
		//기저조건
		if(tgtIdx == N) {
			//complete code
			tgt[N] = tgt[0];

			int sum=0;
			for(int i=0; i<N; i++) {
				if(W[tgt[i]][tgt[i+1]] == 0) return;
				sum += W[tgt[i]][tgt[i+1]];
			}
			
			MIN = Math.min(sum, MIN);
			
			return;
		}
		
		//풀이
		for(int i=0; i<N; i++) {
			//방문체크
			if((mask & 1 << i) != 0) continue;
			
			tgt[tgtIdx] = i;
			//처음
			Perm(tgtIdx+1, mask | 1 << i);
		}
	}
}