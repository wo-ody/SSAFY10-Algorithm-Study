import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0) {
				System.out.println(sb);
				return;
			}

			set.clear();
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				set.add(Integer.parseInt(br.readLine()));
			}

			for (int i = 0; i < N; i++) {
				if (set.contains(Integer.parseInt(br.readLine())))
					cnt++;
			}

			sb.append(cnt).append("\n");
		}
	}
}