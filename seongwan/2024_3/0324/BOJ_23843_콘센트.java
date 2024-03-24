import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//충전시간이 오래 걸리는 것부터 먼저 충전하는 식으로 충전기가 빌 때마다 채워넣는다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);
	static int ans;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] input = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}

		int[] charge = new int[M];
		while (!pq.isEmpty()) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < M; i++) {
				if (charge[i] == 0) {
					if (pq.isEmpty())
						break;
					charge[i] = pq.poll();
					min = Math.min(charge[i], min);
				}
			}

			ans += min;
			for (int i = 0; i < M; i++) {
				charge[i] -= min;
			}
		}

		int max = 0;
		for (int i = 0; i < M; i++) {
			max = Math.max(charge[i], max);
		}

		ans += max;
		System.out.println(ans);
	}
}