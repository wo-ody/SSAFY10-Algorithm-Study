import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	static int R, C;
	static int[][] map;
	static boolean[] visited = new boolean[26];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans = 0;

	public static void DFS(int cx, int cy, int cnt) {
		ans = Math.max(ans, cnt);
		
		for(int k =0;k<4;k++) {
			int nx = cx + dx[k];
			int ny = cy + dy[k];
			if(nx < 0 || nx >= R || ny < 0 || ny >=C || visited[map[nx][ny]]) continue;
			visited[map[nx][ny]] = true;
			DFS(nx,ny,cnt + 1);
			visited[map[nx][ny]] = false;
		}
		
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}

		visited[map[0][0]] = true;
		DFS(0, 0, 1);

		System.out.println(ans);
	}

}
