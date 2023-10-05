import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, src[], tgt[];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		src = new int[N];
		tgt = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		} // 뽑을 수 입력
		Arrays.sort(src);

		comb(0);
		System.out.println(sb);
	}

	static void comb(int tgtidx) {
		if (tgtidx == M) {
			for (int i : tgt) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (tgtidx > 0 && src[i] < tgt[tgtidx - 1])
				continue;
			tgt[tgtidx] = src[i];
			comb(tgtidx + 1);
		}
	}

}
