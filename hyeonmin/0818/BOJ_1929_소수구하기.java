import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {

	private static int M, N;
	private static boolean[] isNotPrime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N = 100만
		// N^2 = 1조

		// 2√N = 10만
		// N * 2√N= = 1000억

		// 에라토스테네스의 체
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		isNotPrime = new boolean[N + 1];
		getPrime();
		for (int i = M; i <= N; i++) {
			if(!isNotPrime[i]) bw.write(i + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	private static void getPrime() {

		// 0과 1은 소수 아님을 표기
		isNotPrime[0] = isNotPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			// 이미 소수로 판별된건 continue
			if (isNotPrime[i]) continue;

			// 현재 소수 값 i 의 배수를 모두 false로 처리
			// i * i 아래의 소수들은 이미 false 처리가 됨 !
			for (int j = i * i; j <= N; j += i) {
				isNotPrime[j] = true;
			}

		}
	}

}
