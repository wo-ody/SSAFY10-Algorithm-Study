package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5525_IOIOI {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int M = Integer.parseInt(br.readLine());

		String S = br.readLine();
		// IOI가 얼마나 길게 나오는지를 확인하면 되지 않을까
		// 나오는 길이에 따라 정할 수 있는 경우가 나뉠 것 같음

		int[] answer = new int[M];
		int idx = 0;

		boolean flagForStart = false;
		boolean flagForO = false;

		int IOlengh = 0;
		for (int i = 0; i < M; i++) {
			if (S.charAt(i) == 'I') {
				if (flagForStart) { // IO가진행되는 중
					if (flagForO == false) { // O가 와야하는 차례가 아님 ( 1이 와야하는 차례)
						IOlengh++;
						flagForO = true;
					} else { // 잘못된겨
						answer[idx++] = IOlengh; // 지금까지의 값을 저장해
						IOlengh = 0; // 초기화
						flagForO = true; // 잘못됐지만 이 다음부터는 연결될수도

					}

				} else { // 처음 시작하는 IO
					flagForStart = true;
					flagForO = true; // 다음은 O가 와야지
					IOlengh = 0; // 초기화
				}
			} else { // O가 나옴
				if (!flagForStart)
					continue; // 더 이상 볼 필요 없음
				else {
					if (flagForO) { // O가 올 차례
						flagForO = false;
					} else {// O가 올 차례가 아님
						answer[idx++] = IOlengh;
						IOlengh = 0;
						flagForO = false;
						flagForStart = false;

					}
				}
			}
		}
		if (flagForStart) {
			answer[idx++] = IOlengh;
		}
		System.out.println(Arrays.toString(answer));
		int sum = 0;
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] - (N - 1) > 0) {
				sum += answer[i] - (N - 1);
			}
		}
		System.out.println(sum);
	}
}
