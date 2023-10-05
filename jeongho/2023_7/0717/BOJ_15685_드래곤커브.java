import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_15685_드래곤커브 {

	static StringBuilder sb = new StringBuilder();

	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[101][101];
		for (int n = 0; n < N; n++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			int g = Integer.parseInt(s[3]);
			map[y][x] = true;
			check(map, getDirection(d, g), x, y);

		}
		System.out.println(cntSquare(map));

	}

	static ArrayList<Integer> getDirection(int d, int g) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(d);
		for (int i = 0; i < g; i++) {
			for (int j = arr.size() - 1; j >= 0; j--) {
				arr.add((arr.get(j) + 1) % 4);
			}
		}
		return arr;
	}

	static void check(boolean[][] map, ArrayList<Integer> arr, int x, int y) {
		for (int d : arr) {
			x += dx[d];
			y += dy[d];
			map[y][x] = true;
		}
	}

	static int cntSquare(boolean[][] map) {
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j + 1] && map[i + 1][j] && map[i][j + 1]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
