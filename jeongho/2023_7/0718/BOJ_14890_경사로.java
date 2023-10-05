import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14890_경사로 {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static int L;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new
		// FileInputStream("C:\\SSAFY\\SSAFY_LIVE\\Algorithm\\Baekjoon\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		L = Integer.parseInt(s[1]);
		map = new int[N][N];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		// 여기까지 입력

		loop: for (int i = 0; i < N; i++) {
			int cntFlat = 1;
			boolean isDown = false;
			for (int j = 1; j < N; j++) {
				int prev = map[j - 1][i];
				int cur = map[j][i];
				if (prev == cur) {
					// 평지인 경우
					cntFlat++;
					if (cntFlat > L) {
						cntFlat = L;
					}
					if (isDown && cntFlat == L) {
						isDown = false;
						cntFlat = 0;
					}
				} else if (prev - cur == 1) {
					// 내려가는 경우
					if (isDown) {
						if (cntFlat != L) {
							continue loop;
						}

					}
					isDown = true;
					cntFlat = 1;
					if (cntFlat == L) {
						isDown = false;
						cntFlat = 0;
					}
				} else if (prev - cur == -1) {
					// 올라가는 경우
					if (cntFlat == L) {

						cntFlat = 1;
					} else {
						continue loop;
					}
				} else {
					continue loop;
				}
			}
			if (!isDown) {
				cnt++;
			}
		}

		loop: for (int i = 0; i < N; i++) {
			int cntFlat = 1;
			boolean isDown = false;
			for (int j = 1; j < N; j++) {
				int prev = map[i][j - 1];
				int cur = map[i][j];
				if (prev == cur) {
					// 평지인 경우
					cntFlat++;
					if (cntFlat > L) {
						cntFlat = L;
					}
					if (isDown && cntFlat == L) {
						isDown = false;
						cntFlat = 0;
					}
				} else if (prev - cur == 1) {
					// 내려가는 경우
					if (isDown) {
						if (cntFlat != L) {
							continue loop;
						}

					}
					isDown = true;
					cntFlat = 1;
					if (cntFlat == L) {
						isDown = false;
						cntFlat = 0;
					}
				} else if (prev - cur == -1) {
					// 올라가는 경우
					if (cntFlat == L) {

						cntFlat = 1;
					} else {
						continue loop;
					}
				} else {
					continue loop;
				}
			}
			if (!isDown) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}