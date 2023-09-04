import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static int N, M, tgt[];
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tgt = new int[M];
		visit = new boolean[N + 1];
		perm(0);
		System.out.println(sb);
	}

	static void perm(int tgtidx) {
		if (tgtidx == M) {
			for (int i : tgt) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (tgtidx >= 1) {
				if (i >= tgt[tgtidx - 1]) {
					tgt[tgtidx] = i;
					perm(tgtidx + 1);
				}

			} else {
				tgt[tgtidx] = i;
				perm(tgtidx + 1);
			}
		}

	}

}