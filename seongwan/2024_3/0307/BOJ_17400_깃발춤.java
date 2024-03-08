import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 이용해 짝수,홀수 자리의 구간합의 크기를 노드에 저장한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static long[][] tree;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		input = new int[N + 1];
		tree = new long[4 * N][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		init(1, 1, N);

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			//query
			if (cmd == 1) {
				int qleft = Integer.parseInt(st.nextToken());
				int qright = Integer.parseInt(st.nextToken());
				long[] result = query(1, 1, N, qleft, qright);
				sb.append(Math.abs(result[0] - result[1])).append("\n");
			}
			//update
			else {
				int idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());

				update(1, 1, N, idx, value);
			}
		}
		System.out.println(sb);
	}

	static void init(int node, int left, int right) {
		if (left == right) {
			//홀수인 경우
			if (left % 2 == 1)
				tree[node][0] = input[left];
				//짝수인 경우
			else {
				tree[node][1] = input[left];
			}
			return;
		}

		int mid = (left + right) / 2;
		init(node << 1, left, mid);
		init(node << 1 | 1, mid + 1, right);

		tree[node][0] = tree[node << 1][0] + tree[node << 1 | 1][0];
		tree[node][1] = tree[node << 1][1] + tree[node << 1 | 1][1];
	}

	static void update(int node, int left, int right, int idx, int value) {
		if (left > idx || right < idx) {
			return;
		}

		if (left == right) {
			//홀수인 경우
			if (left % 2 == 1)
				tree[node][0] += value;
				//짝수인 경우
			else {
				tree[node][1] += value;
			}
			return;
		}

		int mid = (left + right) / 2;
		update(node << 1, left, mid, idx, value);
		update(node << 1 | 1, mid + 1, right, idx, value);

		tree[node][0] = tree[node << 1][0] + tree[node << 1 | 1][0];
		tree[node][1] = tree[node << 1][1] + tree[node << 1 | 1][1];
	}

	static long[] query(int node, int left, int right, int qleft, int qright) {
		//탐색 범위가 쿼리 범위랑 상관이 없는 경우
		if (qright < left || qleft > right) {
			return new long[] {0, 0};
		}

		if (qleft <= left && qright >= right) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		long[] leftResult = query(node << 1, left, mid, qleft, qright);
		long[] rightResult = query(node << 1 | 1, mid + 1, right, qleft, qright);

		return new long[] {leftResult[0] + rightResult[0], leftResult[1] + rightResult[1]};
	}
}