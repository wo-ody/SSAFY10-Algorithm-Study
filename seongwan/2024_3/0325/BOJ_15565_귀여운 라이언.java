import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//개수 이하면 right++ 개수가 채워졌을 때 left++하는 식으로
//다 돌면서 1의 개수가 K개 이상일 때 제일 작은 right-left+1의 값을 구한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] doll;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		doll = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			doll[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		int cnt = 0;
		if (doll[0] == 1)
			cnt++;

		while (true) {
			if (cnt == K) {
				min = Math.min(min, right - left + 1);

				if (doll[left] == 1)
					cnt--;

				left++;
			} else {
				if (right == N - 1)
					break;

				right++;

				if (doll[right] == 1)
					cnt++;
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}