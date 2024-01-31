import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int tgt[];
	static int N;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		tgt = new int[N];
		select = new boolean[N + 1];
		perm(0);
		System.out.println(sb);

	}

	static void perm(int idx) {
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				sb.append(tgt[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!select[i]) {
				tgt[idx] = i;
				select[i] = true;
				perm(idx + 1);
				select[i] = false;
			}
		}
	}
}