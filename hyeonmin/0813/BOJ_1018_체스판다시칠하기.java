import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {

	static int N, M, answer;
	static boolean[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];
		answer = Integer.MAX_VALUE;
		// 배열 보드 생성
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = (temp[j] == 'W') ? true : false;
			}
		}

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				check(i, j);
			}
		}
		System.out.println(answer);

	}

	static void check(int x, int y) {
		int count = 0;
		boolean color = board[x][y];
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (board[i][j] != color) {
					count++;
				}
				color = !color;
			}
			color = !color; // 8X8의 사이즈에서 현재 줄의 마지막컬러와 다음줄의 첫번째 컬러가 같아야 한다.
		}
		int minCount = Math.min(count, 64 - count);
		answer = Math.min(answer, minCount);

	}

}
