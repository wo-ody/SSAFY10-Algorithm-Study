import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//느리게 갱신하는 세그먼트 트리를 이용해 구간 update를 해당 노드를 탐색할 때 진행한다.
//long형으로 진행
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static long[] tree;
	static long[] lazy;
	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		input = new int[N + 1];
		tree = new long[4 * N];
		lazy = new long[4 * N];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		init(1, 1, N);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			//update
			if (cmd == 1) {
				int qleft = Integer.parseInt(st.nextToken());
				int qright = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());

				update(1, 1, N, qleft, qright, value);
			}
			//query
			else {
				int idx = Integer.parseInt(st.nextToken());

				sb.append(query(1, 1, N, idx)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = input[left];
			return;
		}

		int mid = (left + right) >> 1;
		init(node << 1, left, mid);
		init(node << 1 | 1, mid + 1, right);

		// tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static void update(int node, int left, int right, int qleft, int qright, int value) {
		lazy_update(node, left, right);

		//상관없는 범위를 탐색하는 경우
		if (left > qright || right < qleft)
			return;

		//완전히 속하는 범위의 경우
		if (left >= qleft && right <= qright) {
			if (left != right) {
				lazy[node << 1] += value;
				lazy[node << 1 | 1] += value;
			} else {
				tree[node] += value;
			}
			return;
		}

		int mid = (left + right) >> 1;
		update(node << 1, left, mid, qleft, qright, value);
		update(node << 1 | 1, mid + 1, right, qleft, qright, value);

		// tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static void lazy_update(int node, int left, int right) {
		if (lazy[node] != 0) {

			// tree[node] += (right - left + 1) * lazy[node];

			if (left != right) {
				lazy[node << 1] += lazy[node];
				lazy[node << 1 | 1] += lazy[node];
			} else {
				tree[node] += lazy[node];
			}

			lazy[node] = 0;
		}
	}

	static long query(int node, int left, int right, int idx) {
		lazy_update(node, left, right);

		//상관없는 범위를 탐색하는 경우
		if (idx < left || idx > right) {
			return 0;
		}

		if (left == right) {
			return tree[node];
		}

		int mid = (left + right) >> 1;
		long lr = query(node << 1, left, mid, idx);
		long rr = query(node << 1 | 1, mid + 1, right, idx);

		return lr + rr;
	}
}