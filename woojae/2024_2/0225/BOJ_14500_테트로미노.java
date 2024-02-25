import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] map;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visit;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				visit[i][j] = true;
				solve(i, j, 1, map[i][j]);
				visit[i][j] = false;
			}
		System.out.println(answer);
	}
	
	static void solve(int y, int x, int depth, int max_num) {
		if(depth == 4) {
			answer = Integer.max(max_num, answer);
			return;
		}
		for (int[] d : direction) {
			int my = y + d[0];
			int mx = x + d[1];
			
			if(0 <= my && my < n && 0 <= mx && mx < m && !visit[my][mx]) {
				if(depth == 2) {
					visit[my][mx] = true;
					solve(y, x, depth+1, max_num+map[my][mx]);  // 현재 기점으로 상하좌우 추가만하고 계속 진행해야 확인 가능(ㅗ, ㅜ, ㅓ, ㅏ) 
					visit[my][mx] = false;
				}
				visit[my][mx] = true;
				solve(my, mx, depth+1, max_num+map[my][mx]);
				visit[my][mx] = false;
			}
		}
	}
}
