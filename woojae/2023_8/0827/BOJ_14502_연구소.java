import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int n, m;
	static int[][] maps;
	static boolean[][] visit;
	static int answer;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maps = new int[n][m];
		visit = new boolean[n][m];
		answer = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if(maps[i][j] != 0)
					visit[i][j] = true;
			}
		}
		dfs(0);
		System.out.println(answer);
	}
	
	static void dfs(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(!visit[i][j]) {
					visit[i][j] = true;
					dfs(wall + 1);
					visit[i][j] = false;
				}
	}

	static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] origin = new boolean[n][m];
		for(int i = 0; i < n; i++) origin[i] = visit[i].clone();
		int check = 0;
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(maps[i][j] == 2)
					q.add(new int[] {i, j});
		
		while(!q.isEmpty()) {
			int[] cord = q.poll();
			int y = cord[0];
			int x = cord[1];
			
			for (int[] d : direction) {
				int my = y + d[0];
				int mx = x + d[1];
				if(0 <= my && my < n && 0 <= mx && mx < m && !origin[my][mx]) {
					origin[my][mx] = true;
					q.add(new int[] {my, mx});
				}
			}
		}
		
		for (boolean[] i : origin)
			for (boolean j : i)
				if(j == false) check++;
		answer = answer < check ? check : answer;
	}
}