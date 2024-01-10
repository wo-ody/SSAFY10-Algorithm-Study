import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,Tscore, P;
	static int[] score;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Tscore = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
	
		if(N == 0) System.out.println(1);
		else {
			score = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			
			if(N == P && score[N-1] >= Tscore) System.out.println(-1);
			else {
				for(int i=0; i<N; i++) {
					if(score[i] <= Tscore) {
						System.out.println(i+1);
						break;
					}
					
					if(i == N-1) System.out.println(N+1);
				}
			}
		}
		
	}

}
