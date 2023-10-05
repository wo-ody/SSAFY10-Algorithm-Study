import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		System.out.println(max_bags(N));

	}

	static int max_bags(int N) {
		int max5 = N / 5; // 5킬로그램 봉지의 최대 개수

		for (int i = max5; i >= 0; i--) {
			int remain = N - i * 5; // 5킬로그램 봉지를 사용한 후 남은 무게

			if (remain % 3 == 0) {
				int bag3 = remain / 3; // 3킬로그램 봉지의 개수
				return i + bag3; // 총 봉지 개수 반환
			}
		}

		return -1; //불가능한 경우
	}
}
