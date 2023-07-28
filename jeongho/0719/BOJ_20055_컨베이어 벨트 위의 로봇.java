
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_20055_컨베이어 벨트 위의 로봇 {
	static int N;
	static int K;
	static int[] conv;
	static int up;
	static int down;
	static ArrayList<Integer> robot = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// System.setIn(new
		// FileInputStream("C:\\Users\\JH\\git\\Algorithm\\Baekjoon\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		conv = new int[2 * N];
		robot = new ArrayList<>();
		up = 0;
		down = N - 1;
		s = br.readLine().split(" ");
		for (int i = 0; i < 2 * N; i++) {
			conv[i] = Integer.parseInt(s[i]);
		}

		int level = 1;

		while (true) {
			up--;
			down--;
			if (up < 0) {
				up = 2 * N - 1;
			}
			if (down < 0) {
				down = 2 * N - 1;
			}
			for (int i = 0; i < robot.size(); i++) {
				if (robot.get(i) == down) {
					robot.remove(i);
					break;
				}
			}
			// 여기까지 회전(올리는위치, 내리는 위치 변경)

			moveRobot();
			if (conv[up] > 0) {
				robot.add(up);
				conv[up]--;
			}
			if (isEnd()) {
				break;
			}
			level++;
		}
		System.out.println(level);
	}

	// 로봇 이동
	static void moveRobot() {
		for (int i = 0; i < robot.size(); i++) {
			int n = robot.get(i) + 1;
			if (n >= 2 * N)
				n = 0;
			if (!robot.contains(n) && conv[n] > 0) {
				conv[n]--;
				if (n == down) {
					robot.remove(i);
					i--;
				} else {
					robot.set(i, n);
				}
			}

		}
	}

	static boolean isEnd() {
		int cnt = 0;
		for (int i : conv) {
			if (i <= 0) {
				cnt++;
			}
		}
		if (cnt >= K) {
			return true;
		} else {
			return false;
		}
	}
}
