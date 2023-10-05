import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] map;
	static int cnt;
	static int sR, sC;// 8x8시작점
	static int N, M;
	static int min = 1250;

	public static void main(String[] args) throws IOException {
		setting();
		for (int i = 0; i < N - 7; i++) {
			sR = i;
			for (int j = 0; j < M - 7; j++) {
				sC = j;
				B_start();
				min = Math.min(min, cnt);
				W_start();
				min = Math.min(min, cnt);
				//입력된 맵에서 시작점을 달리하면서 B로 시작했을 때와 W로 시작했을 때 바꿔야하는 개수의 최솟값 구함
			}

		}
		System.out.println(min);
	}

	static void setting() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);

			}

		}

	}// 입력 값을 받고 맵 구성

	static void is_B(int i, int j) {
		if (map[i][j] == 'W')
			cnt++;// B가 아니면 바꿔야하는 개수 +1
	}

	static void is_W(int i, int j) {
		if (map[i][j] == 'B')
			cnt++;// W가 아니면 바꿔야하는 개수 +1
	}

	static void B_start() {
		cnt = 0;
		for (int i = sR; i < sR + 8; i++) {
			for (int j = sC; j < sC + 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0)
						is_B(i, j);
					else
						is_W(i, j);

				} else {
					if (j % 2 == 0)
						is_W(i, j);
					else
						is_B(i, j);
				}
			}

		}
	}//처음이 B로 시작했을 때의 바꿔야하는 개수 

	static void W_start() {
		cnt = 0;
		for (int i = sR; i < sR + 8; i++) {
			for (int j = sC; j < sC + 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0)
						is_W(i, j);
					else
						is_B(i, j);

				} else {
					if (j % 2 == 0)
						is_B(i, j);
					else
						is_W(i, j);
				}
			}

		}
	}//처음이 W로 시작했을 떄의 바꿔야하는 개수

}
