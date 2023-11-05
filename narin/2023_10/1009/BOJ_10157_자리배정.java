import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt();
		int R = sc.nextInt();

		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int[][] seat = new int[R][C];
		boolean[][] isVisited = new boolean[R][C];
		int K = sc.nextInt();

		int x = R - 1, y = 0;
		int d = 0;

		seat[x][y] = 1;
		isVisited[x][y] = true;

		for (int i = 1; i < K; i++) {

			int nx = x + delta[d][0];
			int ny = y + delta[d][1];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C || isVisited[nx][ny]) {
				d = (d + 1) % 4;

				nx = x + delta[d][0];
				ny = y + delta[d][1];
			}

			seat[nx][ny] = seat[x][y] + 1;
			isVisited[nx][ny] = true;

			x = nx;
			y = ny;

		}

		if (C * R < K) {
			System.out.println(0);
		} else {
			System.out.println((y + 1) + " " + (R - x));
		}

	}
}
