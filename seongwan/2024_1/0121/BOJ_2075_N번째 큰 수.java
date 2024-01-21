import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//밑의 N개의 수를 pq에 넣고 pq에서 하나씩 빼면서
//빠진 수의 바로 위 숫자를 넣는 식으로 N번째 큰 수를 구함
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e2[2] - e1[2]);
	static int N, ans;
	static int[][] input;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		input = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			pq.add(new int[] {N - 1, i, input[N - 1][i]});
		}

		for (int i = 0; ; i++) {
			if (i == N - 1) {
				ans = pq.poll()[2];
				break;
			}

			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			if (r == 0)
				continue;
			pq.add(new int[] {r - 1, c, input[r - 1][c]});
		}

		System.out.println(ans);
	}
}