import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K;
	static int x;

	public static void main(String[] args) throws IOException {
		input();
		find();
//		System.out.println(x);
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
	}

	static void find() {
		int start = 1;
		int end = K; // x를 구하는데 K보다 클 수는 없음

		while (start < end) {
			int middle = (start + end) / 2;
			int cnt = 0;

			for (int i = 1; i <= N; i++) {
				if (middle / i > N)
					cnt += N;
				else
					cnt += middle / i;
			}
			// cnt == 어떤 숫자가 나오게 되는지

			if (cnt < K) {
				start = middle + 1;
//				if(cnt == K) {
//					return;
//				}
			} else if (cnt >= K) {
//				
				end = middle;

			}

		}
		System.out.println(start);
	}
}
