import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int M, N;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		for (int i = M; i <= N; i++) {
			if (isPrime(i))
				sb.append(i + "\n");

		}
		System.out.println(sb);

	}

	static boolean isPrime(int num) {
		if (num < 2)
			return false;
		if (num == 2 || num == 3)
			return true;
		if (num % 2 == 0)
			return false;

		int end = (int) Math.sqrt(num);
		for (int i = 3; i <= end; i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
