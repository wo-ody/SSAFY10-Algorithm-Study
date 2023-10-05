import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {

	static int N, complexCnt;
	static ArrayList<Integer> houseCnt = new ArrayList<>();
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N][N];
		complexCnt = 1;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isVisited[i][j] || map[i][j] == 0) continue;
				bfs(i, j);
//				complexCnt++;
			}
		}
		
		Collections.sort(houseCnt);
		sb.append(houseCnt.size()).append("\n");
		for (int i = 0; i < houseCnt.size(); i++) {
			sb.append(houseCnt.get(i)).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int y, int x) {
		int count = 1;
		Queue<House> queue = new ArrayDeque<>();
		queue.offer(new House(y, x));
		isVisited[y][x] = true;

		while (!queue.isEmpty()) {
			House cur = queue.poll();

			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if (isVisited[ny][nx] || map[ny][nx] == 0) continue;

				queue.offer(new House(ny, nx));
//				map[ny][nx] = complexCnt;
				isVisited[ny][nx] = true;
				count++;
			}
		}
		
		// 다음 단지 찾으러 ㄱㄱ
//		complexCnt++;
		houseCnt.add(count);
	}

	static class House {
		int y;
		int x;

		public House(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
