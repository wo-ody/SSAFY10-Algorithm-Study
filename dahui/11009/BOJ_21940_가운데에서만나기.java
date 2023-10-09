package report;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21940_가운데에서만나기 {
	static int N,M,K;
	static int[][] matrix;
	static final int INF = Integer.MAX_VALUE/2;
	static int[][] home;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new int[N+1][N+1]; //0dummy
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			matrix[a][b] = c;
		}
		
		K = Integer.parseInt(br.readLine()); // 총 인원
		home = new int[K][1+N]; //준영이와 친구들이 사는 도시와 해당 도시부터N개의 도시들까지의왕복시간.
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			home[i][0] = Integer.parseInt(st.nextToken());
		}
		
		//못 가는 경우 INF로 채우기
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i!=j&&matrix[i][j] == 0) {
					matrix[i][j] = INF;
				}
			}
		}
		
		for(int i=0; i<K; i++) {
			for(int j=1; j<=N; j++) {
				home[i][j] = INF;
			}
		}
		
		for(int k=1; k<N+1; k++) { //경유지 
			for(int i=1; i<N+1; i++) {
				if(i==k) continue;
				for(int j=1; j<N+1; j++) {
					if(j==k || j==i)continue;
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}
		
		//왕복시간 채워주기 
		for(int i=0; i<K; i++) {
			for(int j=1; j<=N; j++) {
				home[i][j] = matrix[home[i][0]][j] + matrix[j][home[i][0]];
			}
		}
		
		int[] max = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<K; j++) {
				max[i] = Math.max(max[i], home[j][i]);
			}
		}
		
		int ans = INF;
		
		for(int i=1; i<=N; i++) {
			if(max[i] < ans) {
				ans = max[i];
				sb.delete(0, sb.length());
				sb.append(i).append(" ");
			}else if(max[i] == ans) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
		
	}

}
