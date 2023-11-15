import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, ans;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			if (set.contains(br.readLine())) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}