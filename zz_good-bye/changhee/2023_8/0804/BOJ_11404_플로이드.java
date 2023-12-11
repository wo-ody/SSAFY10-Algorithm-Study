/*
 *	08.04 김창희
 *	BOJ_11404_플로이드
 *
 *	[풀이]
 *	1. 플로이드-워셜 : 다익스트라가 A에서 B로 가는 최소 정점이라면 플로이드는 오든 정점에대한 최소비용이다.
 *	2. n의3승이므로 n이 작을때만 사용하자
 *	3. 1부터 n까지 정점들을 중간에 거쳐가는 정점으로 설정하고 최소값을 찾는다!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int INF = Integer.MAX_VALUE;

		int[][] info = new int[n + 1][n + 1];
		int[][] dist = new int[n+1][n+1];

		for(int i =0; i<n+1; i++) Arrays.fill(info[i], Integer.MAX_VALUE);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()),
					cost = Integer.parseInt(st.nextToken());
			info[x][y] = Math.min(info[x][y],cost);
		}
		
		for(int i =1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				dist[i][j] = info[i][j];
				if(i==j) dist[i][j] = 0;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int x = 1; x < n + 1; x++) {
				for (int y = 1; y < n + 1; y++) {
					if(dist[x][i]==INF || dist[i][y]==INF) continue;
					dist[x][y] = Math.min(dist[x][y], dist[x][i]+dist[i][y]);
				}
			}
		}
		
		for(int i =1; i<n+1; i++) {
			for(int j =1; j<n+1; j++) {
				answer.append(dist[i][j]==INF?0:dist[i][j]).append(" ");
			}
			answer.append("\n");
		}
		System.out.println(answer);
		
	}
}
