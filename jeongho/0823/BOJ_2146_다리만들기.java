package algorithm2023.aug.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {
	static int N, map[][];

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static int min = Integer.MAX_VALUE;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		/*입력 종료*/
		
		//각 섬에 번호를 매겨줌. BFS 사용
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					map[i][j]+=num;
					Queue<Idx> q = new LinkedList<>();
					boolean[][] v = new boolean[N][N];
					q.add(new Idx(i, j));
					v[i][j] = true;
					while (!q.isEmpty()) {
						Idx cur = q.poll();
						for (int d = 0; d < 4; d++) {
							int ny = cur.y + dy[d];
							int nx = cur.x + dx[d];
							if (!isValid(ny, nx))
								continue;
							if (v[ny][nx])
								continue;
							if (map[ny][nx] == 1) {
								map[ny][nx] +=num;
								q.offer(new Idx(ny, nx));
								v[ny][nx] = true;
							}
						}
					}
					num++;
				}
				
			}
		}
		
		//섬이 있는 지역부터 다른 섬으로 가는 최단 경로를 BFS를 사용하여 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(min);
		

	}

	//다른 섬까지 BFS
	static void bfs(int y, int x) {

		Queue<Idx> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		q.add(new Idx(y, x));
		v[y][x] = true;
		
		//depth -> 다리의 길이
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Idx cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];
					//boundary check , 같은 섬이면 탐색 x
					if (!isValid(ny, nx)||map[ny][nx]==map[y][x])
						continue;
					//방문 체크
					if (v[ny][nx])
						continue;
					//다른 섬인 경우 최소값 갱신
					if (map[ny][nx] > 0) {
						min = Math.min(min, depth);
						return;
					}
					
					//0인 경우 == 바다 -> 다리 놓음.
					q.offer(new Idx(ny, nx));
					v[ny][nx] = true;
				}
			}
			depth++;

		}

	}

	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || x >= N || y >= N)
			return false;
		return true;
	}

	static class Idx {
		int y;
		int x;

		public Idx(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
