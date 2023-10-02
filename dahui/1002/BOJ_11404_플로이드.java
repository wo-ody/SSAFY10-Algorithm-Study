package report;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//양방향이 아님 
public class BOJ_11404_플로이드 {
	static int n,m;//도시 수, 버스 수 
	static int[][] matrix;
	static final int INF = 10000001;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		matrix = new int[n+1][n+1]; //0은 dummy
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //출발 도시 
			int b = Integer.parseInt(st.nextToken()); //도착 도시 
			int c = Integer.parseInt(st.nextToken()); //비용 
			
			if(matrix[a][b] != 0 && matrix[a][b] < c) {
				continue;
			}else matrix[a][b] = c;
			
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i!=j && matrix[i][j] == 0) matrix[i][j] = INF;
			}
		}
	
		for(int k=1; k<n+1; k++) { //경유지 
			for(int i=1; i<n+1; i++) {
				if(i==k) continue;
				for(int j=1; j<n+1; j++) {
					if(j==k || j==i)continue;
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(matrix[i][j] == INF) {
					sb.append(0).append(" ");
				}else {
					sb.append(matrix[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
