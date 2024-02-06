import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N이 8까지이므로 모든 경우의 수를 순열로 구하면서 계산식에 넣어 본 다음
//최댓값을 답으로 출력
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, ans;
	static int[] input, tgt;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		tgt = new int[N];
		input = new int[N];
		select = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		calc(0);
		System.out.println(ans);
	}

	static void calc(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int j = 0; j < N - 1; j++) {
				sum += Math.abs(input[tgt[j]] - input[tgt[j + 1]]);
			}
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!select[i]) {
				select[i] = true;
				tgt[idx] = i;
				calc(idx + 1);
				select[i] = false;
			}
		}
	}
}