package studyAuthenticating.kruskal;

import java.util.*;
import java.io.*;

public class BOJ_2468_안전_영역 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	static boolean[][] visited;
	static int count, n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int maxHeight = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				maxHeight = (map[i][j] > maxHeight) ? map[i][j] : maxHeight;
			}			
		}
		System.out.println(maxHeight);
//		for(int[] maps : map) {
//			System.out.println(Arrays.toString(maps));
//		}
		
		count = 0;
		for(int height = 0; height < maxHeight + 1; height++) {
			visited = new boolean[n][n];
			int cnt = 0;
			for(int i = 0; i <n; i++) {
				for(int j = 0; j<n; j++) {
					if(!visited[i][j] && map[i][j] > height) cnt += bfs(i,j,height);
				}
			}
			count = Math.max(count, cnt);
		}
		System.out.println(count);
	}

	static int bfs(int x, int y, int height) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int[] qPoll = queue.poll();
			int a = qPoll[0];
			int b = qPoll[1];
			for (int i = 0; i < 4; i++) {
				int nx = a + dx[i];
				int ny = b + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n ) continue;
				if (visited[nx][ny]) continue;
				
				if(map[nx][ny] > height) {
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}
			}
		}
		return 1;
	}
}
