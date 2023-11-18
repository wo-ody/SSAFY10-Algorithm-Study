import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int temp, ans;

	public static void main(String[] args) throws Exception {
		char[] input = br.readLine().toCharArray();

		for (int i = 0; i < input.length; i++) {
			if (input[i] == '(') {
				if (input[i + 1] == ')') { // 레이저인 상황
					ans += temp;
					i++;// 레이저 부분 건너뛰고 다음 부분부터 확인
				} else// 쇠막대기의 시작부분이었던 상황
					temp += 1;
			} else {
				ans++;
				temp--;
			}
		}
		System.out.println(ans);
	}
}