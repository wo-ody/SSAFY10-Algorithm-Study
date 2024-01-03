package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	// 이 문제는 dfs, bfs같은 문제가 아니라 그냥 끝까지 가는 문제인 것 같음
	// 여기서 기본적으로 위로 이동하는데, 왼쪽이나 오른쪽으로 갈 수 있으면
	// 그 방향으로 진행하는 것 같음.
	static int TEST_CASE = 10;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static BufferedReader br;
	static StringTokenizer st;
	static int SIZE = 100;
	static int[][] graph;
	static int[][] directions = { { -1, 0 }, { 0, 1 }, { 0, -1 } }; // 위,오,왼

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new FileReader("input.txt"));
		for (int t = 1; t <= TEST_CASE; t++) {
			br.readLine();

//			int size = st.countTokens();

			int goal_y = -1;
			graph = new int[SIZE][SIZE];
			for (int i = 0; i < SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < SIZE; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if (graph[i][j] == 2) {
						goal_y = j;
					}
				}
			}
			// 집어넣었으니까 이제 탐색하자
			// 백트래킹 하면 될듯

			int start_x = SIZE - 1;
			int start_y = goal_y;

			System.out.print("#" + t + " " + travel(start_x, start_y, 0));
			System.out.println();
		}
	}

	// 그냥 재귀로 풀지말자

	static int travel(int x, int y, int direction) {
		if (x == 0) {
			return y;
		}
		if (direction == -1) {
			return travel(x - 1, y, 0);
		} else if (direction == 0) { // 위로 올라가던 중이라면 --> 왼쪽이나 오른쪽을 확인해봄
			for (int i = 1; i <= 2; i++) {
				int nx = directions[i][0] + x;
				int ny = directions[i][1] + y;
				if (0 <= nx && nx < SIZE && 0 <= ny && ny < SIZE) {
					if (graph[nx][ny] == 1) { // 다른 방향으로 갈 수 있을 때
						return travel(nx, ny, i); // 그쪽으로 간다.
					}
					// 아니면 신경쓸 필요 없고 --> 위로 이동
				}
			}

			return travel(x - 1, y, 0); // 위로 이동
		} else { // 위로 이동하는 중이 아님 --> 위로도 올라갈 수 있는지 먼저 확인해보자

			{
				int nx = directions[0][0] + x;
				int ny = directions[0][1] + y;
				if (0 <= nx && nx < SIZE && 0 <= ny && ny < SIZE) {
					if (graph[nx][ny] == 1) { // 위로 갈 수 있으면 위로
						return travel(nx, ny, 0);
					}
				}
			}

			int nx = directions[direction][0] + x;
			int ny = directions[direction][1] + y;

			if (0 <= nx && nx < SIZE && 0 <= ny && ny < SIZE) {
				if (graph[nx][ny] == 1) { // 계속 이동해도 좋다.
					return travel(nx, ny, direction);
				}
			}
			// 해당 방향으로 더 이상 이동하면 안되는거지
			// 그럼 위로 이동
			return travel(x, y, -1); // 무조건 위로 가야함.
		}
	}
}
