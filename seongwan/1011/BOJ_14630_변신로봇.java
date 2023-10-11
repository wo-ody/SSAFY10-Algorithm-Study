import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static String[] input;
	static int[][] mat;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		input = new String[N + 1];
		visit = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			input[i] = br.readLine();
		}
		int size = input[1].length();// 부품의 길이 파악

		mat = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				int temp = 0;
				for (int k = 0; k < size; k++) {
					int num = (input[i].charAt(k) - '0') - (input[j].charAt(k) - '0');
					temp += num * num;
				}
				mat[i][j] = mat[j][i] = temp;
			}
		} // 인접행렬

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijk(start, end);
	}

	static void dijk(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		pq.add(new int[] { start, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int from = cur[0];
			int cost = cur[1];
			visit[from] = true;
			if (from == end) {
				System.out.println(cost);
				return;
			}
			for (int i = 1; i <= N; i++) {
				if (!visit[i])
					pq.add(new int[] { i, cost + mat[from][i] });
			}
		}

	}
}