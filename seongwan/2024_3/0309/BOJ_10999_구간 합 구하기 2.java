import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//lazy 세그먼트 트리를 이용하여 구간 합을 업데이트하고 노드에 저장한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] input;
	static long[] tree;
	static long[] lazy;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		input = new long[N + 1];
		tree = new long[4 * N];
		lazy = new long[4 * N];

		for (int i = 1; i <= N; i++) {
			input[i] = Long.parseLong(br.readLine());
		}

		init(1, 1, N);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			//update
			if (cmd == 1) {
				int qleft = Integer.parseInt(st.nextToken());
				int qright = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());

				update(1, 1, N, qleft, qright, value);
			}
			//query
			else {
				int qleft = Integer.parseInt(st.nextToken());
				int qright = Integer.parseInt(st.nextToken());
				sb.append(query(1, 1, N, qleft, qright) + "\n");
			}
		}
		System.out.print(sb);
	}

	static void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = input[left];
			return;
		}

		int mid = (left + right) / 2;
		init(node << 1, left, mid);
		init(node << 1 | 1, mid + 1, right);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static void update(int node, int left, int right, int qleft, int qright, long value) {
		lazy_update(node, left, right);
		//상관이 없는 범위
		if (qleft > right || qright < left) {
			return;
		}

		if (qleft <= left && qright >= right) {
			tree[node] += (right - left + 1) * value;

			if (left != right) {
				lazy[node << 1] += value;
				lazy[node << 1 | 1] += value;
			}
			return;
		}

		int mid = (left + right) / 2;
		update(node << 1, left, mid, qleft, qright, value);
		update(node << 1 | 1, mid + 1, right, qleft, qright, value);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static void lazy_update(int node, int left, int right) {
		if (lazy[node] != 0) {
			tree[node] += (right - left + 1) * lazy[node];

			if (left != right) {
				lazy[node << 1] += lazy[node];
				lazy[node << 1 | 1] += lazy[node];
			}

			lazy[node] = 0;
		}
	}

	static long query(int node, int left, int right, int qleft, int qright) {
		lazy_update(node, left, right);
		if (qleft > right || qright < left) {
			return 0;
		}

		if (left >= qleft && right <= qright) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		long leftResult = query(node << 1, left, mid, qleft, qright);
		long rightResult = query(node << 1 | 1, mid + 1, right, qleft, qright);

		return leftResult + rightResult;
	}
}