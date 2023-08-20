package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_야구공 {
	static int n, ans; // 이닝 수
	static int[] tgt; // 9명의 타선 정보
	static int[] src; // np를 만들기 위해 사용 1~9번까지 넣어두고
	static int[][] players; // 9이닝에 대한 9명 선수들의 정보

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		players = new int[n + 1][10]; // 1이닝부터 9이닝까지 1번부터 9번선수 기록
		StringTokenizer st;
		src = new int[9];

		for (int i = 0; i < 9; i++) {
			src[i] = i + 1;
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 타석을 정해준 다음
		// np를 이용해서 타석을 정했다면 4번 타자가 1번인 경우에만 보내준다.
		while (true) {
			if (src[3] == 1) {
				cal(src);
			}

			if (!np()) {
				break;
			}
		}

		System.out.println(ans);
	}

	static boolean np() {
		// 3가지 기억할 것
		// 1. 앞에서 교환되어야 하는 인덱스 & 작업
		int i = src.length - 1;
		// 오름차순이었다가 꺽이는 부분이 생길때까지 반복
		while (i > 0 && src[i - 1] >= src[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}
		// 2. 뒤에서 교환되어야 하는 인덱스 & 작업
		int j = src.length - 1;
		while (j > i - 1 && src[i - 1] >= src[j]) {
			j--;
		}
		// 3. 교환 후 뒤쪽을 작은수로 정리
		int temp = src[i - 1];
		src[i - 1] = src[j];
		src[j] = temp;
		Arrays.sort(src, i, src.length);

		return true;
	}

	// 정해진 타석에 따라서 플레이어 정보에 따라 게임 실시하고 점수 계산
	static void cal(int[] p) {
		int score = 0;
		int start = 1;

		for (int i = 1; i <= n; i++) {
			int out = 0;
			boolean[] base = new boolean[4]; // 1~4루까지 사람이 있는지 확인해서 점수 계산을 해줄려고

			outer: while (true) {
				// 1번부터 9번타석까지 이닝이 종료될때까지 반복
				for (int j = start; j <= 9; j++) {
					int hit = players[i][p[j - 1]]; // i이닝당 j번째 타석 선수가 치는 정보

					switch (hit) {
					case 0: // 그냥 아웃
						out++;
						break;
					case 1: // 1루타
						// 3루부터 확인해서 주자가 있으면 점수 추가해주고 주자 없는걸로 처리해주고
						if (base[3]) {
							score++;
							base[3] = false;
						}
						if (base[2]) {
							base[2] = false;
							base[3] = true;
						}
						if (base[1]) {
							base[2] = true;
							base[1] = false;
						}
						base[1] = true;
						break;
					case 2: // 2루타
						if (base[3]) {
							score++;
							base[3] = false;
						}
						if (base[2]) {
							score++;
							base[2] = false;
						}
						if (base[1]) {
							base[3] = true;
							base[1] = false;
						}
						base[2] = true;
						break;
					case 3: // 3루타
						if (base[3]) {
							score++;
							base[3] = false;
						}
						if (base[2]) {
							score++;
							base[2] = false;
						}
						if (base[1]) {
							score++;
							base[1] = false;
						}
						base[3] = true;
						break;
					case 4: // 홈런
						if (base[3]) {
							score++;
							base[3] = false;
						}
						if (base[2]) {
							score++;
							base[2] = false;
						}
						if (base[1]) {
							score++;
							base[1] = false;
						}
						score++;
						break;
					}

					if (out == 3) {
						start = j + 1;
						if (start == 10) {
							start = 1;
						}
						break outer;
					}
				}
				
				start = 1;
			}
		}

		ans = Math.max(ans, score);
	}
}
