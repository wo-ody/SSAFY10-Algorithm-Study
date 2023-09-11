package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2468 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int max_height;
	static int current_height;
	static int target;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		max_height = 0;	
		answer = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max_height = max_height < map[i][j] ? map[i][j] : max_height;
			}
		}
		
		for(int i = 0; i < max_height; i++) {  // 모든 높이에 대해서
			current_height = 0;
			target = i;
			visit = new boolean[n][n];
			for(int j = 0; j < n; j++)
				for(int k = 0; k < n; k++)
					if(!visit[j][k] && map[j][k] > i) {  // 유효범위 내에 해당하며 아직 방문하지 않은 경우
						current_height++;
						dfs(j, k);
					}
			answer = answer < current_height ? current_height : answer;
		}
		System.out.println(answer);
	}
	
	static void dfs(int y, int x) {
		if(0 <= y && y < n && 0 <= x && x < n && !visit[y][x] && map[y][x] > target) {  // 유효범위 내라면
			visit[y][x] = true;
			dfs(y - 1, x);
			dfs(y + 1, x);
			dfs(y, x - 1);
			dfs(y, x + 1);
		}
	}

}
