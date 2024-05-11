import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int ans = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e2[0] - e1[0]);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		for (int i = 0; i < 4; i++) {
			pq.poll();
		}

		int score = pq.poll()[0];

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int tempScore = temp[0];

			if (tempScore < score)
				break;

			ans++;
		}
		System.out.println(ans);
	}
}