import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, K;
	static Map<String, Integer> map = new HashMap<>();
	static StringTokenizer st;
	static int fixScore, minScore, maxScore;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < K; i++) {
			String subject = br.readLine();
			fixScore += map.get(subject);
			map.remove(subject);
		}

		List<Integer> scores = new ArrayList<>(map.values());

		scores.sort((e1, e2) -> e1 - e2);

		for (int i = 0; i < M - K; i++) {
			minScore += scores.get(i);
			maxScore += scores.get(scores.size() - 1 - i);
		}

		System.out.println((minScore + fixScore) + " " + (fixScore + maxScore));
	}
}