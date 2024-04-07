//q,u,a,c,k 가 나올 때마다 글자 수를 체크한다.
//q 이후의 글자들은 수가 앞의 글자의 수를 넘게 되면 불가능으로 -1을 출력한다
//k까지 문제가 없이 나왔다면 모든 글자의 수를 -1 처리한다.
//q는 나올 때마다 q의 최대 개수를 체크한다.
//마지막에 모든 수가 0으로 끝났다면 q의 최대 개수를 출력한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String s;
	static int[] count = new int[5];
	static int ans;

	public static void main(String[] args) throws Exception {
		s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);

			if (temp == 'q') {
				count[0]++;
				ans = Math.max(ans, count[0]);
			}

			if (temp == 'u') {
				count[1]++;
				if (count[1] > count[0]) {
					System.out.println(-1);
					return;
				}
			}

			if (temp == 'a') {
				count[2]++;
				if (count[2] > count[1]) {
					System.out.println(-1);
					return;
				}
			}

			if (temp == 'c') {
				count[3]++;
				if (count[3] > count[2]) {
					System.out.println(-1);
					return;
				}
			}

			if (temp == 'k') {
				count[4]++;
				if (count[4] > count[3]) {
					System.out.println(-1);
					return;
				}

				for (int j = 0; j < 5; j++) {
					count[j]--;
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			if (count[i] != 0) {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(ans);
	}
}