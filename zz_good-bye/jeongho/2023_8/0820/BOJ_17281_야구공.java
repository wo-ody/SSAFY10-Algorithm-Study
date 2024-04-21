package algorithm2023.aug.day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_야구공 {
	static int N, score[][], max;
	static int[] selected = new int[9];
	static boolean[] v;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 이닝 수
		N = Integer.parseInt(br.readLine());
		score = new int[N][9];
		for (int i = 0; i < N; i++) {
			v = new boolean[9];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0);

		System.out.println(max);
	}

	static void perm(int idx) {
		if (idx == 9) {
			max = Math.max(max, game());
			return;
		}

		if (idx == 3) {
			selected[idx] = 0;
			perm(idx + 1);
		}
		for (int i = 1; i < 9; i++) {
			if (!v[i]) {
				v[i] = true;
				selected[idx] = i;
				perm(idx + 1);
				v[i] = false;
			}
		}
	}

	static int game() {
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			boolean[] base = new boolean[4];
			int out = 0;

			// 3아웃이면 이닝 종료, 타석 하나당 루프 한번
			while (out < 3) {
				int hit = score[i][selected[idx]];
				// 아웃인 경우 아웃 카운트
				if (hit== 0) {
					out++;

				// 아웃이 아닌 경우
				} else {
					//홈런
					if (hit == 4) {
						//모든 주자를 내보내고 점수 ++
						for (int j = 0; j < 4; j++) {
							if (base[j]) {
								base[j] = false;
								cnt++;
							}
						}
						//타자의 점수 ++
						cnt++;
					} else {
						//1,2,3루타
						for (int j = 3; j >=0; j--) {
							//주자가 존재한다면 
							if (base[j]) {
								//홈까지 뛰면 카운트
								if (j + hit > 3) {
									cnt++;
								//아니면 주자 이동
								} else {
									base[j + hit] = true;
								}
							}
							//원래 주자가 있던 자리는 비움.
							base[j] = false;
						}
						//타자의 자리 처리
						base[hit] = true;
					}
				}
				idx = (idx + 1) % 9;

			}
		}

		return cnt;
	}
}
