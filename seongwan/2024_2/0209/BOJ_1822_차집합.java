import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer> ans = new ArrayList<>();
		for (Integer i : A) {
			if (!B.contains(i)) {
				ans.add(i);
			}
		}

		Collections.sort(ans);

		sb.append(ans.size() + "\n");
		for (Integer an : ans) {
			sb.append(an + " ");
		}
		System.out.println(sb);
	}
}