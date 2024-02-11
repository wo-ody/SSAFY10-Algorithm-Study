import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N, score;
	private static int[] player;
	private static boolean[] isVisited;
	private static int[][] game;
	private static int outCount;
	private static boolean[] base;

	private static void Perm(int index, int count) {

		if (count == 10) {

//			System.out.println(Arrays.toString(player));
//			System.out.println(playGame());
//			System.out.println();
			score = Math.max(score, playGame());

			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (!isVisited[i]) {

				if (count == 4) {
					count++;
				}

				player[count] = i;
				isVisited[i] = true;
				Perm(i + 1, count + 1);
				if (i != 1)
					isVisited[i] = false;
			}
		}

	}

	private static int playGame() {
		int result = 0;
		int inning = 1;

		while (true) {
			for (int p = 1; p <= 9; p++) {

				if (outCount == 3) {
					inning++;
					outCount = 0;
					Arrays.fill(base, false);
				}

				if (inning == N + 1)
					return result;

				int current = game[inning][player[p]];

				if (current == 0) {
					outCount++;
				} else {
					base[0] = true;
					result += Game(current);
					if (result == 98) {
						int a = 0;
					}
				}
			}
		}

	}

	private static int Game(int num) {

		int count = 0; // 홈에 들어온 사람 수

		for (int i = 3; i >= 0; i--) {
			if (base[i]) {
				int cur = i + num;
				if (cur > 3) {
					count++;
					base[i] = false;
				} else {
					base[i] = false;
					base[cur] = true;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		player = new int[10];
		game = new int[N + 1][10];
		base = new boolean[4];
		score = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		player[4] = 1;

		isVisited = new boolean[10];
		isVisited[1] = true;
		Perm(1, 1);

		System.out.println(score);
	}
}
