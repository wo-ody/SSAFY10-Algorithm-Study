import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {

	static int N, M, ans;
	static boolean[][] map;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			map[v1][v2] = map[v2][v1] = true;
		}
		
		dfs(1);
		
		System.out.println(ans-1);
	}
	
	static void dfs(int i) {
		ans++;
		
		visit[i] = true;
		for (int j = 1; j <= N; j++) {
			if(!visit[j] && map[i][j]) {
				dfs(j);
			}
		}
		
	}

}
