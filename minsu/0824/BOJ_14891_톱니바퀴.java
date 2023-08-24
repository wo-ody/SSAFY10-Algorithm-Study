package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
	static int K, ans;
	static int[][] wheel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		wheel = new int[5][9];

		for (int i = 1; i <= 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = s.charAt(j) - '0';
			}
		}

		K = Integer.parseInt(br.readLine());

		// K번만큼 회전을 시켜주면서
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 몇번 톱니바퀴를
			int w = Integer.parseInt(st.nextToken()); // 어느 방향으로
			solve(num, w);
		}

		// 총 K번만큼 회전을 다 시켰다면 점수 합산
		if (wheel[1][0] == 1) {
			ans += 1;
		}
		if (wheel[2][0] == 1) {
			ans += 2;
		}
		if (wheel[3][0] == 1) {
			ans += 4;
		}
		if (wheel[4][0] == 1) {
			ans += 8;
		}

		System.out.println(ans);
	}

	// 어떤 톱니바퀴를 회전시킬지 결정
	static void solve(int num, int w) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(num, w);
		// 1번 톱니바퀴를 회전시켜야 한다면 2, 3, 4를 순차적으로 봐주고 맞닿은 극이 같으면 stop
		if (num == 1) {
			// 2번 톱니바퀴가 도는 경우
			if (wheel[1][2] != wheel[2][6]) {
				hashMap.put(2, w * -1);
				// 3번 톱니바퀴가 도는 경우
				if (wheel[2][2] != wheel[3][6]) {
					hashMap.put(3, w);
					if (wheel[3][2] != wheel[4][6]) {
						hashMap.put(4, w * -1);
					}
				}
			}
		} else if (num == 2) {
			// 1번 톱니바퀴가 도는 경우
			if (wheel[1][2] != wheel[2][6]) {
				hashMap.put(1, w * -1);
			}
			// 3번 톱니바퀴가 도는 경우
			if (wheel[2][2] != wheel[3][6]) {
				hashMap.put(3, w * -1);
				if (wheel[3][2] != wheel[4][6]) {
					hashMap.put(4, w);
				}
			}
		} else if (num == 3) {
			// 4번 톱니바퀴가 도는 경우
			if (wheel[3][2] != wheel[4][6]) {
				hashMap.put(4, w * -1);
			}
			// 2번 톱니바퀴가 도는 경우
			if (wheel[2][2] != wheel[3][6]) {
				hashMap.put(2, w * -1);
				if (wheel[1][2] != wheel[2][6]) {
					hashMap.put(1, w);
				}
			}
		} else if (num == 4) {
			// 3번 톱니바퀴가 도는 경우
			if (wheel[3][2] != wheel[4][6]) {
				hashMap.put(3, w * -1);
				// 2번 톱니바퀴가 도는 경우
				if (wheel[2][2] != wheel[3][6]) {
					hashMap.put(2, w);
					if (wheel[1][2] != wheel[2][6]) {
						hashMap.put(1, w * -1);
					}
				}
			}
		}

		turn(hashMap);
	}

	// 톱니바퀴 회전시키기
	static void turn(HashMap<Integer, Integer> hash) {
		for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
			int row = entry.getKey(); // 몇번째 바퀴를
			int val = entry.getValue(); // 어느 방향으로 돌릴지
//			System.out.println("row= " + row);
//			System.out.println("val= " + val);

			if (val == -1) {
				int temp = wheel[row][0]; // 맨 앞의 값을 임시저장
				for (int i = 0; i < 7; i++) {
					wheel[row][i] = wheel[row][i + 1];
				}
				wheel[row][7] = temp;
			} else if (val == 1) {
				int temp = wheel[row][7];
				for (int i = 7; i > 0; i--) {
					wheel[row][i] = wheel[row][i - 1];
				}
				wheel[row][0] = temp;
			}
		}
	}
}
