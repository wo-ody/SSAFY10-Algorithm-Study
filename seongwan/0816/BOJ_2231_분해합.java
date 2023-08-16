import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		find(N);
		System.out.println(sb);
	}

	static void find(int num) {
		if (num == N - 60) {
			if (sb.length() == 0) {
				sb.append(0);
				return;
			} else
				return;
		}
		num--;
		int cal = num;
		int a = cal / 100_000;
		cal %= 100_000;
		int b = cal / 10_000;
		cal %= 10_000;
		int c = cal / 1_000;
		cal %= 1_000;
		int d = cal / 100;
		cal %= 100;
		int e = cal / 10;
		cal %= 10;
		int f = cal;
		if (num + a + b + c + d + e + f == N) {
			sb.setLength(0);
			sb.append(num);
			find(num);
		} else
			find(num);
	}

}
